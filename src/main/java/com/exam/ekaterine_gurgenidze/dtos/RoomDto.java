package com.exam.ekaterine_gurgenidze.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RoomDto {
    private String roomNumber;

    //   private Boolean isEmpty;

//    @ManyToOne
//    @JoinColumn(name = "HOTEL_ID")
//    private Hotel hotel;

    private Float price;

    private Long hotel_id;
}
