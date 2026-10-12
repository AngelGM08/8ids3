package com.apibackend._ids3.exception;

public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(Long id) {
        super("Servicio con id " + id + " no encontrado");
    }
}
