package net.skillspire.review;

// POINT: a URL runs a method. Spring Boot set up the web server (Tomcat) for us,
//        and nobody writes  new ChargingController() : Spring does, at startup.
// ASK:   "What does the browser show for localhost:8080/charging/42 ? And for localhost:8080 ?"

// LMS "Introduction to Spring Boot" P9. Same file in review-jdbc and review-jpa.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                  // "Spring, create one of these and send web requests to it"
@RequestMapping("/charging")     // every URL handled here starts with /charging
public class ChargingController {

    @GetMapping("/{stationId}")  // GET /charging/42 runs this method; "42" goes into stationId
    public String getStation(@PathVariable("stationId") String stationId) {
        return "Station " + stationId + " is online.";
    }
}
