package com.example.labclients.lab_clients.infrastructure.persistence.jpa;

import com.example.labclients.lab_clients.infrastructure.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataClientRepository extends JpaRepository<ClientEntity, UUID> {
    Boolean existsByEmail(String email);

    Optional<ClientEntity> detailsByIdAndEmail(String email);
}
