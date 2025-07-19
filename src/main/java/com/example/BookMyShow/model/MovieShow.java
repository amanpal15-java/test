package com.example.BookMyShow.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Entity
@Data // Lombok annotation: generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class MovieShow {
    private Long movieId;
    private Long screenId;

    private LocalTime showTime;
    private List<ShowSeats> showSeatsList;

}


