package net.skillspire.fleet;

// Wednesday's, unchanged. The many-to-many has no cascade, so the runner saves the stations itself.

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargingStationRepository extends JpaRepository<ChargingStation, Long> {
}
