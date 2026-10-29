package net.skillspire.tesla;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Point: the controller turns web requests into repository calls. No SQL in here (LMS P8).
//        POST creates, GET reads, PUT updates, DELETE deletes.
// Ask:   "A browser only sends GET. How do we send the other three?"

// LMS Spring JDBC P5. The annotations in detail (@PostMapping, @RequestBody, status codes): Week 8.

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleRepository repo;

    public VehicleController(VehicleRepository repo) {   // Spring hands in the repository (map step 3)
        this.repo = repo;
    }

    // GET /vehicles : the List<Vehicle> goes back as JSON (Spring Web's JSON support)
    @GetMapping
    public List<Vehicle> getAll() {
        return repo.getAllVehicles();
    }

    // GET /vehicles/2
    // * PREDICT before opening localhost:9090/vehicles/2: exactly what appears?
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable("id") int id) {
        return repo.getVehicleById(id);
    }

    // POST /vehicles with a JSON body. Spring makes the Vehicle: new Vehicle(), setModel, setYear.
    @PostMapping
    public String addVehicle(@RequestBody Vehicle v) {
        int rows = repo.addVehicle(v);
        return "Vehicle added! Rows affected: " + rows;
    }

    // PUT /vehicles/2 with a JSON body holding the new model and year
    @PutMapping("/{id}")
    public String update(@PathVariable("id") int id, @RequestBody Vehicle v) {
        v.setId(id);   // the id comes from the URL, not from the body
        int rows = repo.updateVehicle(v);
        return "Vehicle updated! Rows affected: " + rows;
    }

    // DELETE /vehicles/3
    // PREDICT: DELETE /vehicles/99. An error, like GET /vehicles/99? If not, what number?
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        int rows = repo.deleteVehicle(id);
        return "Vehicle deleted! Rows affected: " + rows;
    }
}
