package com.example.hakura_restaurant.service;

import com.example.hakura_restaurant.dto.GetProductsRequest;
import com.example.hakura_restaurant.dto.ProductsResponse;
import com.example.hakura_restaurant.entity.Product;
import com.example.hakura_restaurant.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductsResponse getProductList(GetProductsRequest request) {
        List<Product> productList = productRepository.findByType(request.getType());
        System.out.println("Number of products : " + productList.size());
        return ProductsResponse.builder().items(productList).build();
    }
}
