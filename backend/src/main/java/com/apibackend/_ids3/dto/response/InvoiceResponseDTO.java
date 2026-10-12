package com.apibackend._ids3.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class InvoiceResponseDTO {
    private Long id;
    private String client;
    private LocalDate date;
    private BigDecimal amount;
    private String observations;
    
    public InvoiceResponseDTO(Long id, String client, LocalDate date, BigDecimal amount, String observations) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.amount = amount;
        this.observations = observations;
    }
}
