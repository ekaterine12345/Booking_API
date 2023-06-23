package com.exam.ekaterine_gurgenidze.service;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.HotelDto;
import com.exam.ekaterine_gurgenidze.dtos.RoomDto;

public interface RoomService {

    ApiResponse add(RoomDto roomDto);
    ApiResponse delete(Long Id);
    ApiResponse update(Long Id, RoomDto roomDto);
    ApiResponse getAll();
    ApiResponse getEmptyRooms();
    ApiResponse getNotEmptyRooms();

}
