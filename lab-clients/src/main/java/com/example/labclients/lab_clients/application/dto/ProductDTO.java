package com.example.labclients.lab_clients.application.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String name;
    private String description;
    private Double price;
    private  Boolean available;
    private Integer quantity;
    private String category;
}
