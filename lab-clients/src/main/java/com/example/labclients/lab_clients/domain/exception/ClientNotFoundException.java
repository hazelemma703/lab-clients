package com.example.labclients.lab_clients.domain.exception;


public class ClientNotFoundException extends Exception{
    public ClientNotFoundException(Long id, String message) {
        super("Client with id " + id + " not found." + message);
    }
}
