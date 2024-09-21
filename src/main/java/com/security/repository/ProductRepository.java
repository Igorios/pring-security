package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
