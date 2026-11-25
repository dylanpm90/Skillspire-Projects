package net.skillspire.relationships;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Optional;

class VehicleLookupTest {
    private final VehicleRepository repo = mock(VehicleRepository.class);
    private final VehicleService vehicleService = new VehicleService(repo);

    @Test
    void testVehicleNotFound() {
        when(repo.findById(999L)).thenReturn(Optional.empty());
        VehicleNotFoundException ex = assertThrows(
                VehicleNotFoundException.class, () -> vehicleService.getVehicle(999L));
        assertEquals("Vehicle not found", ex.getMessage());
        verify(repo).findById(999L);
    }
}
