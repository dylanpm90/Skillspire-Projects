# Week 7 Worksheet: Transactions with Spring JDBC — help guide

Class edition · November 6, 2026 · v3

This guide explains five ideas used throughout the worksheet: the proxy, checked vs unchecked exceptions, propagation, isolation, and `TransactionTemplate`. Use the explanations and class-code experiments to work out your answers. You do not need to complete every experiment; focus on the questions you are unsure about.

One reminder from the Spring Boot lessons: a **bean** is an object managed by Spring. `@Service` marks a class for Spring to find and create, and Spring supplies the beans its constructor needs. That's how `TransferController` gets its `BankService`.

How to use this:

1. Find a relevant section using the question numbers listed under its heading.
2. Read the explanation, and use a "Try it" in your `tesla` project if you need to see the behavior.
3. Revise your answers and bring any remaining questions to class or lab.

Question numbers count the worksheet's questions in page order (Q1 to Q46), then Challenges C1 to C3 and Reflections R1 and R2. These numbers are added for this guide; the worksheet may not display them. This is a help guide for the trickier topics, not a replacement for completing the whole worksheet.

## Before you start: your tesla project is your lab

Friday's files (`Week7_Fri_Starter.zip`, LMS > Files) give you `BankService`, `TransferController` and the `accounts` table inside `tesla`. With TODO 1 and TODO 2 done:

- Every restart resets the balances to Alice 2000, Bob 500. `/accounts/total` should show `2500.0`; a correct transfer never changes it.
- Send a transfer with Apidog: `POST /transfer?from=1&to=2&amount=1500`. Then check `/accounts` and `/accounts/total`. Use the port shown in your startup log.
- Keep `logging.level.org.springframework.jdbc=DEBUG` in `application.properties` (Friday's README step 4), and search the console for "transaction", "commit" or "rollback" (Ctrl+F) to see Spring begin, commit or roll back. If you don't see those lines, also add `logging.level.org.springframework.transaction=TRACE` and restart.

The comments in Friday's `BankService.java` and `TransferController.java` marked "EXPLAIN WHAT CHANGED" and "EXTRA" are ready-made experiments. Several "Try it" items below use them.

Make one experiment's changes at a time, and undo them before starting the next one. After completing TODO 1 and TODO 2, a transfer of 100 should move money while keeping the total at `2500.0`; a transfer of 1500 should fail without changing either balance.

## 1. The picture behind most of your questions: the proxy

**Q5, Q6, Q7, Q14, Q25 to Q27, Q30, Q38, Q39, Q41**

In our proxy-based setup, Spring does not rewrite your `BankService` source code. At startup (the Big Picture map, step 3, from Introduction to Spring Boot), once `@Transactional` is added, it creates a **proxy**: a generated object that stands in front of your `BankService`. A controller that receives this bean from Spring gets the proxy. In Friday's demo, the startup line changed to something like `TransferController got a BankService$$SpringCGLIB$$0`. That `$$SpringCGLIB$$` class is the proxy.

Think of the proxy as a wrapper around a transactional call. Here is the idea as pseudo-code, using the inheritance and overriding you know from Week 5. It assumes no transaction is already running; joining an existing transaction is covered in section 3. It shows the behavior, not Spring's actual code (it wouldn't compile as written), and you never write it yourself:

```java
// PSEUDO-CODE: the idea of the proxy, simplified
class BankServiceProxy extends BankService {
    BankService real;                     // your object, created by Spring
    PlatformTransactionManager manager;   // made by Spring Boot

    @Override
    public void transfer(long from, long to, double amount) {
        tx = manager.begin();               // BEGIN (this sketch assumes no existing transaction)
        try {
            real.transfer(from, to, amount);  // YOUR method runs here, on your own object
        } catch (exception e) {
            // the rollback rules (section 2) decide: manager.rollback(tx) or manager.commit(tx)
            throw e;                          // the caller still gets the exception
        }
        manager.commit(tx);                   // normal return: COMMIT (unless marked rollback-only)
    }
}
```

**Where `PlatformTransactionManager` "happens" (Q5).** With `@Transactional`, you do not call it directly. The proxy does: it asks the manager to begin, commit or roll back, and the manager does it on the database connection. The lines in Friday's log (`Creating new transaction...`, `Initiating transaction rollback`, `...commit`) are the manager at work.

**Who set all this up? (Q6, Q7)** In `tesla`, no manual transaction setup was needed: Friday's 1500 transfer rolled back once `@Transactional` was added. Look at the Big Picture map, step 2: Spring Boot adds its own beans because of the libraries in `pom.xml`. Which library in `tesla`'s `pom.xml` brought `JdbcTemplate`? Ask yourself what else Boot created for you when it saw that library and a database. For Q7: in plain Spring, without Boot, you switch this proxy machinery on yourself with an annotation on a `@Configuration` class. `@Configuration` alone doesn't do it.

The sketch has three consequences. They explain most of the worksheet.

**Consequence A: the proxy applies exception rules to what leaves your method (Q14, Q38).** It sees one of two things: a normal return, or an exception that *leaves* your method. If you catch an exception inside `transfer` and don't throw it again, the proxy sees a normal return. Unless the transaction is already marked rollback-only, it can commit. Look at the sketch to see why the catch in Friday's experiment allows a partial transfer to commit. Section 3 explains how an inner REQUIRED call can mark a shared transaction rollback-only even if its exception is later caught.

> **Try it:** Friday's `BankService.java` has an "EXPLAIN WHAT CHANGED" comment that wraps the method body in a `try`/`catch`. Do it, restart, send 1500, then check `/accounts/total` and the log. For Q38's "how to fix": what would make the exception leave the method again?

**Consequence B: self-invocation skips the called method's transactional settings (Q25 to Q27, Q30).** When `TransferController` calls `bank.transfer(...)`, `bank` is the proxy, so the call goes through the proxy's code. But inside your class, a call like `transfer(...)` really means `this.transfer(...)`, and `this` is `real`, your own object, not the proxy. That call skips the proxy's code entirely. If the calling method already has a transaction, the helper still runs within it; the helper's own annotation is not applied. If no transaction is running, self-invocation does not start one.

> **Try it:** in `TransferController.java`, follow the "EXTRA SPOT THE BUG" comment: change `bank.transfer(` to `bank.transferFromInside(`. Restart, send 1500, check the money and search the log for "Creating new transaction". Then answer Q25 and Q26.

Keep this in mind for the audit method in Q30 and Challenge 1: if it lives in the same class as `transfer`, how would `transfer` call it?

**Consequence C: a repository call can start a transaction or join one (Q39).** With no existing transaction, a transactional repository call using default REQUIRED propagation starts and finishes its own transaction. With an existing transaction, it joins that transaction. In our JDBC setup, outside a transaction each `JdbcTemplate` statement auto-commits; that is why Friday's first 1500 transfer, without `@Transactional`, lost money. For Q39, read it carefully: which method has `@Transactional`, the service's or the repository's? Does the call go from one bean to another (through a proxy)? Then picture a service with no transaction calling *two* transactional repository methods and the second one failing. How many transactions were there, and what happened to the first one's work?

**Two kinds of proxy (Q41).** The sketch *extends* `BankService`: a class-based proxy, which is what `$$SpringCGLIB$$` means. The other kind of proxy *implements an interface*, so callers use the methods that interface declares. Modern Spring supports `@Transactional` on interfaces with both proxy types, but Spring recommends putting it on the concrete class or its methods. Interface annotations can document a shared contract; concrete-class annotations make the implementation's settings explicit. Our `BankService` has no interface, so annotate the class or method.

## 2. Exceptions: checked vs unchecked

**Q9, Q10, Q11, Q13, Q28, Q29, Q31, Q32, Q33, Q42, Q46**

Every exception class has parents. Which parent it has decides whether it is **checked** or **unchecked**:

```text
Throwable
 +-- Error                                    unchecked
 +-- Exception                                checked
      +-- IOException                         checked
      +-- RuntimeException                    unchecked (and every class below it)
           +-- ArithmeticException            (Week 2: divide by zero)
           +-- IllegalArgumentException
           |    +-- NumberFormatException     (Integer.parseInt("abc"))
           +-- DataAccessException            (Spring JDBC lesson, Part 6)
                +-- ... EmptyResultDataAccessException (Wednesday's /vehicles/99)
```

- **Checked:** the compiler makes you deal with it. A method that lets one escape must declare it with `throws`, and each caller must then either catch it or declare it too.
- **Unchecked:** the compiler doesn't care. You may catch it, but nothing forces you. That's what the Spring JDBC lesson's Part 6 means when it says the `DataAccessException` family is unchecked and you aren't forced to catch it.

```java
// Checked: without "throws IOException" this doesn't compile.
String firstLine(Path file) throws IOException {
    return Files.readAllLines(file).get(0);
}

// Unchecked: compiles without "throws", even though it can fail at runtime.
int parse(String text) {
    return Integer.parseInt(text);    // "abc" -> NumberFormatException
}
```

To find out which kind a class is, open its parents: in IntelliJ, put the cursor on the class name and press Ctrl+H (Type Hierarchy), or Ctrl+click it.

**What this has to do with transactions.** The sketch in section 1 asks "do the rollback rules say roll back for this exception?" By default the answer depends on the exception's kind. `rollbackFor` and `noRollbackFor` change the default: `rollbackFor` *adds* exception types that cause a rollback; `noRollbackFor` *takes* exception types out. When rules overlap, the more specific matching exception type wins. Q10 and Q13 use these settings.

> **Try it (Q11):** in Friday's `BankService`, with `@Transactional` on, send 1500 and note `/accounts/total`. Then follow the second "EXPLAIN WHAT CHANGED" comment: change `new RuntimeException(` to `new Exception(`. Read the red line first: that is the compiler enforcing a checked exception, and seeing it is part of the point. Then, as the comment says, use Alt+Enter, "Add exception to method signature", on the method and on each caller that turns red, just enough to make it run. Restart, send 1500 again, note the total. Which kind of exception rolled back by default? That's Q11. Undo the changes afterwards.

- **Q9 and Q28:** run Q9 for real (1500, with `@Transactional`) and write down both balances and *why* they ended that way. Q28 has the same shape with `credits` and `charging_history`.
- **Q32:** is `IllegalArgumentException` checked or unchecked? Find it in the tree above, then the default rules answer Q32. To check: add your validation line and send `amount=-50`.
- **Q33:** make only the annotation change requested: keep the work when `IllegalArgumentException` is thrown. Think about what that means for the first UPDATE if validation happens after it. Would a bank want that behavior?
- **Q31:** paste your method into `tesla` and let IntelliJ help you check syntax. The question also asks for the imports: compare with the import lines at the top of Friday's `BankService.java`. One more thing to think about: is it better to validate before the first UPDATE or after it?

## 3. Propagation: when one transactional method calls another

**Q15 to Q18, Q30, Q43, Q45, R2**

Propagation answers one question: "A `@Transactional` method is called while a transaction is already running. Does it join that transaction, or not?" You can see the default in Friday's log line: `PROPAGATION_REQUIRED`.

Picture an outer method that calls an inner method in another bean. Then ask two questions about each setting: what if the *inner* part fails, and what if the *outer* part fails later?

- **REQUIRED** (the default): the inner method joins the outer transaction. It's all one unit. If an exception that matches the rollback rules leaves the inner method through its proxy, the shared transaction is marked rollback-only. Even if the outer method catches that exception, the transaction cannot commit; trying to commit it normally produces an `UnexpectedRollbackException`.
- **REQUIRES_NEW**: the outer transaction is paused, and the inner method runs in its own, separate transaction that commits or rolls back on its own. Then the outer one continues. If the outer part fails later, the inner part's work is already committed and *stays*.
- **NESTED**: the inner method runs *inside* the outer transaction, starting from a **savepoint**, a bookmark in the transaction. If the inner part throws an exception that triggers rollback, its work is rolled back to the bookmark; the outer part can catch that exception and carry on. If the outer part rolls back later, the inner part's work is undone too, because it was never separate. NESTED needs a database and transaction manager that support savepoints; the JDBC setup in `tesla` does, but not every setup does.

**A concrete NESTED example (Q18).** An order and its inventory update usually *must* succeed together (no stock, no order), so REQUIRED fits. NESTED fits an *optional* step: placing an order also gives the customer loyalty points. If the points step fails, roll back just the points and still take the order. If the order itself fails, the points must go too.

This example illustrates the service methods; it is not a complete project to paste into `tesla`. The two public classes belong in separate files and assume matching tables and the usual Spring imports.

```java
@Service
public class OrderService {
    private final JdbcTemplate jdbc;
    private final LoyaltyService loyalty;     // a different bean, so the call goes through its proxy

    public OrderService(JdbcTemplate jdbc, LoyaltyService loyalty) {
        this.jdbc = jdbc;
        this.loyalty = loyalty;
    }

    @Transactional
    public void placeOrder(long customerId, double total) {
        jdbc.update("INSERT INTO orders (customer_id, total) VALUES (?, ?)", customerId, total);
        try {
            loyalty.addPoints(customerId, 10);        // NESTED: a savepoint is set first
        } catch (RuntimeException e) {
            // Only the points step was rolled back (to the savepoint). The order is still here.
            System.out.println("No points this time: " + e.getMessage());
        }
    }
}

@Service
public class LoyaltyService {
    private final JdbcTemplate jdbc;

    public LoyaltyService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Transactional(propagation = Propagation.NESTED)
    public void addPoints(long customerId, int points) {
        jdbc.update("UPDATE customers SET points = points + ? WHERE id = ?", points, customerId);
        // ...if this step fails, only this method's work goes back to the savepoint
    }
}
```

Isn't that `catch` the "catch trap" from Friday? No. The catch trap is when half of a unit that must be *whole* gets committed. Here the points are optional on purpose, and NESTED already undid the points step before the `catch` runs.

- **Q30 and Challenge 1's audit log:** which of the three settings keeps the audit row even when the main transaction rolls back? Compare your Q16 and Q17 answers with the "outer part fails later" sentence of each setting above. Then reread section 1, consequence B.
- **If the audit itself fails (Q30):** an independent transaction does not swallow exceptions. If its exception escapes into the main method, the main method's rollback rules still apply. Handle an audit failure at the call site if it must not abort the main work.
- **Q43 and Q45:** with the three descriptions above, check each blank against its label.
- **R2 (propagation half):** a report is called while a bigger write transaction is already running. Decide whether the report should be part of that transaction or independent of it. Two questions help: should the report see the write's own changes that aren't committed yet? And what should happen to the report if the write fails later? Remember NESTED is not its own transaction: it is a bookmark inside the same one.

## 4. Isolation: what one transaction sees of another

**Q19 to Q21, Q34 to Q36, C2, R2**

Isolation is about two transactions running *at the same time* on the same data. The worksheet focuses on three possible anomalies. Here they are on a timeline, with a shop's `items` table (item 7 has 10 in stock) and two transactions, A and B:

**Dirty read:** seeing a change that isn't committed yet, and might never be.

```text
time  A (stock report)                          B (a sale)
1                                               UPDATE items SET stock = 9 WHERE id = 7
2     SELECT stock ... WHERE id = 7  -> 9 ?!    (not committed yet)
3                                               ROLLBACK  (the sale failed)
      A reported 9, but the stock was 10 all along.
```

**Non-repeatable read:** reading the *same row* twice in one transaction and getting two different values, because someone committed a change in between.

```text
time  A                                         B
1     SELECT stock ... WHERE id = 7  -> 10
2                                               UPDATE items SET stock = 9 WHERE id = 7
3                                               COMMIT
4     SELECT stock ... WHERE id = 7  -> 9       same row, same transaction, new value
```

**Phantom read:** running the *same query* twice and getting a different set of matching rows because another transaction committed a change, such as an INSERT or DELETE, in between.

```text
time  A                                              B
1     SELECT COUNT(*) FROM items WHERE stock = 0 -> 2
2                                                    INSERT a new item with stock 0
3                                                    COMMIT
4     SELECT COUNT(*) FROM items WHERE stock = 0 -> 3   a "phantom" row appeared
```

As a basic model, the worksheet's levels are a ladder: READ_COMMITTED prevents dirty reads; REPEATABLE_READ also prevents non-repeatable reads; SERIALIZABLE also prevents phantom reads. Stronger isolation can cost more work through locking, waiting, or retried transactions. Real databases implement the levels in different ways, so treat this as the basic model, not the exact mechanics. "Highest" (Q20) means the strongest level in the list.

- **Q21:** one nuance. The strongest level makes transactions *behave as if* they ran one at a time. The database doesn't literally line every transaction up in a queue, but it does have to lock, wait, or reject and retry more often.

- **Q35:** use the timelines to identify the anomaly that REPEATABLE_READ prevents but READ_COMMITTED allows.
- **C2:** for this class, a 3 to 5 line written answer is enough; creating threads and running concurrent code are optional. This simplifies the original worksheet's lab requirement. Use the timelines above to compare what each of the two levels allows when another transaction commits between two reads.
- **R2 (isolation half):** one fact you need: an isolation setting only takes effect when the method *starts a new* transaction. A method that joins an existing transaction uses that transaction's isolation. Does that change which isolation your answer can actually get, given your propagation choice?

## 5. TransactionTemplate: a transaction you write yourself

**Q22, Q23, Q24, C3**

`TransactionTemplate` lets you put a block of work under transaction management in your code instead of using an annotation. In our Spring Boot JDBC setup, Boot creates one for you, like `JdbcTemplate`, so you ask for it in your constructor.

`execute(...)` takes a lambda, the same idea as the functional interfaces and lambdas from Week 6 (Abstract Classes and Interfaces, Wednesday 10/21). The lambda's body runs within a transaction. The example below assumes **no transaction is already running**:

- Spring begins the transaction before your lambda runs.
- If your lambda returns normally, Spring commits, unless the transaction was marked rollback-only.
- If an unchecked exception leaves the lambda, Spring rolls back and passes the exception to the caller.
- `status` is the lambda's parameter: a handle to the transaction that is running right now. `status.setRollbackOnly()` puts a note on it: "when this body ends, roll back instead of commit." No exception needed; your method can return normally.
- Whatever the lambda returns, `execute` returns. When you don't need a value, the lambda returns `null`, as in the worksheet's Q22 code.

With default REQUIRED propagation, `TransactionTemplate` can instead join an existing transaction. In that case, leaving the lambda does not commit it independently; the outer transaction controls the final outcome, and a rollback-only mark prevents that shared transaction from committing.

An example from another domain: enrolling a student in a class with 20 seats, where the rule is checked after the INSERT. This is a service-class example that assumes matching tables and the usual Spring imports, not a complete project. It demonstrates conditional rollback for one enrollment attempt; simultaneous enrollment requests need additional concurrency protection.

```java
@Service
public class EnrollmentService {
    private final JdbcTemplate jdbc;
    private final TransactionTemplate txTemplate;    // Spring Boot made this bean

    public EnrollmentService(JdbcTemplate jdbc, TransactionTemplate txTemplate) {
        this.jdbc = jdbc;
        this.txTemplate = txTemplate;
    }

    public boolean enroll(long studentId, long classId) {
        Boolean enrolled = txTemplate.execute(status -> {          // BEGIN
            jdbc.update("INSERT INTO enrollments (student_id, class_id) VALUES (?, ?)", studentId, classId);
            Integer taken = jdbc.queryForObject(
                    "SELECT COUNT(*) FROM enrollments WHERE class_id = ?", Integer.class, classId);
            if (taken == null || taken > 20) {
                status.setRollbackOnly();      // the class is over capacity: undo the INSERT at the end
                return false;                  // no exception: the caller just gets false
            }
            return true;
        });                                                         // COMMIT, or ROLLBACK if marked
        return Boolean.TRUE.equals(enrolled);
    }
}
```

- **Q22:** complete the worksheet's original `pay` skeleton so it compiles. Keep it small; the conditional rollback task comes in Challenge 3. Check variable names, braces, and the lambda's return statement.
- **Q23:** the question compares `TransactionTemplate` with raw JDBC's `setAutoCommit(false)`. Look at Q3 and Q4: which of those raw JDBC steps does `execute(...)` do for you?
- **Q24:** use the bullets above to explain how the status object can request rollback without throwing an exception.
- **C3:** see section 7.

## 6. Where @Transactional goes, readOnly, and tests

**Q8, Q37, Q40, Q41**

- **Where it goes (Q8, Q40 a and b).** A transaction should wrap one **unit of work**: one business action that must happen completely or not at all, like a transfer. A controller method handles HTTP. Repository methods *can* be transactional (Monday's Spring Data repositories already are, for their inherited CRUD methods), but a transaction around one repository call does not automatically group separate repository calls made by its caller. That's why the service method is usually the better boundary: it can group all the database steps in one business action, like Friday's `BankService.transfer`. For Q40, explain the service-layer preference without claiming that transactional repositories are invalid.
- **readOnly (Q40 d).** `readOnly = true` is a *hint*: "this method won't write." Spring and the database *may* use it to optimize. It is not a guarantee that writes are blocked; some databases ignore the hint. Explain the benefit without treating it as data protection.
- **Tests (Q37).** With Spring's test support, `@Transactional` on a *test method* or test class rolls back the test transaction by default when the test ends. This undoes changes participating in that transaction. It does not undo independently committed `REQUIRES_NEW` work or work done by a separate HTTP request on a server thread. The annotation belongs on the test, not just the method being tested. (Testing in depth is Week 9.)
- **Interfaces vs classes (Q41).** Section 1, "Two kinds of proxy."

## 7. The Challenges: a roadmap

**C1: TransferController, BankService, AuditService.** Start from Friday's `tesla`: you already have a controller with a `/transfer` endpoint and a transaction-protected transfer. Work through these questions before you write code:

1. Which class should do each job: receive the HTTP request, validate and move the money, record the audit rows? The challenge's three bullets say a lot about this.
2. Where will the audit rows live, and which file creates that table at startup?
3. Section 1, consequence B: why would calling an audit method directly inside the same `BankService` skip its transactional settings? How does one bean get another bean (think about how `BankService` gets its `JdbcTemplate`)?
4. Section 3: which propagation lets an audit row survive a failed transfer?
5. To record a *failure*, you have to catch the exception. Section 1, consequence A: what must your `catch` do after logging, so the transfer still rolls back?
6. Test a successful transfer and at least two failed ones (too large, and negative). Each time, check `/accounts/total` and the audit rows.

**C2: concurrent anomaly lab.** For this class, a 3 to 5 line written answer is enough; running concurrent code is optional (section 4).

**C3: programmatic rollback.** The pieces, all in section 5 or Friday's code: where a `TransactionTemplate` comes from; what goes inside the lambda; how to read one number from the database (`BankService.getTotal()` uses `queryForObject` with `Double.class`); and where `status.setRollbackOnly()` goes when the business rule fails after the first UPDATE.

## Class materials these notes point to

- Fri 10/30 class recording and Friday's files in `tesla` (`BankService.java`, `TransferController.java`, `Account.java`; `Week7_Fri_Starter.zip` in LMS > Files). The worksheet overview near the end of the class, after the break, lists every worksheet section.
- Introduction to Spring Boot: the Big Picture map (steps 2 and 3).
- Spring JDBC lesson, Part 6 (Error Handling: `DataAccessException` is unchecked) and Part 8 (Forgetting transactions).
- Week 6, Abstract Classes and Interfaces (Wed 10/21): functional interfaces and lambdas.

## Reflection prompts

- **R1:** a "foot-gun" is an easy mistake that can silently produce the wrong result. Choose a transaction mistake from the class experiments and explain what you would do to avoid it.
- **R2:** use the last bullets of sections 3 and 4. State whether the report should share the write transaction or run independently, what data it should see, and whether your isolation choice can actually take effect.
