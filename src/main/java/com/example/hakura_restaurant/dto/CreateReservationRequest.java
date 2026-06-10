package com.example.hakura_restaurant.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CreateReservationRequest {
    private String name;
    private String note;
    private String phone;
    private String status;
    private Integer numberOfPeople;
    private Timestamp time;
}
