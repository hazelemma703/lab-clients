package com.example.labclients.lab_clients.infrastructure.persistence.jpa;

import com.example.labclients.lab_clients.infrastructure.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataClientRepository extends JpaRepository<ClientEntity, Long> {
    Boolean existsByEmail(String email);
}
