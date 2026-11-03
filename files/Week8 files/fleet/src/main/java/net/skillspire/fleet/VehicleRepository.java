package net.skillspire.fleet;

// POINT: an interface with no method bodies is a working repository. Spring Data writes the class at startup.
// ASK:   "We never wrote save() or findAll(). Where do they come from?"

// LMS Spring Data JPA P4 (repositories), P6 (method names), P7 (JPQL), P8 (native SQL)

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// <Vehicle, Long>: the entity it stores, and the type of its @Id.
// Inherited for free: save, findAll, findById, deleteById, existsById, count (FleetRunner section 1).
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // ===== Section 2: method-name queries (LMS P6) =====
    // findBy + a FIELD name. Spring turns it into: select ... from vehicles where model=?
    List<Vehicle> findByModel(String model);
    // SPOT THE BUG (Sean only): rename  findByModel  to  findByModle  here and in FleetRunner, run.

    // TODO 1: write a method that finds the vehicles newer than a given year.
    //         Field: year. Keyword: GreaterThan. Then uncomment its line in FleetRunner section 2.
    // * PREDICT before running: which vehicles print for "After 2020"?
    List<Vehicle> findByYearGreaterThan(int year);

    // EXTRA WRITE ONE LINE: findByModelAndYear(String model, int year), then call it in FleetRunner.

    // ===== Section 3: JPQL (LMS P7): entity and field names, not table and column names =====
    @Query("SELECT v FROM Vehicle v WHERE v.model = ?1")      // ?1 = the method's first parameter
    List<Vehicle> findVehiclesByModel(String model);           // same result as findByModel, written by hand

    // TODO 2: write countVehiclesPerModel(): one row per model with its count.
    //         The query starts  SELECT v.model, COUNT(v) FROM Vehicle v  and needs one row per model.
    //         Each row comes back as an Object[], so the return type is List<Object[]>.
    //         Then uncomment the loop in FleetRunner section 3.
    @Query("SELECT v.model, COUNT(v) FROM Vehicle v GROUP BY v.model")
    List<Object[]> countVehiclesPerModel();

    // ===== Section 4: native SQL (LMS P8): table and column names, this database's SQL =====
    @Query(value = "SELECT * FROM vehicles WHERE year > ?1", nativeQuery = true)
    List<Vehicle> findVehiclesAfterYear(int year);
    // EXTRA SPOT THE BUG: change  FROM vehicles  to  FROM Vehicle  in the native query, run.
}
