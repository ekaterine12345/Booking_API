package com.exam.ekaterine_gurgenidze.service;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.HotelDto;

import java.util.List;

public interface HotelService {
    ApiResponse add(HotelDto hotelDto);
    ApiResponse delete(Long Id);
    ApiResponse update(Long Id, HotelDto hotelDto);
    ApiResponse getAll();
    ApiResponse getFreeRooms(List<Long> IdList);
    ApiResponse getHotelReport(Long Id);
}
