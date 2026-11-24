package net.skillspire.relationships;

import java.util.Optional;

// Test seam only. Existing Customer and Student repositories still use Spring Data JPA.
public interface VehicleRepository {
    Optional<Vehicle> findById(Long id);
}
