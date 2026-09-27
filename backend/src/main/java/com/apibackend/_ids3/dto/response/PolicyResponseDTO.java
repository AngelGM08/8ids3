package com.apibackend._ids3.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public PolicyResponseDTO(Long id, Integer totalHours, LocalDate dateStart, LocalDate dateEnd, BigDecimal price, String client, String observations, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.totalHours = totalHours;
        this.dateStart= dateStart;
        this.dateEnd = dateEnd;
        this.price = price;
        this.client = client;
        this.observations = observations;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
