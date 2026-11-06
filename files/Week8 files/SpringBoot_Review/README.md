# Spring Boot review: one app, start to finish

Two small Spring Boot projects with the same app: a list of vehicles you can read, add, change and delete over HTTP.

- `review-jdbc`: Week 7 (Spring Boot + JdbcTemplate). We write the SQL.
- `review-jpa`: Week 8 Monday (Spring Data JPA). The same app; only the database layer changed.

## Open and run

1. IntelliJ: File > Open, choose `review-jdbc` (the folder with `pom.xml`). Trust Project. Wait for Maven to finish.
2. Run `ReviewApplication` (green arrow next to `main`). Look for `Tomcat started on port 8080`.
3. Stop it (red square) before running the other project: both use port 8080.
4. `PlainJavaWiring` (in `review-jdbc`, package `plainjava`) is plain Java: run its `main` by itself.

## Try it

Browser (GET only):

- localhost:8080/charging/42 → `Station 42 is online.`
- localhost:8080/vehicles → all four cars as JSON
- localhost:8080/vehicles/2 → one car
- localhost:8080/vehicles/99 → a blank page: no car 99

POST, PUT and DELETE: use the Apidog Fast Request plugin in IntelliJ.

- POST localhost:8080/vehicles, body `{"model": "Cybertruck", "year": 2025}` → `Vehicle added!`
- PUT localhost:8080/vehicles/2, body `{"model": "Model S Plaid", "year": 2025}` → `Vehicle 2 updated!`
- DELETE localhost:8080/vehicles/4 → `Vehicle 4 deleted!`
- DELETE localhost:8080/vehicles/99 → `No vehicle with id 99`

The data resets every time the app restarts (an in-memory database).

## The map

```text
1. THE REQUEST PATH: who talks to whom

browser/Apidog --> VehicleController --> VehicleService --> VehicleRepository --> H2 database
                   front door:           the middle:        database layer:        the vehicles table
                   URL -> method         decides things     SQL (Week 7) or
                   no SQL                (e.g. not found)   JPA (Week 8)


2. WHO CALLS new?  (the "connecting" part)

Plain Java (PlainJavaWiring)                   Spring Boot
you, in main:                                  Spring, at startup. Each object it makes is a BEAN.
  repo = new VehicleRepository()                 @Repository     on VehicleRepository
  service = new VehicleService(repo)             @Service        on VehicleService
  controller = new VehicleController(service)    @RestController on VehicleController
  controller.getAll()                            GET /vehicles -> Spring calls getAll()

Each class asks for its part in its constructor; Spring hands it in (constructor injection).
Same idea as Week 6: a Car HAS AN Engine, handed in through the constructor.


3. YOU WRITE THREE THINGS

pom.xml                  which libraries (starters): Spring Web, JDBC API or Spring Data JPA, H2
application.properties   settings: database URL, port, logging
your classes             with annotations, in net.skillspire.review or a package under it

When you run main, Spring Boot:
  1. reads your libraries and your classes
  2. adds its own beans for those libraries (Tomcat, DataSource, JdbcTemplate): AUTOCONFIGURATION
  3. creates all the beans, yours and its own, and hands each one what it needs
  4. starts Tomcat and waits: each URL runs one of your methods


4. CRUD IN EVERY LAYER

CRUD     HTTP     SQL      JdbcTemplate (review-jdbc)      JpaRepository (review-jpa)
Create   POST     INSERT   update()                        save()       (id is null)
Read     GET      SELECT   query() / queryForObject()      findAll() / findById()
Update   PUT      UPDATE   update()                        save()       (id is set)
Delete   DELETE   DELETE   update()                        deleteById()


5. WEEK 7 -> WEEK 8: only the database layer changes

pom.xml                 JDBC API starter              -->  Spring Data JPA starter
the table               schema.sql: CREATE TABLE      -->  @Entity on Vehicle (Hibernate creates it)
the data                data.sql                      -->  VehicleRunner (a CommandLineRunner)
VehicleRepository       a class full of SQL           -->  an interface: extends JpaRepository<Vehicle, Long>
VehicleService          same 5 methods                -->  same 5 methods, new insides
VehicleController       --- identical: not one character changed ---
```

## Where each class came from in class

- `ChargingController`: Introduction to Spring Boot, P9 (Mon 10/26)
- `VehicleRepository` (JDBC), `schema.sql`, `data.sql`: Spring JDBC, P1–P4 (Wed 10/28)
- `VehicleController`: Spring JDBC, P5 (Wed 10/28), now calling a service
- `Vehicle` (`@Entity`), `VehicleRepository` (JPA), `VehicleService`, the runner: Spring Data JPA, P3–P9 (Mon 11/2, the `fleet` project)
