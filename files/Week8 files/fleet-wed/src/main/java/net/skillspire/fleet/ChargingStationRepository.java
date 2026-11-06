package net.skillspire.fleet;

// Needed: the many-to-many has no cascade, so the runner saves the stations itself.

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargingStationRepository extends JpaRepository<ChargingStation, Long> {
}
