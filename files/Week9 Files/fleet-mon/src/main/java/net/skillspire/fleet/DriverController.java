package net.skillspire.fleet;

// POINT: a nested path names a resource inside another one. /api/drivers/1/vehicles/2 is vehicle 2,
//        but only if it's driver 1's: the finder checks both ids, so a wrong owner gets 404.
// ASK:   "Why a second controller? Could VehicleController serve /api/drivers/...?"

// LMS Params and Path Variables P5. Assignment 4: /api/customers/{customerId}/orders/{orderId}

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drivers")     // every path in this class starts here
public class DriverController {
    private final VehicleService service;

    public DriverController(VehicleService service) {
        this.service = service;
    }

    // A path variable and a request parameter together: GET /api/drivers/1/vehicles?minYear=2020
    @GetMapping("/{driverId}/vehicles")
    public List<Vehicle> getDriversVehicles(@PathVariable("driverId") Long driverId,
                                            @RequestParam(name = "minYear", defaultValue = "0") int minYear) {
        return service.getDriversVehicles(driverId, minYear);     // unknown driver: 200 with []
    }

    // Two path variables: GET /api/drivers/1/vehicles/2
    @GetMapping("/{driverId}/vehicles/{vehicleId}")
    public ResponseEntity<Vehicle> getDriversVehicle(@PathVariable("driverId") Long driverId,
                                                     @PathVariable("vehicleId") Long vehicleId) {
        Vehicle v = service.getDriversVehicle(driverId, vehicleId);
        if (v == null) {
            return ResponseEntity.notFound().build();      // 404: no vehicle, or not this driver's
        }
        return ResponseEntity.ok(v);                       // 200
    }
    // * PREDICT: GET /api/drivers/2/vehicles/2 (vehicle 2 is Alice's Model 3; driver 2 is Bob).
}
