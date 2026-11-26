package net.skillspire.relationships;

import org.junit.jupiter.api.Test;
// TODO: Add ParameterizedTest, CsvSource and ValueSource imports for the tests below.
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeslaServiceTest {
    private final VehicleRepository repo = mock(VehicleRepository.class);
    private final TeslaService teslaService = new TeslaService(repo);

    @Test
    void unlocksExistingVehicle() {
        when(repo.findById(1L)).thenReturn(Optional.of(new Vehicle("Model 3", 2022)));
        assertEquals("Unlocked Model 3", teslaService.unlockVehicle(1L));
        verify(repo).findById(1L);
    }

    // TODO: testTeslaModels: @ParameterizedTest + @CsvSource with Model S/2021,
    // Model 3/2022 and Model Y/2023; construct Vehicle, assert both getters.

    // TODO: testUnlockInvalidId: @ValueSource(longs = {-1, 0}); assertThrows
    // IllegalArgumentException, assert "Invalid vehicle ID", verifyNoInteractions(repo).

    // TODO: testUnlockNullId: separate @Test; assert the same type/message and no lookup.

    // TODO: testUnlockNonExistentVehicle: stub 999L to Optional.empty(), assert
    // VehicleNotFoundException + "Vehicle not found", and verify findById(999L).
}
