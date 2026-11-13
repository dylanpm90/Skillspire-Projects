# Friday's tests (Week 9), in teaching order

Run a test class with the green arrow next to its name in IntelliJ, or all of them with the green arrow on the
src/test/java folder (or `mvn test`). No need to start FleetApplication: the tests start what they need.

1. BatteryTest: plain JUnit. 3 tests to start, TODO 1 adds the 4th (isLowBelow20).
2. VehicleServiceTest: Mockito, no Spring. 3 tests to start, TODO 2 adds the 4th (the not-found test).
3. VehiclePageControllerTest: @WebMvcTest + MockMvc + @MockitoBean, for the pages (/vehicles). 3 tests to start, TODO 3 adds the 4th (the 404 page).
4. VehicleRepositoryTest: @DataJpaTest on H2. 2 tests, one per custom query.
5. VehicleControllerTest: @WebMvcTest for the REST controller (/api/vehicles): JSON with jsonPath, a 404 and a JSON POST. 3 tests. Not taught in class: self-study and lab. (In the LMS lesson, VehicleControllerTest is the page test; in fleet, VehicleController is the REST class.)
6. FleetApplicationTests: the start.spring.io test. @SpringBootTest starts the WHOLE app (an integration test).

Starter project: 15 tests, all green. After TODO 1 to 3: 18 tests. Assignment 2 needs at least 10 across the layers.

These are class examples. The Assignment 2 post says which tests count toward your 10.

Monday's browser checks and Friday's API requests are in REQUESTS.md; the app still runs the same way.
