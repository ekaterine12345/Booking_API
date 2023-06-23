package com.exam.ekaterine_gurgenidze.repositories;

import com.exam.ekaterine_gurgenidze.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
