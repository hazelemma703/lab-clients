package com.example.labclients.lab_clients.application.mapper;

import com.example.labclients.lab_clients.application.dto.ClientDTO;
import com.example.labclients.lab_clients.domain.model.Client;

public class ClientMapper {
    public static ClientDTO toDto(Client client){
        return ClientDTO.builder()
                .name(client.getName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();
    }


    public static Client toModel(ClientDTO clientDTO){
        return Client.builder()
                .name(clientDTO.getName())
                .email(clientDTO.getEmail())
                .phone(clientDTO.getPhone())
                .build();
    }
}
