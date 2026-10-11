package com.apibackend._ids3.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ServiceRequestDTO {
    @NotNull(message = "El cliente es obligatorio")
    private Long clientId;
    
    @NotNull(message = "El técnico es obligatorio")
    private Long technicalId;
    
    @NotNull(message = "La fecha es obligatoria")
    private LocalDate date;
    
    @NotNull(message = "Las horas son obligatorias")
    @DecimalMin(value = "0.01", message = "Las debe ser mayores a 0")
    private BigDecimal hours;
    
    @NotNull(message = "Las observaciones son obligatorias")
    private String observations;
    
    @NotNull(message = "La póliza es obligatoria")
    private Long policyId;
    
    private Long invoiceId;
}
