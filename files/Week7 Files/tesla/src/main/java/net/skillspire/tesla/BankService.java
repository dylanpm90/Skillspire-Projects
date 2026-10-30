package net.skillspire.tesla;

// POINT: A transfer is two UPDATEs. @Transactional makes them one unit of work:
//        both happen (commit) or neither does (rollback).
// ASK:   "The app crashes between the two UPDATEs. Where did the money go?"

// Week 7 Worksheet Q9 and Q31: this is the worksheet's own BankService.
// The SQL sits in the service, as in the worksheet, to keep the example short.

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;   // for TODO 2 (Spring's, not jakarta's)

@Service
public class BankService {
    private final JdbcTemplate jdbc;
    private final AuditService audit;
    // Same constructor injection as VehicleRepository (map step 3)
    public BankService(JdbcTemplate jdbc, AuditService audit) {
        this.jdbc = jdbc;
        this.audit = audit;
    }

    // query(): many rows, one Account per row (Wednesday)
    public List<Account> getAccounts() {
        return jdbc.query("SELECT * FROM accounts", new BeanPropertyRowMapper<>(Account.class));
    }

    // The bank's total. A correct transfer never changes it (the C in ACID: our code's job,
    // not the transaction's; a wrong UPDATE commits just fine).
    public Double getTotal() {
        return jdbc.queryForObject("SELECT SUM(balance) FROM accounts", Double.class);   // one row, one value
    }

    // TODO 2: put @Transactional on the line above this method. Then restart.
    @Transactional
    public void transfer(long from, long to, double amount) {
        String what = amount + " from " + from + " to " + to;
        try {
        // UPDATE 1: take the money out of the first account
            jdbc.update("UPDATE accounts SET balance = balance - ? WHERE id = ?", amount, from);

        // A simulated failure between the two UPDATEs (the worksheet's; it stands in for a crash)
            if (amount > 1000) {
                throw new RuntimeException("Amount too large!");
            }
        // * PREDICT (before TODO 2): send amount=1500. What do /accounts and /accounts/total show?

        // TODO 1: UPDATE 2, put the money into the second account (copy UPDATE 1's pattern)
            jdbc.update("UPDATE accounts SET balance = balance + ? WHERE id = ?", amount, to);
            audit.log("OK " + what);
        System.out.println("  transfer finished: " + amount + " from " + from + " to " + to);
        } catch (RuntimeException e) {
            audit.log("FAILED " + what + ": " + e.getMessage());
            throw e;   // rethrow, or the transfer commits half-done
        }
    }
    // EXPLAIN WHAT CHANGED (Sean, after TODO 2; Worksheet Q14, Q38): put  try {  before UPDATE 1, and
    //   } catch (RuntimeException e) { System.out.println("  caught: " + e.getMessage()); }
    //   after UPDATE 2. Restart, send 1500. Read the reply, /accounts, and the log. Then undo (Ctrl+Z).

    // EXPLAIN WHAT CHANGED (Sean; Worksheet Q10, Q11, Q29): change  new RuntimeException(  to  new Exception(
    //   Read the compiler error. Alt+Enter on it > "Add exception to method signature"; then the same on
    //   each caller that turns red (transferFromInside, TransferController.transfer). Restart, send 1500: rolled back?
    //   Then change  @Transactional  to  @Transactional(rollbackFor = Exception.class)  and try again. Undo all.

    // EXTRA (self-invocation; Worksheet Q25-Q27). No @Transactional here, and it calls transfer() on itself.
    // Used only by the EXTRA in TransferController.
    public void transferFromInside(long from, long to, double amount) {
        transfer(from, to, amount);   // this.transfer(...): the real object, not the proxy
    }
}
