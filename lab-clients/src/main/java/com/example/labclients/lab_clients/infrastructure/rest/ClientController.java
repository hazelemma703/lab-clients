package com.example.labclients.lab_clients.infrastructure.rest;

import com.example.labclients.lab_clients.application.dto.ClientDTO;
import com.example.labclients.lab_clients.application.service.ClientService;
import com.example.labclients.lab_clients.domain.model.Client;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:5173")
public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDTO> findAll() {
        return clientService.findAll();
    }

    @PostMapping
    public ClientDTO save(@RequestBody ClientDTO client) {
        return clientService.save(client);
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable("id") String id) {
        return clientService.getClientById(Long.valueOf(id));
    }
}
