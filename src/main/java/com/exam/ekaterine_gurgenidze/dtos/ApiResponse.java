package com.exam.ekaterine_gurgenidze.dtos;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponse {
    private Map<String, Object> data = new HashMap<>();
    private Map<String, Object> errors = new HashMap<>();

    public ApiResponse(String key, Object value) {
        this.data.put(key, value);
    }

    public ApiResponse addData(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ApiResponse addError(String key, Object value){
        this.errors.put(key, value);
        return this;
    }

}
