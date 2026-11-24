package net.skillspire.relationships;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculator = new CalculatorService();

    @Test
    void testAdd1() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testAdd2() {
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    void testAdd3() {
        assertEquals(10, calculator.add(6, 4));
    }

    // TODO: Replace the three methods above with one @ParameterizedTest and @CsvSource.
    // TODO: Add zero and negative inputs; keep explicit expected results in the rows.
    // TODO: Add a separate @Test proving divide(10, 0) throws ArithmeticException.
    // TODO (optional, if ahead): Add a static provideNumbers() returning Stream<Arguments> rows
    //   (2,3,5) and (4,6,10), then a @ParameterizedTest @MethodSource("provideNumbers") add test.
    //   Imports: params.provider.Arguments, params.provider.MethodSource, java.util.stream.Stream.
}
