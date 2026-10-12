package com.apibackend._ids3.mapper;

import com.apibackend._ids3.dto.request.InvoiceRequestDTO;
import com.apibackend._ids3.dto.response.InvoiceResponseDTO;
import com.apibackend._ids3.model.Invoice;
import com.apibackend._ids3.model.User;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {
    public Invoice toEntity(InvoiceRequestDTO dto, User client) {
        Invoice invoice = new Invoice();
        
        invoice.setClient(client);
        invoice.setDate(dto.getDate());
        invoice.setAmount(dto.getAmount());
        invoice.setObservations(dto.getObservations());
        
        return invoice;
    }
    
    public InvoiceResponseDTO toResponseDTO(Invoice invoice) {
        return new InvoiceResponseDTO(
                invoice.getId(),
                invoice.getClient().getName(),
                invoice.getDate(),
                invoice.getAmount(),
                invoice.getObservations()
        );
    }
}
