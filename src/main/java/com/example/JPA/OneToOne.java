package com.example.JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class OneToOne {

    @Entity
    public class User {
        @Id
        @GeneratedValue
        private Long id;

        @jakarta.persistence.OneToOne
        @JoinColumn(name = "profile_id") // FK in User table
        private Profile profile;
    }

    @Entity
    public class Profile {
        @Id @GeneratedValue
        private Long id;

        @jakarta.persistence.OneToOne(mappedBy = "profile")
        private User user;
    }
}

//The side with @JoinColumn is the owning side (has the FK).
//The other side uses mappedBy.