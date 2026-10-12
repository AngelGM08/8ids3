package com.apibackend._ids3.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ServiceResponseDTO {
    private Long id;
    private String client;
    private String technician;
    private LocalDate date;
    private BigDecimal hours;
    private String observations;
    private Long policyId;
    private Long invoiceId;
    
    public ServiceResponseDTO(Long id, String client, String technician, LocalDate date, BigDecimal hours, String observations, Long policyId, Long invoiceId) {
        this.id = id;
        this.client = client;
        this.technician = technician;
        this.date = date;
        this.hours = hours;
        this.observations = observations;
        this.policyId = policyId;
        this.invoiceId = invoiceId;
    }
}
