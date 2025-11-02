package com.example.labclients.lab_clients.infrastructure.persistence.adapter;

import com.example.labclients.lab_clients.domain.model.Client;
import com.example.labclients.lab_clients.domain.repository.ClientRepository;
import com.example.labclients.lab_clients.infrastructure.persistence.entity.ClientEntity;
import com.example.labclients.lab_clients.infrastructure.persistence.jpa.SpringDataClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientRepositoryAdapter implements ClientRepository {

    private final SpringDataClientRepository jpaRepository;
    public ClientRepositoryAdapter(SpringDataClientRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = ClientEntity.builder()
                .name(client.getName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();
        ClientEntity savedEntity = jpaRepository.save(clientEntity);
        return Client.builder()
                .id(savedEntity.getId())
                .name(savedEntity.getName())
                .email(savedEntity.getEmail())
                .phone(savedEntity.getPhone())
                .build();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return this.jpaRepository.findById(id).map(e -> Client.builder()
                .id(e.getId())
                .name(e.getName())
                .email(e.getEmail())
                .phone(e.getPhone())
                .build());
    }

    @Override
    public List<Client> findAll() {
        return this.jpaRepository.findAll().stream().map(e -> Client.builder()
                .id(e.getId())
                .name(e.getName())
                .email(e.getEmail())
                .phone(e.getPhone())
                .build()).toList();
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.jpaRepository.existsByEmail(email);
    }
}
