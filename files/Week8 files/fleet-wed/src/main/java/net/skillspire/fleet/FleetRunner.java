package net.skillspire.fleet;

// POINT: build the objects in Java, link them with the helpers, save the drivers: cascade does the rest.
//        Then read everything back from the database in a new transaction.
// ASK:   "Four save() calls. Which rows does each one write?"

// LMS Entities and Relationships P7 (Tesla: drivers, profiles, vehicles, stations), P8.
// Assignment 2's runner has the same shape: a customer with an address, orders, shared products.
// Monday's runner stays in Monday's fleet project.

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FleetRunner implements CommandLineRunner {
    private final DriverRepository driverRepo;
    private final VehicleRepository vehicleRepo;
    private final ChargingStationRepository stationRepo;
    private final DriverService driverService;

    public FleetRunner(DriverRepository driverRepo, VehicleRepository vehicleRepo,
                       ChargingStationRepository stationRepo, DriverService driverService) {
        this.driverRepo = driverRepo;
        this.vehicleRepo = vehicleRepo;
        this.stationRepo = stationRepo;
        this.driverService = driverService;
    }

    @Override
    public void run(String... args) {
        // ----- 1. Build and save -----
        System.out.println("--- 1. Saving ---");
        // Stations are shared and exist on their own (like Assignment 2's products): save them first.
        ChargingStation seattle = stationRepo.save(new ChargingStation("Seattle"));
        ChargingStation tacoma = stationRepo.save(new ChargingStation("Tacoma"));

        Driver alice = new Driver("Alice", new Profile("206-555-0101", "Seattle"));   // one-to-one
        Vehicle modelS = new Vehicle("Model S", 2019);
        Vehicle model3 = new Vehicle("Model 3", 2021);
        alice.addVehicle(modelS);                        // one-to-many
        alice.addVehicle(model3);
        modelS.addStation(seattle);                      // many-to-many
        modelS.addStation(tacoma);
        model3.addStation(seattle);

        Driver bob = new Driver("Bob", new Profile("253-555-0102", "Tacoma"));
        Vehicle modelY = new Vehicle("Model Y", 2024);
        bob.addVehicle(modelY);
        modelY.addStation(tacoma);                       // Tacoma now serves two vehicles

        driverRepo.save(alice);       // cascade: this one save also writes Alice's profile and both vehicles
        driverRepo.save(bob);
        System.out.println("Saved " + driverRepo.count() + " drivers, " + vehicleRepo.count()
                + " vehicles, " + stationRepo.count() + " stations");

        // ----- 2. Read back from the database: a new transaction, so nothing comes from Java memory -----
        System.out.println("--- 2. Reading ---");
        driverService.printDriver(alice.getId());
        driverService.printDriver(bob.getId());
    }
}
