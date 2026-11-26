package net.skillspire.relationships;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final UserService users = new UserService(Map.of(1L, "Ada"));

    // TODO (independent practice, exercise 4): returnsExistingUserName:
    // assert getUserName(1L) returns "Ada" using the supplied fixture.

    // TODO (independent practice, exercise 4): missingUserThrowsCustomException:
    // assertThrows UserNotFoundException for 999L; check message "User not found".
    // Recreate UserNotFoundException from the VehicleNotFoundException pattern if practicing
    // exception construction; the working fixture is supplied so this starter builds.
}
