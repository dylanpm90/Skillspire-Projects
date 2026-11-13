package net.skillspire.fleet;

// POINT: a unit test of ONE class. The repository is a Mockito mock, so there is no Spring and
//        no database: we decide what the repository returns, then check what the service does.
// ASK:   "Monday's teaser: how do we check patchVehicle keeps the old model without starting the app?"

// LMS Introduction to Unit Testing Frameworks P3 · Testing Controllers, Services, and Repositories P2.
// Assignment 2 Part 2, item 4: @Mock, @InjectMocks, when/thenReturn, verify, a not-found case.

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)     // turns on @Mock and @InjectMocks
class VehicleServiceTest {

    @Mock
    private VehicleRepository repo;      // a fake repository: no database

    @InjectMocks
    private VehicleService service;      // the REAL service, built with the mock in its constructor

    // ===== Section 1: found and not found (P3) =====
    @Test
    void getVehicleReturnsTheVehicleWhenItExists() {
        Vehicle modelS = new Vehicle("Model S", 2019);
        when(repo.findById(1L)).thenReturn(Optional.of(modelS));     // arrange: what the mock returns

        Vehicle result = service.getVehicle(1L);                       // act

        assertEquals("Model S", result.getModel());                    // assert
        verify(repo).findById(1L);                                     // the service really asked the repository
    }

    // TODO 2: the not-found case. Write getVehicleReturnsNullWhenTheIdIsUnknown():
    //         make repo.findById(99L) return Optional.empty(), then assertNull(service.getVehicle(99L)).
    // * PREDICT: delete the when(...) line. Does the test still pass? (What does an unstubbed mock return?)

    // ===== Section 2: Monday's teaser. PATCH keeps what wasn't sent =====
    @Test
    void patchKeepsTheModelWhenOnlyTheYearIsSent() {
        Vehicle modelY = new Vehicle("Model Y", 2024);
        when(repo.findById(3L)).thenReturn(Optional.of(modelY));
        when(repo.save(modelY)).thenReturn(modelY);

        Vehicle changes = new Vehicle();     // like PATCH {"year": 2025}: model is null
        changes.setYear(2025);
        Vehicle result = service.patchVehicle(3L, changes);

        assertEquals("Model Y", result.getModel());
        assertEquals(2025, result.getYear());
    }

    // ===== Section 3: an exception, and checking that something did NOT happen =====
    @Test
    void negativeMinYearIsRejectedBeforeTheDatabase() {
        assertThrows(IllegalArgumentException.class, () -> service.search("Model S", -5));

        verify(repo, never()).findByModelAndYearGreaterThanEqual(anyString(), anyInt());
    }
}
