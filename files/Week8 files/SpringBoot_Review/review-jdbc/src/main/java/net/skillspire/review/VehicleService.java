package net.skillspire.review;

// POINT: layer 2, the middle. The controller asks it for things; it asks the repository.
//        It decides what "not found" means, so the controller doesn't need to know about SQL errors.
// ASK:   "Who calls this constructor, and where does the VehicleRepository come from?"

// LMS Spring JDBC P6 (handling the missing row yourself). The JPA version of this file has the
// same five methods; only their insides change.

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service      // SPOT THE BUG: comment out this line, restart, and read the box in the log.
public class VehicleService {

    private final VehicleRepository repo;   // HAS A repository

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
        System.out.println(">> VehicleService created by Spring, got a VehicleRepository");
    }

    public List<Vehicle> getAll() {
        return repo.getAllVehicles();
    }

    public Vehicle getById(Long id) {
        try {
            return repo.getVehicleById(id);
        } catch (EmptyResultDataAccessException e) {
            return null;   // no such vehicle. (Friday's lesson turns this into a 404.)
        }
        // EXTRA SPOT THE BUG: replace the whole try/catch with  return repo.getVehicleById(id);
        //   then open /vehicles/99. Read the console, not the browser.
    }

    public void add(Vehicle v) {
        repo.addVehicle(v);
    }

    public boolean update(Long id, Vehicle changes) {
        changes.setId(id);                    // the id comes from the URL, not from the JSON body
        int rows = repo.updateVehicle(changes);
        return rows > 0;                      // 0 rows changed = no such vehicle
    }

    public boolean delete(Long id) {
        int rows = repo.deleteVehicle(id);
        return rows > 0;
    }
}
