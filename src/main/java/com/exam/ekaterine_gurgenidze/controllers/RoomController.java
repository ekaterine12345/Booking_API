package com.exam.ekaterine_gurgenidze.controllers;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.RoomDto;
import com.exam.ekaterine_gurgenidze.service.RoomService;
import org.hibernate.metamodel.internal.AbstractPojoInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ApiResponse getAllRooms(){
        return this.roomService.getAll();
    }

    @PostMapping("/add")
    public ApiResponse addRoom(@RequestBody RoomDto roomDto){
        System.out.println("Room Dto = " + roomDto);
        return this.roomService.add(roomDto);
    }

    @GetMapping("/free")
    public ApiResponse getFreeRooms(){
        return this.roomService.getEmptyRooms();
    }

    @GetMapping("/not_free")
    public ApiResponse getNotFreeRooms(){
        return this.roomService.getNotEmptyRooms();
    }
}
