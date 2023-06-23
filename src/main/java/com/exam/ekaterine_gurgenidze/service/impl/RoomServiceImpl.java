package com.exam.ekaterine_gurgenidze.service.impl;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.RoomDto;
import com.exam.ekaterine_gurgenidze.entities.Reservation;
import com.exam.ekaterine_gurgenidze.entities.Room;
import com.exam.ekaterine_gurgenidze.repositories.RoomRepository;
import com.exam.ekaterine_gurgenidze.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public ApiResponse add(RoomDto roomDto) {

        if (roomDto.getRoomNumber() == null) {
            return new ApiResponse().addError("error", "doomDto is empty");
        }

        Room room = new Room(roomDto);
        Room insertedRoom = this.roomRepository.save(room);
        return new ApiResponse("room", insertedRoom);
    }

    @Override
    public ApiResponse delete(Long Id) {
        return null;
    }

    @Override
    public ApiResponse update(Long Id, RoomDto roomDto) {
        return null;
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("rooms", this.roomRepository.findAll());
    }

    @Override
    public ApiResponse getEmptyRooms() { // Free rooms
       // return new ApiResponse("free rooms", this.roomRepository.findByIsEmptyTrue());

        return new ApiResponse("free rooms", this.roomRepository.findFreeRooms());
    }

    @Override
    public ApiResponse getNotEmptyRooms() {
        return new ApiResponse("not free rooms", this.roomRepository.findNotFreeRooms());
    }



//        private List<Room> rooms;
//        private List<Reservation> reservations;
//
//        public ReservationSystem() {
//            rooms = new ArrayList<>();
//            reservations = new ArrayList<>();
//        }
//
//        // Other methods for adding rooms and reservations to the system
//
//        public List<Room> getAvailableRooms(LocalDateTime startTime, LocalDateTime endTime) {
//            List<Room> availableRooms = new ArrayList<>();
//
//            for (Room room : rooms) {
//                boolean isAvailable = true;
//
//                for (Reservation reservation : reservations) {
//                    if (reservation.overlaps(startTime, endTime, room)) {
//                        isAvailable = false;
//                        break;
//                    }
//                }
//
//                if (isAvailable) {
//                    availableRooms.add(room);
//                }
//            }
//
//            return availableRooms;
//        }

        // Other methods for managing the reservation system



}
