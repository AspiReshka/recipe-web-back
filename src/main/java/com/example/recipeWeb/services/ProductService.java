package com.example.recipeWeb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipeWeb.models.Product;
import com.example.recipeWeb.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts()
    {
        return new ArrayList<>(repository.findAll());
    }
    public void addProduct(Product product)
    {

    }
}
