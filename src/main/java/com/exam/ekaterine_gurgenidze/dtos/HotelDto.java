package com.exam.ekaterine_gurgenidze.dtos;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HotelDto {

    private String name;

    private String address;
}
