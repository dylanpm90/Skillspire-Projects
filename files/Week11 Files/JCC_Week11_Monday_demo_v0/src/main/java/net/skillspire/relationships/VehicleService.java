package net.skillspire.relationships;

import java.util.Set;

// Construct directly in unit tests; no Spring context or database is needed.
public class VehicleService {
    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    public boolean supportsModel(String model) {
        return model != null && Set.of("Model S", "Model 3", "Model X", "Model Y").contains(model);
    }

    public Vehicle getVehicle(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid vehicle ID");
        }
        return repo.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));
    }
}
