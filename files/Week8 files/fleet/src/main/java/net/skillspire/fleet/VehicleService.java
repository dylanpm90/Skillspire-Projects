package net.skillspire.fleet;

// POINT: the service does the work with the repository. Friday's REST controller will call it.
// ASK:   "updateVehicle loads the vehicle first. Why not just save the one we were given?"

// LMS Spring Data JPA P5 (CRUD Operations with Repositories). Not run tonight: Friday's controller uses it.

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    private final VehicleRepository repo;

    // Constructor injection, as in Week 7: Spring hands us the repository bean.
    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    public Vehicle addVehicle(Vehicle v) {
        return repo.save(v);                       // id is null, so save() INSERTs
    }

    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }

    public Vehicle getVehicle(Long id) {
        return repo.findById(id).orElse(null);     // Optional: a box that is empty or holds one Vehicle
    }

    public Vehicle updateVehicle(Long id, Vehicle changes) {
        Vehicle existing = repo.findById(id).orElse(null);
        if (existing == null) {
            return null;                           // Friday: becomes 404 Not Found
        }
        existing.setModel(changes.getModel());
        existing.setYear(changes.getYear());
        return repo.save(existing);                // id is set, so save() UPDATEs
    }

    public boolean deleteVehicle(Long id) {
        // * PREDICT: what does deleteVehicle(99L) return when there is no vehicle 99?
        if (!repo.existsById(id)) {
            return false;                          // the false tells Friday's controller to send 404
        }
        repo.deleteById(id);
        return true;
    }
}
