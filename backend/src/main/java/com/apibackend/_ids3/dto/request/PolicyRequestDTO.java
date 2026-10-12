package com.apibackend._ids3.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PolicyRequestDTO {
    @NotNull(message = "El total de horas es obligatorio")
    @Min(value = 1, message = "El total de horas debe ser mayor a 0")
    private Integer totalHours;
    
    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate dateStart;
    
    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDate dateEnd;
    
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    private BigDecimal price;
    
    @NotNull(message = "El cliente es obligatorio")
    private Long clientId;
    
    @NotNull(message = "Las observaciones son obligatorias")
    private String observations;
    
    
}
