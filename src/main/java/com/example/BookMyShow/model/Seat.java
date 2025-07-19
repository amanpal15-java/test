package com.example.BookMyShow.model;

import com.example.BookMyShow.enums.SeatStatus;
import com.example.BookMyShow.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Lombok annotation: generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    private Long seatId;
    @ManyToOne
    private  Screen screen;
    private int rowId;
    private int columnId;
    private SeatStatus seatStatusList;
    private SeatType seatType;
}

//Seat
//        -screenId
//        -seatId
//        -rowId
//        -columnId
//        -seatStatus
//        -seatType