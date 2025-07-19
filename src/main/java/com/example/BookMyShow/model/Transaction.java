package com.example.BookMyShow.model;

import com.example.BookMyShow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@Entity
@Data // Lombok annotation: generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {


    private Long txnId;
    private PaymentStatus paymentStatus;
    private LocalTime txnTimeStamp;
    private double amount;
    @OneToOne(mappedBy = "transaction")
    private Booking booking;


}
//
// mappedBy(oneToOne or OneToMany) attribute in JPA indicates which side of relation owns the relationship in database
// it tells JPA which entity cantains foreign key column
// it is needed because in bidirectional relationship both point each other ans to determinw who owns the relation ship


//Transaction
//        -txnId
//        -PaymentStatus
//        -txnTimeStamp
//        -amount