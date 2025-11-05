package com.example.labclients.lab_clients.domain.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    private Long id;

    private String name;
    private String email;
    private String phone;
}
