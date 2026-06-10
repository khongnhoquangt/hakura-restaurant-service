package com.example.hakura_restaurant.exception;

import com.example.hakura_restaurant.dto.BaseResponse;
import com.example.hakura_restaurant.utils.ResponseBuilder;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseBuilder.error("NOT_FOUND", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<String> handleGeneralException(Exception ex) {
        return ResponseBuilder.error("INTERNAL_ERROR", "An error occurred: " + ex.getMessage());
    }
}
