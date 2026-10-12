package com.apibackend._ids3.exception;

public class PolicyNotFoundException extends RuntimeException {
    public PolicyNotFoundException(Long id) {
        super("Poliza con id " + id + " no encontrada");
    }
}
