package com.example.BookMyShow.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class City {
    @Id @GeneratedValue
    private Long cityId;
    private String cityName;
    private String state;


    @ElementCollection
    private List<Integer> pinCodes;


}
