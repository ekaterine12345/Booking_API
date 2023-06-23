package com.exam.ekaterine_gurgenidze.service.impl;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.ReservationDto;
import com.exam.ekaterine_gurgenidze.entities.Reservation;
import com.exam.ekaterine_gurgenidze.repositories.ReservationRepository;
import com.exam.ekaterine_gurgenidze.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ApiResponse add(ReservationDto reservationDto) {
        if (reservationDto.getHotelId() == null){
            return new ApiResponse().addError("error", "reservationDto is empty");
        }

        Reservation reservation = new Reservation(reservationDto);
        Reservation insertedReservation = this.reservationRepository.save(reservation);
        return new ApiResponse("reservation", insertedReservation);
    }

    @Override
    public ApiResponse delete(Long Id) {
        return null;
    }

    @Override
    public ApiResponse update(Long Id, ReservationDto reservationDto) {
        return null;
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("reservations", this.reservationRepository.findAll());
    }
}
