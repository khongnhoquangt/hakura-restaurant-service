package com.example.hakura_restaurant.dto;

import com.example.hakura_restaurant.entity.Reservation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReservationsResponse {
    private List<Reservation> items;
}
