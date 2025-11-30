package com.example.labclients.lab_clients.domain.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Long id, String message) {
        super("Product with id " + id + " not found." + message);
    }
}
