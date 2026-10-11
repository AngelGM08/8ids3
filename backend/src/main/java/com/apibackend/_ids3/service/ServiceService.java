package com.apibackend._ids3.service;

import com.apibackend._ids3.dto.request.ServiceRequestDTO;
import com.apibackend._ids3.dto.response.ServiceResponseDTO;
import com.apibackend._ids3.mapper.ServiceMapper;
import com.apibackend._ids3.model.Policy;
import com.apibackend._ids3.model.User;
import com.apibackend._ids3.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;
    private final UserService userService;
    private final PolicyService policyService;
    
    public ServiceService(ServiceRepository serviceRepository, ServiceMapper serviceMapper, UserService userService, PolicyService policyService) {
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
        this.userService = userService;
        this.policyService = policyService;
    }
    
    public List<ServiceResponseDTO> getAllServices() {
        return serviceRepository.findAll().stream().map(serviceMapper::toResponseDTO).toList();
    }
    
    public ServiceResponseDTO saveService(ServiceRequestDTO dto) {
        User client = userService.getClientById(dto.getClientId());
        User technician = userService.getTechnicianById(dto.getTechnicalId());
        Policy policy = policyService.getPolicyId(dto.getPolicyId());
    }
}
