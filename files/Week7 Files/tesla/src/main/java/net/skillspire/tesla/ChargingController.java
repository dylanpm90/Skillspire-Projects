package net.skillspire.tesla;

// Point: a URL runs a method. Spring Boot set up the web server (Tomcat) for us,
//        and we never wrote  new ChargingController().
// Ask:   "We never called new on this class. Who did, and when?"

// LMS "Introduction to Spring Boot" P9 (Tesla back end), with the path variable named explicitly.
// The LMS's short form, @PathVariable String stationId, normally works too.
// @RestController, @RequestMapping, @GetMapping, @PathVariable are Week 8. Tonight: the URL picks the method.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                  // a note to Spring: create one of these and send web requests to it
@RequestMapping("/charging")     // every URL handled here starts with /charging
public class ChargingController {

    @GetMapping("/{stationId}")  // GET /charging/42 runs this method; "42" goes into stationId
    public String getStation(@PathVariable("stationId") String stationId) {
        return "Station " + stationId + " is online.";
    }

    // * PREDICT before opening it: what does the browser show for  localhost:8080/charging/42 ?
    //   And for  localhost:8080/charging  (no number)?
    //   (At 6:20 the app moves to port 9090; same paths after that.)
    // EXTRA WRITE ONE LINE: change the message, refresh. Same old text? Restart the app, refresh again.
}
