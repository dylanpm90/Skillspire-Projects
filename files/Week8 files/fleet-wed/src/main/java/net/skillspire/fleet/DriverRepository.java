package net.skillspire.fleet;

// Same idea as Monday's VehicleRepository: Spring Data writes the class. Nothing to add tonight.
// No ProfileRepository: cascade saves each profile with its driver.

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
