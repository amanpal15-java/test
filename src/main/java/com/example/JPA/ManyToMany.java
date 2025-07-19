package com.example.JPA;
import jakarta.persistence.*;

import java.util.List;

public class ManyToMany {
    @Entity
    public class Movie {
        @Id @GeneratedValue
        private Long id;

        @jakarta.persistence.ManyToMany
        @JoinTable(
                name = "movie_actor",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id")
        )
        private List<Actor> actors;
    }

    @Entity
    public class Actor {
        @Id @GeneratedValue
        private Long id;

        @jakarta.persistence.ManyToMany(mappedBy = "actors")
        private List<Movie> movies;
    }
}
