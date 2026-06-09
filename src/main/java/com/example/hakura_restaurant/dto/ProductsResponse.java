package com.example.hakura_restaurant.dto;

import com.example.hakura_restaurant.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductsResponse {
    private List<Product> items;
}
