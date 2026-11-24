# JCC Week 11 Monday student starting project

Builds on `JCC_Week10_Friday_demo_complete`, retaining its Customer/Profile/Order,
Student/Course and AOP code and all eleven regression tests unchanged.
Java 17, Maven and Spring Boot 3.5.7 are retained. H2 is in memory.

From this folder, open `pom.xml` in IntelliJ with JDK 17 and use Maven > Lifecycle > test,
or run:

```sh
mvn test
mvn -Dtest=OrderServiceUnitTest,CalculatorServiceTest,VehicleServiceTest test
mvn spring-boot:run -Dspring-boot.run.profiles=demo
```

The last command runs the unchanged Week 10 mapping and proxy demonstrations and exits.
Monday's teaching happens in the test runner. Plain unit tests construct services directly;
they do not test Spring advice or database mappings. Those remain in the inherited tests.
`OrderServiceUnitTest` is the familiar bridge. `CalculatorService` and `VehicleService`
match the LMS examples. `VehicleRepository` is a mockable lookup interface, not a JPA
repository; Vehicle is a plain Java class and adds no database table.

## Monday work

The starter runs as supplied. Production behavior is already present; students write
the tests at the TODO comments in `CalculatorServiceTest` and `VehicleServiceTest`.
Replace the three repeated add tests with CSV rows and add zero/negative cases.
Add the division failure, supported model, invalid-ID, null-ID and missing-ID checks.
If time allows, type the CSV-file test; otherwise trace it from the lesson.
If ahead, do the optional and if-ahead TODOs. Use the lesson for syntax;
the instructor's completed folder is a separate answer and must not be distributed.
Expected before edits: 17 test methods and 17 invocations, including 11 inherited tests.
The focused unit-test command should run 6 tests before edits.

`test-data.csv` belongs in `src/test/resources/`; its header is skipped.
`@ValueSource` cannot supply null, so null has a separate `@Test`.
Negative/zero/null IDs throw `IllegalArgumentException("Invalid vehicle ID")` without
looking up a record. A missing positive ID throws
`VehicleNotFoundException("Vehicle not found")` after lookup.

## Validation

Static review only in this automated environment: Java and Maven executables are absent.
Counts above are expectations from source, not a reported passing run. Run the commands
before class. No dependency upgrade or external service is needed.
