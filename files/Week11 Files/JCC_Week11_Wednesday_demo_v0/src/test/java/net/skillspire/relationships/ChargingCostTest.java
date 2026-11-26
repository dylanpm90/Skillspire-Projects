package net.skillspire.relationships;

import org.junit.jupiter.api.Test;
// TODO: Add ParameterizedTest, CsvSource and ValueSource imports with the new tests.
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ChargingCostTest {
    private final TeslaService teslaService = new TeslaService(mock(VehicleRepository.class));

    @Test
    void zeroEnergyCostsNothing() {
        assertEquals(0, teslaService.chargingCostCents(0, 25));
    }

    // TODO 1: calculatesChargingCost: @ParameterizedTest + @CsvSource rows
    // 10,25,250; 20,25,500; 0,25,0; 7,30,210. Assert the service result per row.
    // Run first: 3 nonzero rows should fail (expected 250/500/210, actual 0).
    // Keep these tests unchanged during green and refactor in TeslaService.

    // TODO 4: rejectsNegativeEnergy: @ValueSource(ints = {-1, -5}); rate 25;
    // assert IllegalArgumentException and "Energy must not be negative".

    // TODO 4: rejectsNonpositiveRate: @ValueSource(ints = {0, -1}); energy 10;
    // assert IllegalArgumentException and "Rate must be positive".
}
