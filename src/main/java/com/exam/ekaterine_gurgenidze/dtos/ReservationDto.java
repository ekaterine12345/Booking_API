package com.exam.ekaterine_gurgenidze.dtos;

import com.exam.ekaterine_gurgenidze.entities.Hotel;
import com.exam.ekaterine_gurgenidze.entities.Room;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
//    private Room room;
//    private Hotel hotel;

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String guestName;

    private Long roomId;
    private Long hotelId;

}
