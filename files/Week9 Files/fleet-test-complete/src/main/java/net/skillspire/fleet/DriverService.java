package net.skillspire.fleet;

// Wednesday's, unchanged. The runner still uses it to print what it saved.
// A LAZY list loads only while the database session is open; @Transactional keeps it open.

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
    @Transactional(readOnly = true)
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
            System.out.println("  " + v + " charges at " + v.getStations());
        }
    }
}
