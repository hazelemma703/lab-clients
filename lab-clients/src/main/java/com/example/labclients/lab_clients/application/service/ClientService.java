package com.example.labclients.lab_clients.application.service;

import com.example.labclients.lab_clients.application.dto.ClientDTO;
import com.example.labclients.lab_clients.application.mapper.ClientMapper;
import com.example.labclients.lab_clients.domain.model.Client;
import com.example.labclients.lab_clients.domain.repository.ClientRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO save(ClientDTO client){
        if (this.clientRepository.existsByEmail(client.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        Client clientModel = ClientMapper.toModel(client);
        return ClientMapper.toDto(this.clientRepository.save(clientModel));
    }


    public List<ClientDTO> findAll(){
        return this.clientRepository
                .findAll()
                .stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(UUID id){
        return this.clientRepository.findById(id)
                .map(ClientMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client getClientDetailsById(String email){
        return this.clientRepository.detailsByIdAndEmail(email)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

}
