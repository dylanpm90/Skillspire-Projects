package net.skillspire.tesla;

// Point: on Mon 10/19,  Car(Engine engine)  got its part through the constructor, and main did the new.
//        Here Spring does the new and hands the part in. That is dependency injection.
// Ask:   "When do the two 'created by Spring' lines print: when you open the page, or at startup?"

// CHECKS: 2 required in this file. * = the one to do if you only do one.
//         EXTRA = only if a block finishes early.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationService service;   // HAS A service (Week 6 composition), set once (final, Week 5)

    // Spring calls this constructor and passes in its StationService bean.
    // Nobody writes  new StationController(new StationService())  anywhere.
    public StationController(StationService service) {
        this.service = service;
        System.out.println("  StationController created by Spring, got a StationService");
    }

    @GetMapping("/{stationId}")
    public String status(@PathVariable("stationId") String stationId) {
        return service.status(stationId);   // delegation (Mon 10/19)
    }

    // * PREDICT: restart the app. Do the two "created by Spring" lines print at startup,
    //   or when you open  localhost:9090/stations/7 ?  Which one prints first?
    // SPOT THE BUG: in StationService.java comment out  @Service  and restart. Read the box in the log.
    //   (Parameter 0 of constructor in net.skillspire.tesla.StationController required a bean of type
    //    'net.skillspire.tesla.StationService' that could not be found.)
    // EXTRA: the LMS writes  @Autowired private JdbcTemplate jdbcTemplate;  (a field Spring fills in).
    //   Same idea. The constructor way is what the Week 7 Worksheet's BankService uses.
}
