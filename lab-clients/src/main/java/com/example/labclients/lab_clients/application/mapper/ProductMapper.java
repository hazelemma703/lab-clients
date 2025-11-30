package com.example.labclients.lab_clients.application.mapper;

import com.example.labclients.lab_clients.application.dto.ProductDTO;
import com.example.labclients.lab_clients.domain.model.Product;

public class ProductMapper {
    public static ProductDTO toDto(Product product){
        return ProductDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .available(product.getAvailable())
                .category(product.getCategory())
                .build();
    }

    public static Product toModel(ProductDTO productDTO){
        return Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .available(productDTO.getAvailable())
                .category(productDTO.getCategory())
                .build();
    }
}
