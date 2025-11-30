package com.example.labclients.lab_clients.infrastructure.persistence.adapter;

import com.example.labclients.lab_clients.domain.model.Product;
import com.example.labclients.lab_clients.domain.repository.ProductRepository;
import com.example.labclients.lab_clients.infrastructure.persistence.entity.ProductEntity;
import com.example.labclients.lab_clients.infrastructure.persistence.jpa.SpringDataProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {
    private final SpringDataProductRepository jpaRepository;
    public ProductRepositoryAdapter(SpringDataProductRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    @Override
    public Product save(Product product) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .available(product.getAvailable())
                .quantity(product.getQuantity())
                .category(product.getCategory())
                .build();
        ProductEntity savedEntity = jpaRepository.save(productEntity);
        return Product.builder()
                .name(savedEntity.getName())
                .description(savedEntity.getDescription())
                .price(savedEntity.getPrice())
                .available(savedEntity.getAvailable())
                .quantity(savedEntity.getQuantity())
                .category(savedEntity.getCategory())
                .build();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.jpaRepository.findById(id).map(
                entity -> Product.builder()
                        .name(entity.getName())
                        .description(entity.getDescription())
                        .price(entity.getPrice())
                        .available(entity.getAvailable())
                        .quantity(entity.getQuantity())
                        .category(entity.getCategory())
                        .build()
        );
    }

    @Override
    public List<Product> findAll() {
        return this.jpaRepository.findAll().stream().map(
                entity -> Product.builder()
                        .name(entity.getName())
                        .description(entity.getDescription())
                        .price(entity.getPrice())
                        .available(entity.getAvailable())
                        .quantity(entity.getQuantity())
                        .category(entity.getCategory())
                        .build()
        ).toList();
    }

    @Override
    public boolean isAvailable(Long id) {
        return this.jpaRepository.isAvailable(id);
    }

    @Override
    public Integer getStock(Long id) {
        return this.jpaRepository.getStock(id);
    }
}
