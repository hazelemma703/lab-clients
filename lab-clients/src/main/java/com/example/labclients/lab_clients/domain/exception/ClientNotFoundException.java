package com.example.labclients.lab_clients.domain.exception;

import java.util.UUID;

public class ClientNotFoundException extends Exception{
    public ClientNotFoundException(UUID uuid, String message) {
        super("Client with id " + uuid + " not found." + message);
    }
}
