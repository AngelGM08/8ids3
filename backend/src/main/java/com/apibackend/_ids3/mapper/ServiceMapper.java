package com.apibackend._ids3.mapper;

import com.apibackend._ids3.dto.request.ServiceRequestDTO;
import com.apibackend._ids3.dto.response.ServiceResponseDTO;
import com.apibackend._ids3.model.Invoice;
import com.apibackend._ids3.model.Policy;
import com.apibackend._ids3.model.Service;
import com.apibackend._ids3.model.User;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {
    public Service toEntity(ServiceRequestDTO dto, User user, Policy policy, Invoice invoice) {
        Service service = new Service();
        
        service.setClient(user);
        service.setTechnician(user);
        service.setDate(dto.getDate());
        service.setHours(dto.getHours());
        service.setObservations(dto.getObservations());
        service.setPolicy(policy);
        service.setInvoice(invoice);
        
        return service;
    }
    
    public ServiceResponseDTO toResponseDTO(Service service) {
        return new ServiceResponseDTO(
                service.getId(),
                service.getClient().getName(),
                service.getTechnician().getName(),
                service.getDate(),
                service.getHours(),
                service.getObservations(),
                service.getPolicy().getId(),
                service.getInvoice().getId()
        );
    }
}
