package com.apibackend._ids3.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class InvoiceRequestDTO {
    @NotNull(message = "El cliente es obligatorio")
    private Long clientId;
    
    @NotNull(message = "La fecha es oblogatoria")
    private LocalDate date;
    
    @NotNull(message = "Ingrese el monto de la factura")
    private BigDecimal amount;
    
    @NotNull(message = "Las observaciones son obligatorias")
    private String observations;
    
}
