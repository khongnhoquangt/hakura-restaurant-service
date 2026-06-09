package com.example.hakura_restaurant.service;

import com.example.hakura_restaurant.dto.ReservationsResponse;
import com.example.hakura_restaurant.dto.UpdateReservationRequest;
import com.example.hakura_restaurant.entity.Reservation;
import com.example.hakura_restaurant.repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationsResponse getAllReservations() {
        List<Reservation> reservationList = reservationRepository.findAll();
        return ReservationsResponse.builder().items(reservationList).build();
    }

    public Long updateReservation(Long id, UpdateReservationRequest request) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found reservation"));
        if (request.getStatus() != null) {
            reservation.setStatus(request.getStatus());
        }
        if (request.getNumberOfPeople() != null) {
            reservation.setNumberOfPeople(request.getNumberOfPeople());
        }
        reservationRepository.save(reservation);
        return id;
    }

    public String remove(Long id) {
      reservationRepository.deleteById(id);
      return "Reservation removed: " + id;
    };

}
