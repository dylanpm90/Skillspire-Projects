package net.skillspire.review;

// POINT: CHANGED from review-jdbc: the whole SQL class became an interface with no method bodies.
//        Spring Data JPA writes the class for us at startup and makes it a bean.
// ASK:   "We never wrote save() or findAll(). Where do they come from?"

// LMS Spring Data JPA P4 (repositories), P6 (method names), P7 (JPQL), P8 (native SQL). Monday's fleet file.

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// <Vehicle, Long>: the entity it stores, and the type of its @Id.
// Inherited for free: save, findAll, findById, existsById, deleteById, count.
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // Method-name queries: findBy + a FIELD name (+ a keyword). Spring reads the name and writes the SQL.
    List<Vehicle> findByModel(String model);              // ... where model = ?
    List<Vehicle> findByYearGreaterThan(int year);        // ... where year > ?

    // JPQL: class and field names (Vehicle, v.model), not table and column names.
    // GROUP BY: one row per model. Each row comes back as an Object[]: {model, count}.
    @Query("SELECT v.model, COUNT(v) FROM Vehicle v GROUP BY v.model")
    List<Object[]> countVehiclesPerModel();

    // Native SQL: table and column names, this database's own SQL.
    @Query(value = "SELECT * FROM vehicles WHERE year > ?1", nativeQuery = true)
    List<Vehicle> findVehiclesAfterYear(int year);
}
