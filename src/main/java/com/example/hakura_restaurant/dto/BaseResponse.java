package com.example.hakura_restaurant.dto;


import com.example.hakura_restaurant.constants.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private boolean success = true;
    private String code = ResponseCode.SUCCESS;
    private String message;
    private T data;
    private long timestamp = System.currentTimeMillis();

    public BaseResponse(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
