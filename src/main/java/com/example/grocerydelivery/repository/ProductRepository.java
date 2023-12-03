package com.example.grocerydelivery.repository;

import com.example.grocerydelivery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByName(String name);
}
