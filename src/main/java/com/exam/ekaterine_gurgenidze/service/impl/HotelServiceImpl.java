package com.exam.ekaterine_gurgenidze.service.impl;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.HotelDto;
import com.exam.ekaterine_gurgenidze.entities.Hotel;
import com.exam.ekaterine_gurgenidze.repositories.HotelRepository;
import com.exam.ekaterine_gurgenidze.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;


    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public ApiResponse add(HotelDto hotelDto) {
        if (hotelDto.getName() == null){
            return new ApiResponse().addError("error", "hotelDto is empty");
        }

        Hotel hotel = new Hotel(hotelDto);
        Hotel insertedHotel = this.hotelRepository.save(hotel);
        return new ApiResponse("hotel", insertedHotel);
    }

    @Override
    public ApiResponse delete(Long Id) {
        return null;
    }

    @Override
    public ApiResponse update(Long Id, HotelDto hotelDto) {
        return null;
    }

    @Override
    public ApiResponse getAll() {
        return  new ApiResponse("hotels", this.hotelRepository.findAll());
    }

    @Override
    public ApiResponse getFreeRooms(List<Long> IdList) {
        // kvelastivs unda davumato
        Map<String, Object> freeRoomsInHotel = new HashMap<>();
        for(int i=0; i< IdList.size(); i++){
            freeRoomsInHotel.put(" hotel id = "+IdList.get(i), this.hotelRepository.findFreeRoomsByHotelId(IdList.get(i)));
        }
        return new ApiResponse("free rooms and prices", freeRoomsInHotel);
    }

    @Override
    public ApiResponse getHotelReport(Long Id) {

        return new ApiResponse("hotel", this.hotelRepository.getHotelReport(Id));
    }
}
