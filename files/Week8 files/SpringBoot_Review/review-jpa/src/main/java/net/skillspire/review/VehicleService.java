package net.skillspire.review;

// POINT: CHANGED from review-jdbc: the same five methods with the same names, so the controller
//        didn't change. Only their insides changed: inherited repository methods instead of our SQL.
// ASK:   "update() loads the vehicle first. Why not just save the one we were given?"

// LMS Spring Data JPA P5. Monday's fleet VehicleService, with review-jdbc's method names.

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository repo;   // HAS A repository: now one Spring Data wrote

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
        System.out.println(">> VehicleService created by Spring, got a VehicleRepository");
    }

    public List<Vehicle> getAll() {
        return repo.findAll();                          // was: SELECT * FROM vehicles
    }

    public Vehicle getById(Long id) {
        return repo.findById(id).orElse(null);          // Optional: a box that is empty or holds one Vehicle
    }                                                   // no exception for a missing id, so no try/catch

    public void add(Vehicle v) {
        repo.save(v);                                   // id is null, so save() INSERTs
    }

    public boolean update(Long id, Vehicle changes) {
        Vehicle existing = repo.findById(id).orElse(null);
        if (existing == null) {
            return false;                               // no such vehicle
        }
        existing.setModel(changes.getModel());
        existing.setYear(changes.getYear());
        repo.save(existing);                            // id is set, so save() UPDATEs
        return true;
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
