package com.example.labclients.lab_clients.infrastructure.config;


import com.example.labclients.lab_clients.application.service.ClientService;
import com.example.labclients.lab_clients.domain.repository.ClientRepository;
import com.example.labclients.lab_clients.infrastructure.persistence.jpa.SpringDataClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ClientService clientService(ClientRepository clientRepository){
        return new ClientService(clientRepository);
    }
}
