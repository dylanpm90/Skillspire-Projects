package net.skillspire.fleet;

// POINT: the same VehicleService, a second interface. VehicleController (@RestController, /api/vehicles)
//        returns data as JSON; this @Controller (/vehicles) returns a VIEW NAME, and Thymeleaf renders
//        templates/<name>.html with the data the method put in the Model.
// ASK:   "Friday's controllers returned a Vehicle. This one returns the String "vehicle-list". Why a String?"

// LMS MVC Design Pattern P3, P5-P7 · Handling Requests and Responses P5, P6, P8 · Assignment 1 (Task Manager)

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;     // for TODO 2

@Controller                          // * SPOT THE BUG: change to @RestController, restart, open /vehicles
@RequestMapping("/vehicles")         // pages at /vehicles; Friday's JSON API stays at /api/vehicles
public class VehiclePageController {
    private final VehicleService service;

    public VehiclePageController(VehicleService service) {     // constructor injection, as always
        this.service = service;
    }

    // ===== Section 1: the list page (Handling Requests P6) =====
    @GetMapping
    public String list(Model model) {
        model.addAttribute("vehicles", service.getAllVehicles());     // the data the page needs
        return "vehicle-list";                                         // the view name: templates/vehicle-list.html
    }

    // ===== Section 2: one vehicle's page (MVC P6) =====
    @GetMapping("/{id}")
    public String showVehicle(@PathVariable("id") Long id, Model model) {
        model.addAttribute("vehicle", findOrThrow(id));
        return "vehicle-details";
    }
    // * PREDICT: /vehicles/99 in the browser. Then /api/vehicles/99 (Friday's). Same service: what differs?

    // ===== Section 3: the add form and its submission (Handling Requests P5-P6) =====
    @GetMapping("/new")              // the literal /new wins over /{id}
    public String showForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());     // an empty Vehicle for th:object to fill
        return "vehicle-form";
    }

    // PREDICT before TODO 2: the form posts to /vehicles, and nothing handles a POST here yet. What happens on Save?
    // TODO 2: write the method that handles the form's POST to /vehicles:
    //         @PostMapping; parameters  @ModelAttribute("vehicle") Vehicle vehicle  and  RedirectAttributes redirectAttributes
    //         save it with  service.addVehicle(vehicle)
    //         redirectAttributes.addFlashAttribute("message", "Vehicle added!");
    //         return "redirect:/vehicles";
    //         Then restart, add a Model X (2025), and refresh the list page.

    @PostMapping
    public String create(
            @ModelAttribute("vehicle") Vehicle vehicle,
            RedirectAttributes redirectAttributes) {

        service.addVehicle(vehicle);
        redirectAttributes.addFlashAttribute("message", "Vehicle added!");
        return "redirect:/vehicles";
    }

    // * SPOT THE BUG (after TODO 2): return "vehicle-list" instead of the redirect. Save a vehicle, then refresh the page.

    // ===== Section 4: a missing vehicle gets a friendly page, not a stack trace (Handling Requests P8) =====
    private Vehicle findOrThrow(Long id) {
        Vehicle v = service.getVehicle(id);       // Friday's service: null means "not found"
        if (v == null) {
            throw new VehicleNotFoundException(id);
        }
        return v;
    }

    @ExceptionHandler(VehicleNotFoundException.class)     // only for this controller's methods
    @ResponseStatus(HttpStatus.NOT_FOUND)                 // the status is still 404
    public String handleNotFound() {
        return "vehicle-not-found";                       // a view name, like every method here
    }
}
