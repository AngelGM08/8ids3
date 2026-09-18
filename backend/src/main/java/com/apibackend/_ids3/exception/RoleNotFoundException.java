package com.apibackend._ids3.exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(Long id) {
        super("Role con id " + id + " no encontrado");
    }
}
