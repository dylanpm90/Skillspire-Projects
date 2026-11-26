package net.skillspire.relationships;

import java.util.Map;

// Exercise 4 fixture: an in-memory lookup, with no authentication or persistence.
public class UserService {
    private final Map<Long, String> users;

    public UserService(Map<Long, String> users) {
        this.users = users;
    }

    public String getUserName(long id) {
        String name = users.get(id);
        if (name == null) {
            throw new UserNotFoundException("User not found");
        }
        return name;
    }
}
