package com.example.labclients.lab_clients.domain.repository;

import com.example.labclients.lab_clients.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    boolean isAvailable(Long id);
    Integer getStock(Long id);
}
