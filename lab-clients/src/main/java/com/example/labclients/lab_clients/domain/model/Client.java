package com.example.labclients.lab_clients.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    private UUID id;

    private String name;
    private String email;
    private String phone;
}
