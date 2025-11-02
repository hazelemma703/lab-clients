package com.example.labclients.lab_clients.application.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
    String name;
    String email;
    String phone;
}
