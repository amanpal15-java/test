package com.example.BookMyShow.model;

import com.example.BookMyShow.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Lombok annotation: generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeats {
    private Long showSeatId;
    @ManyToOne // many seats in one show
    private MovieShow show;
    private Seat seat;
    private SeatStatus seatStatus;
    private double price;
}

//showSeats
//        -showSeatId
//        -showId
//        -seatId
//        -seatStatus
//        -price
