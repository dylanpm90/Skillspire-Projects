# JCC Week 10 Friday starter

This project builds on Wednesday's completed Customer, Profile, Order, Student
and Course project. Friday teaches the AOP material carried over from class.
`OrderService` previews orders; it does not save them. JPA examples run separately.

Open the folder containing `pom.xml` with JDK 17. In IntelliJ, select that JDK
as the Project SDK, then run **Maven > Lifecycle > test**. With Maven installed,
run these commands from this folder:

```sh
mvn test
mvn spring-boot:run -Dspring-boot.run.profiles=demo
```

Alternatively, run `RelationshipsApplication` with
`--spring.profiles.active=demo` as a program argument. H2 data is disposable;
the application runs the demonstrations without starting a web server, then exits.
The mapping runner's output may appear before or after the AOP runner's output.

## Starting behavior and proxy predictions

`LoggingAspect` replaces Wednesday's `OrderProbeAspect` and keeps its named,
narrow pointcut. `@Before` now prints `Before: placeOrder`. No second probe
aspect is registered. The service rejects null or blank product names with
`IllegalArgumentException("Product is required")`.

| Call in `OrderProxyDemo` | Entry advice? | Reason |
|---|---|---|
| `orders.placeOrder("Keyboard")` | Yes | Direct call through the Spring bean; pointcut matches. |
| `orders.status()` | No | Method does not match. |
| `orders.placeFromInside("Mouse")` | No | The outer method does not match; its internal call bypasses the proxy. |
| `orders.placeOrder(" ")` | Yes | Advice runs before validation; the caller catches the exception. |

The unchanged mapping tests verify persistence after flush, clear and reload,
including cascading deletes and preserving shared courses. They are regression
checks, not new Friday material.

## In-class work

The project runs as given, with eight tests: four in `CustomerProfileTest`, two
in `StudentCourseTest`, and two in `OrderServiceAopTest`. The AOP tests check the
matching proxy boundary and propagation of validation failure. They should
still pass when the TODOs are finished.

1. Trace the three original proxy calls before adding advice.
2. Fill the two TODOs in `LoggingAspect.java`. Bind `result` with
   `@AfterReturning` and `ex` with `@AfterThrowing`. Keep `placeOrderCall()` narrow.
3. Rerun the tests and demo. Confirm one `Returned:` line for Keyboard and one
   `Threw: Product is required` line for the blank product. There should be no
   advice output for `status()` or `placeFromInside("Mouse")`.
4. Add tests for result logging, exception logging with propagation, and absent
   logs for nonmatching and internal calls. The existing output-capture test
   provides the pattern. Do not catch an exception inside the advice.

Before the TODOs, the AOP runner's exact output is:

```text
Before: placeOrder
Direct call: Order preview for Keyboard
Nonmatching call: Order service ready
Self-invocation: Order preview for Mouse
Before: placeOrder
Caller caught: Product is required
```

Timing remains an optional lesson walkthrough. Custom authorization and a
separate exception aspect are outside today's lab.

## Validation for this prep run

Static checks only: this environment has no Java or Maven executable. The test
counts and output above describe the expected behavior; runtime verification
with the commands above remains open. Spring Boot 3.5.7 and Java 17 are retained
from Wednesday.
