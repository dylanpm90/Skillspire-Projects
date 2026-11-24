package net.skillspire.fleet;

// Wednesday's, unchanged. No ProfileRepository: cascade saves each profile with its driver.

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
