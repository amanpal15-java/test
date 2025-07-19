package com.example.BookMyShow.model;

import com.example.BookMyShow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
///// yeh main esme sabke object he rakhna honge esse he process hogi id se kaam nahi hcalega
import java.util.List;
@Entity
@Data // Lombok annotation: generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private Long bookingId;
    @ManyToOne //
    private MovieShow show;

    @Enumerated(EnumType.STRING)
    @OneToMany // ek booking mein multiple seats
    private List<ShowSeats> bookedShow;
    private BookingStatus status;
    @ManyToOne // bht saare booking kar skta ek user
    private User user;
    private double totalAmount;
    @OneToOne // ek booking ki ek txn id
    @JoinColumn(name = "transaction_id")
    private int txnId;
}


//Booking
//        -bookingId
//        -showId
//        -List<ShowSeats> bookedShow
//        -BookingStatus status
//        -totalAmount
//        -txnId
//        -userId