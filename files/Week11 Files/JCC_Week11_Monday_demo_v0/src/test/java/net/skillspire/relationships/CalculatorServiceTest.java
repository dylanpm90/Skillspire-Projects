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

//    @Test
//    void testAdd1() {
//        assertEquals(5, calculator.add(2, 3));
//    }
//
//    @Test
//    void testAdd2() {
//        assertEquals(7, calculator.add(3, 4));
//    }
//
//    @Test
//    void testAdd3() {
//        assertEquals(10, calculator.add(6, 4));
//    }

    // TODO: Replace the three methods above with one @ParameterizedTest and @CsvSource.
    @ParameterizedTest
    @CsvSource({"2,3,5", "3,4,7", "6,4,10"})
    void testAdd(int a, int b, int expected){
        assertEquals(expected, calculator.add(a, b));
    }

    // TODO: Add zero and negative inputs; keep explicit expected results in the rows.
    // TODO: Add a separate @Test proving divide(10, 0) throws ArithmeticException.
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    // TODO (optional, if ahead): Add a static provideNumbers() returning Stream<Arguments> rows
    //   (2,3,5) and (4,6,10), then a @ParameterizedTest @MethodSource("provideNumbers") add test.
    //   Imports: params.provider.Arguments, params.provider.MethodSource, java.util.stream.Stream.
    static Stream<Arguments> provideNumbers() {
        return Stream.of(Arguments.of(2, 3, 5), Arguments.of(4, 6, 10));
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void testAddWithMethodSource(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

}
