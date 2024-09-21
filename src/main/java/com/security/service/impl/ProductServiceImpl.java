package com.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.model.Product;
import com.security.repository.ProductRepository;
import com.security.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        if (product.getId() != null) {
            throw new RuntimeException("ID is null");
        }
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        if (product.getId() != null) {
            throw new RuntimeException("ID is null");
        }

        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.findById(id);
    }
    
}
