package com.exam.ekaterine_gurgenidze.controllers;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.HotelDto;
import com.exam.ekaterine_gurgenidze.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody HotelDto hotelDto){
       return  this.hotelService.add(hotelDto);
    }

    @GetMapping
    public ApiResponse getAllHotels(){
        return this.hotelService.getAll();
    }

    @GetMapping("/free_rooms_prices")
    public ApiResponse getFreeRoomsWithPrices(@RequestBody List<Long> my_ids){
        System.out.println(my_ids);
        return this.hotelService.getFreeRooms(my_ids);
    }

    @GetMapping("/hotel_report/{id}")
    public ApiResponse getYearlyReport(@PathVariable("id") Long Id ){
        System.out.println("report for hotel id = " + Id);

        return this.hotelService.getHotelReport(Id);
    }
}
