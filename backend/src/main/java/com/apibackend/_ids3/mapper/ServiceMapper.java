package com.apibackend._ids3.mapper;

import com.apibackend._ids3.dto.request.ServiceRequestDTO;
import com.apibackend._ids3.dto.response.ServiceResponseDTO;
import com.apibackend._ids3.model.*;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {
    public ServiceModel toEntity(ServiceRequestDTO dto, User client, User technician, Policy policy, Invoice invoice) {
        ServiceModel service = new ServiceModel();
        
        service.setClient(client);
        service.setTechnician(technician);
        service.setDate(dto.getDate());
        service.setHours(dto.getHours());
        service.setObservations(dto.getObservations());
        service.setPolicy(policy);
        service.setInvoice(invoice);
        
        return service;
    }
    
    public ServiceResponseDTO toResponseDTO(ServiceModel service) {
        return new ServiceResponseDTO(
                service.getId(),
                service.getClient().getName(),
                service.getTechnician().getName(),
                service.getDate(),
                service.getHours(),
                service.getObservations(),
                service.getPolicy().getId(),
                service.getInvoice() != null ? service.getInvoice().getId() : null
        );
    }
}
