package com.example.labclients.lab_clients.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Date createdAt;
    private Date updatedAt;
    private Boolean available;
    private Integer quantity;
    private String category;
}
