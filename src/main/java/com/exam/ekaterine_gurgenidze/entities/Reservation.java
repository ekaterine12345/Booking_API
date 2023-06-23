package com.exam.ekaterine_gurgenidze.entities;

import com.exam.ekaterine_gurgenidze.dtos.ReservationDto;
import com.exam.ekaterine_gurgenidze.dtos.RoomDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESERVATION")
public class Reservation extends AppEntity<Long>{

    @Column(name = "Id")
    @Id
    @SequenceGenerator(name = "reservationIdSeq", sequenceName = "RESERVATION_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationIdSeq")
    private Long Id;


    @Column(name = "CHECK_IN_TIME")
    private LocalDateTime checkInTime;

    @Column(name = "CHECK_OUT_TIME")
    private LocalDateTime checkOutTime;

//    @Column(name = "duration") // days
//    private int duration;

    @Column(name = "GUEST_NAME")
    private String guestName;
    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    public Reservation(ReservationDto reservationDto) {
        this.checkInTime = reservationDto.getCheckInTime();
        this.checkOutTime = reservationDto.getCheckOutTime();
        this.guestName = reservationDto.getGuestName();
        this.room = new Room();
        this.room.setId(reservationDto.getRoomId());
        this.hotel = new Hotel();
        this.hotel.setId(reservationDto.getHotelId());
        this.recordState = RecordState.ACTIVE;
    }
}
