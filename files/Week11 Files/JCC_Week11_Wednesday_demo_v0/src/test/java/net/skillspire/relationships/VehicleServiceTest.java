package net.skillspire.relationships;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
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

    @ParameterizedTest
    @ValueSource(strings = {"Model S", "Model 3", "Model X", "Model Y"})
    void acceptsSupportedModels(String model) {
        assertTrue(vehicleService.supportsModel(model));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Roadster", "model 3"})
    void rejectsUnsupportedModels(String model) {
        assertFalse(vehicleService.supportsModel(model));
    }

    @Test
    void nullModelIsUnsupported() {
        assertFalse(vehicleService.supportsModel(null));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void constructsVehicleFromCsv(String model, int year) {
        Vehicle vehicle = new Vehicle(model, year);
        assertEquals(model, vehicle.getModel());
        assertEquals(year, vehicle.getYear());
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, -5, -10, 0})
    void invalidIdsFailBeforeLookup(long id) {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class, () -> vehicleService.getVehicle(id));
        assertEquals("Invalid vehicle ID", ex.getMessage());
        verifyNoInteractions(repo);
    }

    @Test
    void nullIdFailsBeforeLookup() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class, () -> vehicleService.getVehicle(null));
        assertEquals("Invalid vehicle ID", ex.getMessage());
        verifyNoInteractions(repo);
    }

    @Test
    void missingPositiveIdThrowsNotFound() {
        when(repo.findById(999L)).thenReturn(Optional.empty());
        VehicleNotFoundException ex = assertThrows(
                VehicleNotFoundException.class, () -> vehicleService.getVehicle(999L));
        assertEquals("Vehicle not found", ex.getMessage());
        verify(repo).findById(999L);
    }
}
