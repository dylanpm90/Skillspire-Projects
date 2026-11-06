package net.skillspire.review.plainjava;

// POINT: the same three layers in plain Java, wired by hand. No Spring anywhere in this file.
//        Every "new" is ours, in main. In the Spring Boot app, Spring does these three news at startup.
// ASK:   "Which object has to be created first, and why?"

// Run it by itself: the green arrow next to main. It doesn't start Spring or Tomcat.
// Week 6 ideas only: "has a" (composition), a part handed in through the constructor, delegation.

import java.util.ArrayList;
import java.util.List;

import net.skillspire.review.Vehicle;

public class PlainJavaWiring {

    // Layer 3: the data. An ArrayList stands in for the database table.
    static class VehicleRepository {
        private final List<Vehicle> table = new ArrayList<>();
        private long nextId = 1;

        Vehicle save(Vehicle v) {
            v.setId(nextId);     // the "database" picks the id
            nextId++;
            table.add(v);
            return v;
        }

        List<Vehicle> findAll() {
            return table;
        }

        Vehicle findById(Long id) {
            for (Vehicle v : table) {
                if (v.getId().equals(id)) {
                    return v;
                }
            }
            return null;
        }
    }

    // Layer 2: the middle. HAS A repository, handed in through the constructor.
    static class VehicleService {
        private final VehicleRepository repo;

        VehicleService(VehicleRepository repo) {
            this.repo = repo;
        }

        List<Vehicle> getAll() {
            return repo.findAll();
        }

        Vehicle getById(Long id) {
            return repo.findById(id);
        }
    }

    // Layer 1: the front door. HAS A service.
    static class VehicleController {
        private final VehicleService service;

        VehicleController(VehicleService service) {
            this.service = service;
        }

        List<Vehicle> getAll() {
            return service.getAll();
        }

        Vehicle getById(Long id) {
            return service.getById(id);
        }
    }

    public static void main(String[] args) {
        // 1. Wiring: build the parts bottom-up. Each needs the one below it.
        //    Spring Boot: @Repository, @Service, @RestController, and Spring does these three lines.
        VehicleRepository repo = new VehicleRepository();
        VehicleService service = new VehicleService(repo);
        VehicleController controller = new VehicleController(service);

        // 2. Some data. Spring Boot app: data.sql (JDBC) or a CommandLineRunner (JPA).
        repo.save(new Vehicle("Model S", 2019));
        repo.save(new Vehicle("Model S", 2023));
        repo.save(new Vehicle("Model 3", 2021));
        repo.save(new Vehicle("Model Y", 2024));

        // 3. "Requests". Spring Boot app: the browser opens a URL, and Spring calls the controller method.
        System.out.println("getAll()     -> " + controller.getAll());        // GET /vehicles
        System.out.println("getById(2L)  -> " + controller.getById(2L));     // GET /vehicles/2
        // * PREDICT before running: what prints for 99?
        System.out.println("getById(99L) -> " + controller.getById(99L));    // GET /vehicles/99
    }
}
