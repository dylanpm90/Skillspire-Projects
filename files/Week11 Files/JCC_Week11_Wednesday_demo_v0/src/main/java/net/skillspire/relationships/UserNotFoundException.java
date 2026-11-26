package net.skillspire.relationships;

// Exercise 4 setup, using the same custom-exception pattern as VehicleNotFoundException.
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
