package com.example.recipeWeb.repositories;

import com.example.recipeWeb.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
