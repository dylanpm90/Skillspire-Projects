package net.skillspire.review;

// POINT: NEW in review-jpa. A CommandLineRunner runs once, right after startup.
//        It replaces data.sql (same four cars), then tries the queries. Assignment 1 asks for one like it.
// ASK:   "Which 'Hibernate:' lines in the console came from which line of this file?"

// LMS Spring Data JPA P9. Monday's FleetRunner, shortened.

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component      // a bean: Spring creates it, hands it the repository, then calls run()
public class VehicleRunner implements CommandLineRunner {

    private final VehicleRepository repo;

    public VehicleRunner(VehicleRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        // The in-memory database starts empty every run: same four cars as review-jdbc's data.sql
        repo.save(new Vehicle("Model S", 2019));
        repo.save(new Vehicle("Model S", 2023));
        repo.save(new Vehicle("Model 3", 2021));
        repo.save(new Vehicle("Model Y", 2024));
        System.out.println("--- VehicleRunner: saved " + repo.count() + " vehicles ---");

        System.out.println("findByModel(\"Model S\")      -> " + repo.findByModel("Model S"));
        // * PREDICT before running: which cars print for GreaterThan(2020)?
        System.out.println("findByYearGreaterThan(2020) -> " + repo.findByYearGreaterThan(2020));

        System.out.println("countVehiclesPerModel():");
        for (Object[] row : repo.countVehiclesPerModel()) {
            System.out.println("  " + row[0] + ": " + row[1]);    // row[0] = model, row[1] = count
        }

        System.out.println("findVehiclesAfterYear(2020) -> " + repo.findVehiclesAfterYear(2020));
        System.out.println("--- Ready: open localhost:8080/vehicles ---");
    }
}
