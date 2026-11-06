package net.skillspire.fleet;

// POINT: a LAZY list loads only while the database session is open. @Transactional keeps it open
//        for the whole method: Week 7's annotation, with a second job.
// ASK:   "When does Hibernate run the SELECT for Alice's vehicles?"

// LMS Entities and Relationships P6 (fetch types), P8 (repositories with relationships)

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;   // Spring's, as in Week 7

@Service
public class DriverService {
    private final DriverRepository driverRepo;

    public DriverService(DriverRepository driverRepo) {
        this.driverRepo = driverRepo;
    }

    // A service normally returns data. This one prints, so we can match each line to its SQL.
    @Transactional(readOnly = true)     // * SPOT THE BUG: comment out this line and run.
    public void printDriver(Long id) {
        Driver driver = driverRepo.findById(id).orElse(null);
        if (driver == null) {
            System.out.println("No driver " + id);
            return;
        }
        System.out.println(driver);                     // the profile is EAGER: read together with the driver
        if (driver.getVehicles().isEmpty()) {           // the vehicles are LAZY: their SELECT runs here
            System.out.println("  (no vehicles)");
        }
        for (Vehicle v : driver.getVehicles()) {
            // Each vehicle's stations: one more SELECT per vehicle (the N+1 pattern, Week 10).
            System.out.println("  " + v + " charges at " + v.getStations());
        }
    }
}
