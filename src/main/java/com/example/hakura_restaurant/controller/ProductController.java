package com.example.hakura_restaurant.controller;

import com.example.hakura_restaurant.dto.BaseResponse;
import com.example.hakura_restaurant.dto.GetProductsRequest;
import com.example.hakura_restaurant.dto.ProductsResponse;
import com.example.hakura_restaurant.service.ProductService;
import com.example.hakura_restaurant.utils.ResponseBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public BaseResponse<ProductsResponse> getProductList(GetProductsRequest request) {
        return ResponseBuilder.success(productService.getProductList(request));
    }
}
