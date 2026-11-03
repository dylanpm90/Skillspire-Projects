package net.skillspire.fleet;

// POINT: a CommandLineRunner runs once, right after startup, so we can watch JPA work before any REST.
// ASK:   "Which SQL lines in the console came from which line of this file?"

// LMS Spring Data JPA P9 (Tesla Fleet). Assignment 1 asks for a runner like this one.

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component      // a bean, so Spring creates it and hands it the repository
public class FleetRunner implements CommandLineRunner {
    private final VehicleRepository repo;

    public FleetRunner(VehicleRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        // ----- 1. Built-in methods: we never wrote these (LMS P4, P5) -----
        System.out.println("--- 1. Built-in methods ---");
        repo.save(new Vehicle("Model S", 2019));    // in-memory H2 starts empty every run
        repo.save(new Vehicle("Model S", 2023));
        repo.save(new Vehicle("Model 3", 2021));
        repo.save(new Vehicle("Model Y", 2024));
        System.out.println("All: " + repo.findAll());
        System.out.println("findById(2)  -> " + repo.findById(2L).orElse(null));   // 2L: the id type is Long
        // * PREDICT before running: what prints for vehicle 99?
        System.out.println("findById(99) -> " + repo.findById(99L).orElse(null));
        System.out.println("count() -> " + repo.count());
        // EXTRA SPOT THE BUG: change  findById(2L)  to  findById(2).

        // ----- 2. Method-name queries (LMS P6) -----
        System.out.println("--- 2. Method-name queries ---");
        System.out.println("Model S: " + repo.findByModel("Model S"));
        // TODO 1: uncomment the next line after writing findByYearGreaterThan (select it, Ctrl+/ or Cmd+/).
         System.out.println("After 2020: " + repo.findByYearGreaterThan(2020));

        // ----- 3. JPQL (LMS P7) -----
        System.out.println("--- 3. JPQL ---");
        System.out.println("Model S (JPQL): " + repo.findVehiclesByModel("Model S"));
        // TODO 2: uncomment the loop after writing countVehiclesPerModel.
         for (Object[] row : repo.countVehiclesPerModel()) {
             System.out.println(row[0] + ": " + row[1]);    // row[0] = model, row[1] = count
         }

        // ----- 4. Native SQL (LMS P8) -----
        System.out.println("--- 4. Native SQL ---");
        System.out.println("After 2020 (native): " + repo.findVehiclesAfterYear(2020));
    }
}
