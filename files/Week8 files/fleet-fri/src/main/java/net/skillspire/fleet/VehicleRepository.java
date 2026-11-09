package net.skillspire.fleet;

// POINT: Monday's repository, plus four method-name queries for today's endpoints. Still no method bodies.
// ASK:   "findByIdAndDriverId: Vehicle has no driverId field. What does Spring Data read it as?"

// LMS Spring Data JPA P4, P6, P7, P8 (Monday). Params and Path Variables P3, P5 (today).

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // Monday
    List<Vehicle> findByModel(String model);
    List<Vehicle> findByYearGreaterThan(int year);

    @Query("SELECT v FROM Vehicle v WHERE v.model = ?1")
    List<Vehicle> findVehiclesByModel(String model);

    @Query("SELECT v.model, COUNT(v) FROM Vehicle v GROUP BY v.model")
    List<Object[]> countVehiclesPerModel();

    @Query(value = "SELECT * FROM vehicles WHERE year > ?1", nativeQuery = true)
    List<Vehicle> findVehiclesAfterYear(int year);

    // ===== Today: the search (Params and Path Variables P3) =====
    List<Vehicle> findByYearGreaterThanEqual(int year);
    List<Vehicle> findByModelAndYearGreaterThanEqual(String model, int year);

    // ===== Today: one driver's vehicles (P5). DriverId = driver.id: Vehicle has no driverId field =====
    List<Vehicle> findByDriverIdAndYearGreaterThanEqual(Long driverId, int year);
    Optional<Vehicle> findByIdAndDriverId(Long id, Long driverId);     // empty unless it's that driver's
    // Assignment 4 has the same shape:  Optional<Order> findByIdAndCustomerId(Long id, Long customerId);
}
