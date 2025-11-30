package com.example.labclients.lab_clients.application.service;

import com.example.labclients.lab_clients.application.dto.ProductDTO;
import com.example.labclients.lab_clients.application.mapper.ProductMapper;
import com.example.labclients.lab_clients.domain.model.Product;
import com.example.labclients.lab_clients.domain.repository.ProductRepository;

import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO save(ProductDTO productDTO) {
        if (productDTO.getQuantity() == null || productDTO.getQuantity() == 0) {
            productDTO.setAvailable(false);
        } else {
            productDTO.setAvailable(true);
        }
        Product product = ProductMapper.toModel(productDTO);
        return ProductMapper.toDto(productRepository.save(product));
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    public void deleteById(Long id) {
        productRepository.findById(id).ifPresentOrElse(
                product -> {
                    // productRepository.delete(product);
                    System.out.println("Deleted product: " + product.getName());
                },
                () -> { throw new RuntimeException("Product not found with id: " + id); }
        );
    }

    public boolean isAvailable(Long id) {
        return productRepository.isAvailable(id);
    }

    public Integer getStock(Long id) {
        return productRepository.getStock(id);
    }

}
