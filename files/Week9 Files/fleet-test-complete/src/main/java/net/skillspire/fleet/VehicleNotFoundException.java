package net.skillspire.fleet;

// POINT: a specific exception for a specific problem. VehiclePageController turns it into a 404 page;
//        a bug in our code is still a 500.
// LMS Handling Requests and Responses P8.

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(Long id) {
        super("Vehicle " + id + " was not found.");
    }
}
