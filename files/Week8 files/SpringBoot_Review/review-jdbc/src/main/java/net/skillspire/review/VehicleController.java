package net.skillspire.review;

// POINT: layer 1, the front door. Turns each web request into ONE service call. No SQL, no rules here.
//        This file is the same, character for character, in review-jdbc and review-jpa:
//        swapping the database code didn't touch it.
// ASK:   "GET /vehicles/2: which method runs, and where does the 2 go?"

// LMS Spring JDBC P5 (the controller), with a service in the middle (LMS Spring Data JPA P5).

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;   // HAS A service (Week 6 composition)

    // Spring calls this constructor at startup and hands in its VehicleService bean.
    public VehicleController(VehicleService service) {
        this.service = service;
        System.out.println(">> VehicleController created by Spring, got a VehicleService");
    }

    // GET /vehicles : the List goes back to the browser as JSON
    @GetMapping
    public List<Vehicle> getAll() {
        return service.getAll();
    }

    // GET /vehicles/2 : "2" from the URL goes into id
    // * PREDICT: what does GET /vehicles/99 show? (There is no car 99.)
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    // POST /vehicles with a JSON body. Spring turns the JSON into a Vehicle: new Vehicle(), then the setters.
    @PostMapping
    public String add(@RequestBody Vehicle v) {
        service.add(v);
        return "Vehicle added!";
    }

    // PUT /vehicles/2 with a JSON body holding the new model and year
    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody Vehicle v) {
        if (service.update(id, v)) {
            return "Vehicle " + id + " updated!";
        }
        return "No vehicle with id " + id;
    }

    // DELETE /vehicles/4
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (service.delete(id)) {
            return "Vehicle " + id + " deleted!";
        }
        return "No vehicle with id " + id;
    }
}
