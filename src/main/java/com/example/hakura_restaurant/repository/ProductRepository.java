package com.example.hakura_restaurant.repository;

import com.example.hakura_restaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products WHERE :type IS NULL OR type = :type", nativeQuery = true)
    List<Product> findByType(@Param("type") String type);
}
