# JCC Week 11 Wednesday student starter

Builds on Monday's completed project. All earlier production code, resources and tests
are retained; CalculatorServiceTest only gains an independent multiply exercise.
Java 17, Maven, Spring Boot 3.5.7 and H2 are unchanged.

Open pom.xml with JDK 17 in IntelliJ and run Maven > Lifecycle > test, or use:

```sh
mvn test
mvn -Dtest=TeslaServiceTest,ChargingCostTest test
mvn -Dtest=CalculatorServiceTest,UserServiceTest test
```

Teaching uses plain unit tests. TeslaService reuses VehicleService's ID validation and
lookup contract. Unlocking returns a classroom string, not a hardware operation.
Charging uses whole kWh times whole cents/kWh, returning integer cents. Zero energy is
valid; negative energy and a zero/negative rate are rejected in the finished behavior.
Use only the small exercise inputs; tariffs, fractional units, tax and overflow handling
are outside this exercise. UserService is an in-memory fixture for exercise 4, with a
supplied UserNotFoundException pattern to recreate when practicing exception construction.
No database table or authentication feature is added.

## Validation

Java and Maven are absent in this automated environment. Counts below are expectations
from static source inspection, not passing test results. Run the commands before class.

## Starting point

Expected as given: 26 test methods, 40 invocations. The Tesla/charging command runs
2 invocations; the calculator/user command runs 8. UserServiceTest is a compiling TODO
skeleton with no tests yet. All 38 Monday invocations remain supplied.
The charging method intentionally returns 0. The supplied zero-energy test passes,
but the behavior is incomplete; write each new test before its production change.

## Work in lesson order

1. Part 7: complete the four TeslaServiceTest TODOs. Add the named imports first.
   Check model/year rows, invalid IDs, null and missing 999L with exact messages and
   repository interactions. The existing successful unlock test is supplied as a model.
2. Parts 8 and 9: identify an edge case and explain the invalid-versus-missing distinction.
3. Part 10, exercise 7: complete one red, green, refactor cycle below.
4. Independent exercises 1, 3 and 4: multiply TODO; rerun Monday's division-by-zero test;
   write both UserServiceTest TODOs. Recreate the supplied custom exception if useful.
   Exercises 5 and 6 remain lesson choices if ahead; no solution files are supplied here.

## Test-first cycle, exercise 7

Run the focused command after each step:

```sh
mvn -Dtest=ChargingCostTest test
```

1. Baseline: the supplied zero-energy test passes (1 invocation expected).
2. Red: write calculatesChargingCost with its four CSV rows and imports. Run before
   changing TeslaService: 5 invocations, 3 assertion failures (250, 500, 210 expected;
   actual 0). A compile error or missing import is not the intended red result.
3. Green: replace return 0 with the deliberately explicit form below. Rerun the same
   unchanged tests: 5 passing invocations expected.

```java
if (kwh == 0) {
    return 0;
}
return kwh * centsPerKwh;
```

4. Refactor: remove the redundant zero branch, leaving just the product. Rerun the same
   5 invocations. Behavior must stay the same for all four rows.
5. Next small cycle: write both failure-test TODOs first, then run: 9 invocations,
   4 expected failures because no exception is thrown. Add the two validation guards
   and messages in TeslaService, rerun: 9 passing invocations expected.

After all TODOs: 36 methods, 60 invocations expected; focused Tesla/charging command 17;
calculator/user command 13. Extra practice can be shortened; protect one complete cycle.
