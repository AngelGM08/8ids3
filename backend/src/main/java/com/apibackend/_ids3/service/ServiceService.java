package com.apibackend._ids3.service;

import com.apibackend._ids3.dto.request.ServiceRequestDTO;
import com.apibackend._ids3.dto.response.ServiceResponseDTO;
import com.apibackend._ids3.exception.ServiceNotFoundException;
import com.apibackend._ids3.mapper.ServiceMapper;
import com.apibackend._ids3.model.Invoice;
import com.apibackend._ids3.model.Policy;
import com.apibackend._ids3.model.User;
import com.apibackend._ids3.repository.ServiceRepository;
import org.springframework.stereotype.Service;
import com.apibackend._ids3.model.ServiceModel;

import java.util.List;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;
    private final UserService userService;
    private final PolicyService policyService;
    private final InvoiceService invoiceService;
    
    public ServiceService(ServiceRepository serviceRepository, ServiceMapper serviceMapper, UserService userService, PolicyService policyService, InvoiceService invoiceService) {
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
        this.userService = userService;
        this.policyService = policyService;
        this.invoiceService = invoiceService;
    }
    
    public List<ServiceResponseDTO> getAllServices() {
        return serviceRepository.findAll().stream().map(serviceMapper::toResponseDTO).toList();
    }
    
    public ServiceResponseDTO getServiceById(Long id) {
        ServiceModel service = serviceRepository.findById(id).orElseThrow(() -> new ServiceNotFoundException(id));
        return serviceMapper.toResponseDTO(service);
    }
    
    public ServiceResponseDTO saveService(ServiceRequestDTO dto) {
        User client = userService.getClientById(dto.getClientId());
        User technician = userService.getTechnicianById(dto.getTechnicalId());
        Policy policy = policyService.getPolicyId(dto.getPolicyId());
        Invoice invoice = null;
        
        if(dto.getInvoiceId() != null) {
            invoice = invoiceService.getInvoiceId(dto.getInvoiceId());
        }
        
        // Validar que la póliza pertenezca al cliente
        if (!policy.getClient().getId().equals(client.getId())) {
            throw new IllegalArgumentException(
                    "La póliza no pertenece al cliente indicado"
            );
        }
        
        // Validar que la factura pertenezca al cliente
        if (invoice != null &&
                !invoice.getClient().getId().equals(client.getId())) {
            throw new IllegalArgumentException(
                    "La factura no pertenece al cliente indicado"
            );
        }
        
        
        ServiceModel service = serviceMapper.toEntity(dto, client, technician, policy, invoice);
        
        ServiceModel savedService = serviceRepository.save(service);
        return serviceMapper.toResponseDTO(savedService);
    }
    
    public ServiceResponseDTO updateService(Long id, ServiceRequestDTO dto) {
        ServiceModel service = serviceRepository.findById(id).orElseThrow(() -> new ServiceNotFoundException(id));
        User client = userService.getClientById(dto.getClientId());
        User technician = userService.getTechnicianById(dto.getTechnicalId());
        Policy policy = policyService.getPolicyId(dto.getPolicyId());
        Invoice invoice = null;
        
        if (dto.getInvoiceId() != null) {
            invoice = invoiceService.getInvoiceId(dto.getInvoiceId());
        }
        
        // Validar que la póliza pertenezca al cliente
        if (!policy.getClient().getId().equals(client.getId())) {
            throw new IllegalArgumentException( "La póliza no pertenece al cliente indicado" );
        }
        
        // Validar que la factura pertenezca al cliente
        if (invoice != null && !invoice.getClient().getId().equals(client.getId())) {
            throw new IllegalArgumentException( "La factura no pertenece al cliente indicado" );
        }
        
        service.setClient(client);
        service.setTechnician(technician);
        service.setPolicy(policy);
        service.setInvoice(invoice);
        service.setDate(dto.getDate());
        service.setHours(dto.getHours());
        
        return serviceMapper.toResponseDTO(serviceRepository.save(service));
    }
    
    public void deleteService(Long id) {
        ServiceModel service = serviceRepository.findById(id).orElseThrow(() -> new ServiceNotFoundException(id));
        serviceRepository.delete(service);
    }
}
