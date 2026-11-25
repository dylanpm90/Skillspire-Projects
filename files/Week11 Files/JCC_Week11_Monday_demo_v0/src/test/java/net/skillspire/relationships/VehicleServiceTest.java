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

//    @Test
//    void returnsExistingVehicle() {
//        Vehicle vehicle = new Vehicle("Model 3", 2022);
//        when(repo.findById(1L)).thenReturn(Optional.of(vehicle));
//        assertSame(vehicle, vehicleService.getVehicle(1L));
//        verify(repo).findById(1L);
//    }

    // TODO: Use @ValueSource to test supported Tesla model names.
    @ParameterizedTest
    @ValueSource(strings = {"Model S", "Model 3", "Model X"})
    void testVehicleModels(String model) {
        assertTrue(vehicleService.supportsModel(model));
    }

    // TODO (if ahead): Use @ValueSource to prove "", "Roadster" and "model 3" are unsupported.
    // TODO (if ahead): Add a separate test proving supportsModel(null) is false.
    // TODO (if time allows): Use @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    //   to construct Vehicles and check both getters.
    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testVehicleData(String model, int year) {
        Vehicle vehicle = new Vehicle(model, year);
        assertEquals(model, vehicle.getModel());
        assertEquals(year, vehicle.getYear());
    }

    // TODO: Test invalid IDs -1, -5, -10 and 0 with IllegalArgumentException; check its message.
    @Test
    void testInvalidVehicle() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class, () -> vehicleService.getVehicle(-1L));
        assertEquals("Invalid vehicle ID", ex.getMessage());
    }

    // TODO: Add a separate null-ID test; check its message too. Prove invalid input never calls the repository.
    @ParameterizedTest
    @ValueSource(longs = {-1, -5, -10, 0})
    void testInvalidIdsThrowException(long id) {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class, () -> vehicleService.getVehicle(id));
        assertEquals("Invalid vehicle ID", ex.getMessage());
        verifyNoInteractions(repo);
    }

    @Test
    void testNullId() {
        assertThrows(IllegalArgumentException.class, () -> vehicleService.getVehicle(null));
        verifyNoInteractions(repo);
    }

    // TODO: Stub positive ID 999 as missing; check VehicleNotFoundException and its message,
    //   and verify the lookup.


}
