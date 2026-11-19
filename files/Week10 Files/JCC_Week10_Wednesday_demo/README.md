# JCC Week 10 Wednesday starter

Use this project for **Mapping Relationships Using JPA Annotations** and
**Principles and Concepts**. It starts with the Customer, Profile and Order
mappings from Monday's working project.

Open the folder containing `pom.xml` using JDK 17. In IntelliJ, select the
JDK as the Project SDK, then use **Maven > Lifecycle > test**. With Maven
installed, use these commands from that folder in Windows Git Bash or on Mac.

```sh
mvn test
mvn spring-boot:run -Dspring-boot.run.profiles=demo
```

For an IntelliJ run configuration, launch `RelationshipsApplication` with
`--spring.profiles.active=demo` as a program argument. The demo uses a
disposable H2 database and exits without starting a web server.

## Mapping practice

1. Find the owning `Order.customer` field and inverse `Customer.orders` field.
   Run `customerWithTwoOrdersReloadsBoth` and locate `customer_id` in the SQL.
2. Follow the TODOs in `Student.java` and `Course.java`. Put the join table on
   `Student.courses`, point `Course.students` back to it, and update both
   collections when adding a course.
3. Use `CustomerProfileTest` as a pattern for your own `StudentCourseTest`. The
   four supplied tests cover Customer, Profile and Order. In your test, save new
   courses before linking them to a student. Flush, clear the persistence context,
   then verify both sides. Try two students who share the same course.

## Proxy practice

Read the three calls in `OrderProxyDemo`. Assume a proxy with advice for
`OrderService.placeOrder(..)` only. For each call, identify which method enters
the proxy and predict whether the advice runs. The starter prints only the
service results. The instructor will run the advice check after you make your
predictions.
