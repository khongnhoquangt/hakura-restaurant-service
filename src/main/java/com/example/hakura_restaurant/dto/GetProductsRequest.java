package com.example.hakura_restaurant.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class GetProductsRequest {
    @Nullable
    private String type;
}
