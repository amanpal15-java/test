package com.example.BookMyShow.model;

import com.example.BookMyShow.enums.Genre;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data // Lombok annotation: generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Long movieId;
    private String movieName;
    private LocalDate releaseDate;
    private String summary;
    @ElementCollection // many to mapping table mapping ka bhi dekhta
    private List<String> supportingLanguages;

    @ElementCollection // many to mapping table mapping ka bhi dekhta
    private List<String> castMembers;

    @ElementCollection // many to mapping table mapping ka bhi dekhta
    @Enumerated(EnumType.STRING)
    private List<Genre> genres;

}

// @Enumerated(EnumType.STRING)
// A JPA entity is a plain Java object (POJO) that is mapped to a table in a relational database using the Java Persistence API (JPA).
// Why Use JPA Entities?
//Object-Relational Mapping (ORM):
//JPA entities allow you to work with database data as regular Java objects, making your code cleaner and more maintainable.
//Automatic Table Creation:
//JPA can automatically create tables based on your entity classes.
//Easy Data Access:
//You can use repositories to easily perform CRUD operations.

// when we use enum as JPA entity we can specify in which type it will store the object
// or else it will store it in 0,1..9 format in database
// if we want that it will store it in string format then we have to specify



