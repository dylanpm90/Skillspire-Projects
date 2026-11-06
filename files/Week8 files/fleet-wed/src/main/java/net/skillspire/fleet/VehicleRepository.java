package net.skillspire.fleet;

// Monday's repository, unchanged except comments. Tonight's runner only calls count().

// LMS Spring Data JPA P4 (repositories), P6 (method names), P7 (JPQL), P8 (native SQL)

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// <Vehicle, Long>: the entity it stores, and the type of its @Id.
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // Method-name queries (LMS P6): findBy + a FIELD name.
    List<Vehicle> findByModel(String model);
    List<Vehicle> findByYearGreaterThan(int year);              // Monday's TODO 1

    // EXTRA WRITE ONE LINE: findByDriverName(String name): a method name can follow a relationship
    //       (driver, then its name field). Call it in FleetRunner and read the join in the console.

    // JPQL (LMS P7): entity and field names, not table and column names.
    @Query("SELECT v FROM Vehicle v WHERE v.model = ?1")
    List<Vehicle> findVehiclesByModel(String model);

    @Query("SELECT v.model, COUNT(v) FROM Vehicle v GROUP BY v.model")     // Monday's TODO 2
    List<Object[]> countVehiclesPerModel();

    // Native SQL (LMS P8): table and column names.
    @Query(value = "SELECT * FROM vehicles WHERE year > ?1", nativeQuery = true)
    List<Vehicle> findVehiclesAfterYear(int year);
}
