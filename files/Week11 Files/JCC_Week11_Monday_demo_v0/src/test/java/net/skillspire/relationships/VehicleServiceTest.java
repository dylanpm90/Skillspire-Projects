package net.skillspire.relationships;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VehicleServiceTest {
    private final VehicleRepository repo = mock(VehicleRepository.class);
    private final VehicleService vehicleService = new VehicleService(repo);

    @Test
    void returnsExistingVehicle() {
        Vehicle vehicle = new Vehicle("Model 3", 2022);
        when(repo.findById(1L)).thenReturn(Optional.of(vehicle));
        assertSame(vehicle, vehicleService.getVehicle(1L));
        verify(repo).findById(1L);
    }

    // TODO: Use @ValueSource to test supported Tesla model names.
    // TODO (if ahead): Use @ValueSource to prove "", "Roadster" and "model 3" are unsupported.
    // TODO (if ahead): Add a separate test proving supportsModel(null) is false.
    // TODO (if time allows): Use @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    //   to construct Vehicles and check both getters.
    // TODO: Test invalid IDs -1, -5, -10 and 0 with IllegalArgumentException; check its message.
    // TODO: Add a separate null-ID test; check its message too. Prove invalid input never calls the repository.
    // TODO: Stub positive ID 999 as missing; check VehicleNotFoundException and its message,
    //   and verify the lookup.
}
