package com.example.hakura_restaurant.repository;

import com.example.hakura_restaurant.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
