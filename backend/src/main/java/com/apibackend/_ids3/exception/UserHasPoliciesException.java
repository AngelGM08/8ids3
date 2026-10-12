package com.apibackend._ids3.exception;

public class UserHasPoliciesException extends RuntimeException {
    public UserHasPoliciesException(Long id) {
        super("No se puede eliminar el usuario con id " + id + " porque tiene polizas asociadas");
    }
}
