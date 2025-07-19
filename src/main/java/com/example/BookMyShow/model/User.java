package com.example.BookMyShow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id @GeneratedValue
    private int userId;
    private String userName;
    private String email;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY) // for learning can change on basis of use
    private City cityId;

}

//@ManyToOne express relationship between person and city
//Also handles foreign key constraint in database
//Enables Cascade Operations and Fetch Strategies : Cascade operations like if a city is deleted then whole user from that city also get deleted
// For ManyToOne or OneToMany Default fetch Type is LAZY i.e. if we dont use related data will not load uncessary data
// reduce query and imporves performance ,,,,, EAGER fetching loaded immediatley with parent entity only useful if we use that object often


//User
//        -userId
//        -userName
//        -email
//        -phoneNumber
//        -city (so we can only show him movie in city)
//        -pinCode (in order of pincode nearest First)

