package com.example.hakura_restaurant.dto;


import lombok.Data;

@Data
public class UpdateReservationRequest {
    private String status;
    private Integer numberOfPeople;
}
