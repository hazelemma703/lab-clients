package com.example.labclients.lab_clients.domain.repository;

import com.example.labclients.lab_clients.domain.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {
    Client save(Client client);
    Optional<Client> findById(UUID id);
    List<Client> findAll();

    boolean existsByEmail(String email);

    Optional<Client> detailsByIdAndEmail(String email);
}
