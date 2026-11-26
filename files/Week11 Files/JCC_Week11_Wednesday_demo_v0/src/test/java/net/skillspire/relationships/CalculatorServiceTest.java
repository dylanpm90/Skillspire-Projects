package net.skillspire.relationships;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculator = new CalculatorService();

    @ParameterizedTest
    @CsvSource({"2,3,5", "3,4,7", "6,4,10", "0,0,0", "-2,3,1"})
    void addsInputs(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    static Stream<Arguments> provideNumbers() {
        return Stream.of(Arguments.of(2, 3, 5), Arguments.of(4, 6, 10));
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void addsInputsFromMethod(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @Test
    void divisionByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    // TODO (independent practice, exercise 1): multipliesInputs with @CsvSource
    // rows 3,4,12; 0,4,0; -2,3,-6. Assert calculator.multiply(a, b) per row.
    // Exercise 3: divisionByZeroThrows above was already completed on Monday.
}
