package com.example.hakura_restaurant.service;

import com.example.hakura_restaurant.dto.CreateProductRequest;
import com.example.hakura_restaurant.dto.GetProductsRequest;
import com.example.hakura_restaurant.dto.ProductsResponse;
import com.example.hakura_restaurant.dto.UpdateProductRequest;
import com.example.hakura_restaurant.entity.Product;
import com.example.hakura_restaurant.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Product createProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setDiscountPrice(request.getDiscountPrice());
        product.setImageUrl(request.getImageUrl());
        product.setMaterial(request.getMaterial());
        product.setType(request.getType());
        product.setFeatured(request.isFeatured());
        
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }
        if (request.getPrice() != null) {
            product.setPrice(request.getPrice());
        }
        if (request.getDiscountPrice() != null) {
            product.setDiscountPrice(request.getDiscountPrice());
        }
        if (request.getImageUrl() != null) {
            product.setImageUrl(request.getImageUrl());
        }
        if (request.getMaterial() != null) {
            product.setMaterial(request.getMaterial());
        }
        if (request.getType() != null) {
            product.setType(request.getType());
        }
        if (request.getFeatured() != null) {
            product.setFeatured(request.getFeatured());
        }

        return productRepository.save(product);
    }

    public String deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
        return "Product deleted successfully: " + id;
    }
}

