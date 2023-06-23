package com.exam.ekaterine_gurgenidze.service;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.ReservationDto;
import com.exam.ekaterine_gurgenidze.dtos.RoomDto;

public interface ReservationService {
    ApiResponse add(ReservationDto reservationDto);
    ApiResponse delete(Long Id);
    ApiResponse update(Long Id, ReservationDto reservationDto);
    ApiResponse getAll();
}
