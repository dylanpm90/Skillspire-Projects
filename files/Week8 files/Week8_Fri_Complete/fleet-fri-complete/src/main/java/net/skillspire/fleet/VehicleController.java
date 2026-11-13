package net.skillspire.fleet;

// POINT: the controller handles HTTP only. It reads the path, the query string and the body,
//        calls VehicleService, and picks the status code with ResponseEntity.
// ASK:   "Week 7's GET /vehicles/99 crashed with a 500. What should it answer, and who decides?"

// LMS REST Controllers P3-P5, P8 (sections 1-3). Params and Path Variables P2-P3, P6 (sections 4-5).

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                      // every return value becomes the response body (JSON)
@RequestMapping("/api/vehicles")     // every path in this class starts here
public class VehicleController {
    private final VehicleService service;

    public VehicleController(VehicleService service) {     // constructor injection, as in Week 7
        this.service = service;
    }

    // ===== Section 1: read (REST Controllers P3-P5) =====
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return service.getAllVehicles();                  // a List becomes a JSON array
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") Long id) {
        Vehicle v = service.getVehicle(id);
        if (v == null) {
            return ResponseEntity.notFound().build();     // 404
        }
        return ResponseEntity.ok(v);                      // 200, body: the vehicle as JSON
    }
    // * PREDICT: GET /api/vehicles/99. (Week 7's JdbcTemplate version crashed with a 500.)

    // ===== Section 2: write (REST Controllers P4-P5). Send these with Apidog: a browser only sends GET =====
    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v) {     // JSON body -> a Vehicle
        Vehicle saved = service.addVehicle(v);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);      // 201, with the new id
    }
    // EXTRA SPOT THE BUG: delete  @RequestBody , restart, POST {"model": "Model X", "year": 2025}. What got saved?

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") Long id, @RequestBody Vehicle v) {
        Vehicle updated = service.updateVehicle(id, v);
        if (updated == null) {
            return ResponseEntity.notFound().build();     // 404
        }
        return ResponseEntity.ok(updated);                // 200
    }

    // PREDICT before TODO 1: there's no delete method yet. What does DELETE /api/vehicles/4 answer?
    // TODO 1 (done): DELETE /api/vehicles/{id}: 204 if it was deleted, 404 if there's no such vehicle.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("id") Long id) {
        if (!service.deleteVehicle(id)) {
            return ResponseEntity.notFound().build();     // 404
        }
        return ResponseEntity.noContent().build();        // 204: done, nothing to send back
    }


    /*
    workaround to apidog 204 issue. Returns 200 plus string message
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle200(
            @PathVariable("id") Long id) {

        if (!service.deleteVehicle(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Vehicle " + id + " deleted.");
    }




    // ===== Section 3: an action, not CRUD (REST Controllers P8). Simulated: it changes nothing =====
    @PostMapping("/{id}/unlock")
    public ResponseEntity<String> unlock(@PathVariable("id") Long id) {
        if (service.getVehicle(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Tesla vehicle " + id + " unlocked.");
    }

    // ===== Section 4: path variables and request parameters (Params and Path Variables P2-P4) =====
    // A path can continue after the variable. Assignment 4's version: /api/products/{id}/category
    @GetMapping("/{id}/model")
    public ResponseEntity<String> getModel(@PathVariable("id") Long id) {
        Vehicle v = service.getVehicle(id);
        if (v == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(v.getModel());           // plain text: Model 3
    }

    // PREDICT before TODO 2: GET /api/vehicles/search with no model at all?
    // TODO 2 (done): model is optional (null if not sent); minYear is optional with a default of 0.
    @GetMapping("/search")
    public List<Vehicle> search(@RequestParam(name = "model", required = false) String model,
                                @RequestParam(name = "minYear", defaultValue = "0") int minYear) {
        return service.search(model, minYear);
    }

    // ===== Section 5: PATCH changes only what was sent (Params and Path Variables P6) =====
    @PatchMapping("/{id}")
    public ResponseEntity<Vehicle> patchVehicle(@PathVariable("id") Long id, @RequestBody Vehicle changes) {
        Vehicle patched = service.patchVehicle(id, changes);
        if (patched == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patched);
    }
}
