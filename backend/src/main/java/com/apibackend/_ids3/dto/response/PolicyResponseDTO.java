package com.apibackend._ids3.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PolicyResponseDTO {
    private Long id;
    private Integer totalHours;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private BigDecimal price;
    private String client;
    private String observations;
    
    public PolicyResponseDTO(Long id, Integer totalHours, LocalDate dateStart, LocalDate dateEnd, BigDecimal price, String client, String observations) {
        this.id = id;
        this.totalHours = totalHours;
        this.dateStart= dateStart;
        this.dateEnd = dateEnd;
        this.price = price;
        this.client = client;
        this.observations = observations;
    }
}
