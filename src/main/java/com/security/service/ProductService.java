package com.security.service;

import java.util.List;

import com.security.model.Product;

public interface ProductService {

    List<Product> listAll();
    Product create(Product product);
    Product update(Product product);
    void delete(Long id);
} 
