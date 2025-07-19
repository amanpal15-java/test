package com.example.JPA;
import jakarta.persistence.*;

import java.util.List;
// OneToMany or ManyToOne
public class OneToMany {
    @Entity
    public class Booking {
        @Id @GeneratedValue
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id") // FK in Booking table
        private User user;
    }

    @Entity
    public class User {
        @Id @GeneratedValue
        private Long id;

        @jakarta.persistence.OneToMany(mappedBy = "user")
        private List<Booking> bookings;
    }
}

//The many side (Booking) owns the relationship (has the FK).
//The one side (User) uses mappedBy.
