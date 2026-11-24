package net.skillspire.fleet;

// POINT: plain JUnit. No Spring, no mocks: create the object, call a method, assert the result.
//        A normal case, edge cases and an invalid input. @BeforeEach gives every test a fresh battery.
// ASK:   "Why does every test get a new Battery instead of sharing one?"

// LMS Introduction to Unit Testing Frameworks P2. Assignment 2 Part 1.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatteryTest {
    private Battery battery;

    @BeforeEach
    void setUp() {
        battery = new Battery(50);      // runs before EACH test
    }

    @Test
    void chargeAddsToTheLevel() {
        battery.charge(30);
        assertEquals(80, battery.getLevel());     // expected first, then actual
    }
    // * PREDICT: change 80 to 81 and run. What does the failure message say?

    @Test
    void chargeStopsAt100() {
        battery.charge(80);
        assertEquals(100, battery.getLevel());    // edge case: the cap
    }

    // TODO 1 (done): test the boundary of isLow(): 19 is low, 20 is not.
    @Test
    void isLowBelow20() {
        assertTrue(new Battery(19).isLow());
        assertFalse(new Battery(20).isLow());
    }

    @Test
    void negativeChargeIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> battery.charge(-10));   // invalid input
    }
}
