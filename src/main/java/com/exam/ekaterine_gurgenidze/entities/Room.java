package com.exam.ekaterine_gurgenidze.entities;


import com.exam.ekaterine_gurgenidze.dtos.RoomDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROOM")
public class Room extends AppEntity<Long> {

    @Id
    @Column(name = "Id")
    @SequenceGenerator(name = "roomIdSeq", sequenceName = "ROOM_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomIdSeq")
    private Long Id;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

//    @Column(name = "IS_EMPTY")
//    private Boolean isEmpty;

    /*
    currentDate-ით და ჯავშნებით უნდა დადგინედს რომელია თავისუფალი და რომელი დაკავებული (ჯაშნების ცხრილით უნდა
    ვიხმელმძღვანელო და უნდა დაჯამდეს)

    * */

    @Column(name="PRICE")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;


    public Room(RoomDto roomDto) {
        this.roomNumber = roomDto.getRoomNumber();
     //   System.out.println("Room isEmpty "+ roomDto.getIsEmpty());
        this.price = roomDto.getPrice();
    //    this.hotel = roomDto.getHotel_id();
        this.hotel = new Hotel();
        this.hotel.setId(roomDto.getHotel_id());
        this.recordState = RecordState.ACTIVE;
    }
}
