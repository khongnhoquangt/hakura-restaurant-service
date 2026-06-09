package com.example.hakura_restaurant.utils;


import com.example.hakura_restaurant.constants.ResponseCode;
import com.example.hakura_restaurant.dto.BaseResponse;

public class ResponseBuilder {

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(
                true,
                ResponseCode.SUCCESS,
                "Request successful",
                data
        );
    }

    public static <T> BaseResponse<T> error(String code, String message) {
        return new BaseResponse<>(
                false,
                code,
                message,
                null
        );
    }

    public static <T> BaseResponse<T> error(String code, T data) {
        return new BaseResponse<>(
                false,
                code,
                "Request failed",
                data
        );
    }
}
