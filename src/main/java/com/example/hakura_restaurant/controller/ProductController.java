package com.example.hakura_restaurant.controller;

import com.example.hakura_restaurant.dto.BaseResponse;
import com.example.hakura_restaurant.dto.CreateProductRequest;
import com.example.hakura_restaurant.dto.GetProductsRequest;
import com.example.hakura_restaurant.dto.ProductsResponse;
import com.example.hakura_restaurant.dto.UpdateProductRequest;
import com.example.hakura_restaurant.entity.Product;
import com.example.hakura_restaurant.service.ProductService;
import com.example.hakura_restaurant.utils.ResponseBuilder;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping
    public BaseResponse<Product> createProduct(@RequestBody CreateProductRequest request) {
        return ResponseBuilder.success(productService.createProduct(request));
    }

    @PutMapping("/{id}")
    public BaseResponse<Product> updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest request) {
        return ResponseBuilder.success(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public BaseResponse<String> deleteProduct(@PathVariable Long id) {
        return ResponseBuilder.success(productService.deleteProduct(id));
    }
}
