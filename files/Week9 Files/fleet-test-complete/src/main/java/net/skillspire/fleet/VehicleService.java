package net.skillspire.fleet;

// POINT: the service does the work and returns data; null or false means "not found".
//        The controller only turns that into HTTP: 200, 201, 204, 404, 400.
// ASK:   "updateVehicle and patchVehicle get the same body. Why do they give different results?"

// LMS Spring Data JPA P5 (Monday). REST Controllers P3, P6. Params and Path Variables P3-P6.

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    // ===== Monday's CRUD: REST Controllers P3-P4 call these =====
    public Vehicle addVehicle(Vehicle v) {
        return repo.save(v);                       // id is null, so save() INSERTs
    }

    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }

    public Vehicle getVehicle(Long id) {
        return repo.findById(id).orElse(null);     // null: the controller sends 404
    }

    public Vehicle updateVehicle(Long id, Vehicle changes) {     // PUT
        Vehicle existing = repo.findById(id).orElse(null);
        if (existing == null) {
            return null;                           // the controller sends 404
        }
        existing.setModel(changes.getModel());     // copies BOTH fields, sent or not
        existing.setYear(changes.getYear());
        // * PREDICT: PATCH /api/vehicles/3 with {"year": 2025} keeps "Model Y". The same body with PUT?
        return repo.save(existing);
    }

    public boolean deleteVehicle(Long id) {
        if (!repo.existsById(id)) {
            return false;                          // the controller sends 404
        }
        repo.deleteById(id);
        return true;
    }

    // REST Controllers P6. Unused once TODO 2 switches the search to search() below.
    public List<Vehicle> findByModel(String model) {
        return repo.findByModel(model);
    }

    // ===== Today: search with an optional model and a default minYear (Params and Path Variables P3) =====
    public List<Vehicle> search(String model, int minYear) {
        checkMinYear(minYear);                                   // P4
        if (model == null) {
            return repo.findByYearGreaterThanEqual(minYear);     // no model sent: every model
        }
        return repo.findByModelAndYearGreaterThanEqual(model, minYear);
    }

    // P4: -5 is a valid int, so Spring accepts it. The rule is ours: GlobalExceptionHandler turns this into 400.
    private void checkMinYear(int minYear) {
        if (minYear < 0) {
            throw new IllegalArgumentException("minYear can't be negative: " + minYear);
        }
    }

    // ===== Today: one driver's vehicles (P5) =====
    public List<Vehicle> getDriversVehicles(Long driverId, int minYear) {
        checkMinYear(minYear);                                   // the same rule, so the same 400
        return repo.findByDriverIdAndYearGreaterThanEqual(driverId, minYear);
    }

    public Vehicle getDriversVehicle(Long driverId, Long vehicleId) {
        // null if there's no such vehicle, or if it isn't this driver's
        return repo.findByIdAndDriverId(vehicleId, driverId).orElse(null);
    }

    // ===== Today: PATCH changes only what was sent (P6) =====
    public Vehicle patchVehicle(Long id, Vehicle changes) {
        Vehicle existing = repo.findById(id).orElse(null);
        if (existing == null) {
            return null;                                // becomes 404
        }
        if (changes.getModel() != null) {               // model not in the JSON: keep the old one
            existing.setModel(changes.getModel());
        }
        if (changes.getYear() != 0) {                   // year not in the JSON: it's 0, keep the old one
            existing.setYear(changes.getYear());        // (fine for a year; for a price use Double and != null)
        }
        return repo.save(existing);
    }
}
