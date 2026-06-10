package com.example.hakura_restaurant.controller;

import com.example.hakura_restaurant.dto.BaseResponse;
import com.example.hakura_restaurant.dto.CreateReservationRequest;
import com.example.hakura_restaurant.dto.ReservationsResponse;
import com.example.hakura_restaurant.dto.UpdateReservationRequest;
import com.example.hakura_restaurant.entity.Reservation;
import com.example.hakura_restaurant.service.ReservationService;
import com.example.hakura_restaurant.utils.ResponseBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public BaseResponse<ReservationsResponse> getAllReservations() {
        return ResponseBuilder.success(reservationService.getAllReservations());
    }

    @PostMapping
    public BaseResponse<Reservation> createReservation(@RequestBody CreateReservationRequest request) {
        return ResponseBuilder.success(reservationService.createReservation(request));
    }

    @PutMapping("/{id}")
    public BaseResponse<String> updateReservation(@PathVariable Long id, @RequestBody UpdateReservationRequest request) {
        Long execute = reservationService.updateReservation(id, request);
        return ResponseBuilder.success("Update reservation successfully: " + execute);
    }

    @DeleteMapping("/{id}")
    public BaseResponse<String> removeReservation(@PathVariable Long id) {
        return ResponseBuilder.success(reservationService.remove(id));
    }
}
