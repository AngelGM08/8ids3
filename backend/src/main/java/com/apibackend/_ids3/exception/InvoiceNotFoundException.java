package com.apibackend._ids3.exception;

public class InvoiceNotFoundException extends RuntimeException {
    public InvoiceNotFoundException(Long id) {
        super("Factura con id " + id + " no encontrada");
    }
}
