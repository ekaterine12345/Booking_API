package com.exam.ekaterine_gurgenidze.entities;


import com.exam.ekaterine_gurgenidze.dtos.HotelDto;
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
@Table(name = "HOTEL")
public class Hotel extends AppEntity<Long>{
    @Id
    @Column(name = "Id")
    @SequenceGenerator(name="hotelIdSeq", sequenceName = "HOTEL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotelIdSeq")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    public Hotel(HotelDto hotelDto) {
        this.name = hotelDto.getName();
        this.address = hotelDto.getAddress();
        this.recordState=RecordState.ACTIVE;
    }
}
