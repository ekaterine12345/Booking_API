package com.exam.ekaterine_gurgenidze.controllers;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.ReservationDto;
import com.exam.ekaterine_gurgenidze.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody ReservationDto reservationDto){
      return   this.reservationService.add(reservationDto);
    }

    @GetMapping
    public ApiResponse getAllReservations(){
        return this.reservationService.getAll();
    }
}
