package net.skillspire.fleet;

// Wednesday's, unchanged.
// POINT: Profile is an ordinary entity. It doesn't know about Driver: the link lives in Driver.profile.

// LMS Entities and Relationships P2 (one-to-one).

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;
    private String city;

    public Profile() {
    }

    public Profile(String phone, String city) {
        this.phone = phone;
        this.city = city;
    }

    public Long getId() { return id; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return phone + ", " + city;
    }
}
