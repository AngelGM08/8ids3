package com.apibackend._ids3.service;

import com.apibackend._ids3.dto.request.PolicyRequestDTO;
import com.apibackend._ids3.dto.response.PolicyResponseDTO;
import com.apibackend._ids3.exception.PolicyNotFoundException;
import com.apibackend._ids3.mapper.PolicyMapper;
import com.apibackend._ids3.model.Policy;
import com.apibackend._ids3.model.User;
import com.apibackend._ids3.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {
    private final PolicyRepository policyRepository;
    private final UserService userService;
    private final PolicyMapper policyMapper;
    
    public PolicyService(PolicyRepository policyRepository, UserService userService, PolicyMapper policyMapper) {
        this.policyRepository = policyRepository;
        this.userService = userService;
        this.policyMapper = policyMapper;
    }
    
    public List<PolicyResponseDTO> getPolicies() {
        return policyRepository.findAll().stream().map(policyMapper::toResponseDTO).toList();
    }
    
    public PolicyResponseDTO getPolicyById(Long id) {
        Policy policy = policyRepository.findById(id).orElseThrow(()-> new PolicyNotFoundException(id));
        return policyMapper.toResponseDTO(policy);
    }
    
    public List<PolicyResponseDTO> getPoliciesByClient(Long clientId) {
        User client = userService.getClientById(clientId);
        return policyRepository.findAllByClientId(clientId).stream().map(policyMapper::toResponseDTO).toList();
    }
    
    public PolicyResponseDTO savePolicy(PolicyRequestDTO dto){
        User user = userService.getClientById(dto.getClientId());
        
        Policy policy = policyMapper.toEntity(dto,user);
        Policy savedPolicy = policyRepository.save(policy);
        
        return policyMapper.toResponseDTO(savedPolicy);
    }
    
    public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto){
        Policy policy = policyRepository.findById(id).orElseThrow(()-> new PolicyNotFoundException(id));
        User client = userService.getClientById(dto.getClientId());
        
        policy.setTotalHours(dto.getTotalHours());
        policy.setDateStart(dto.getDateStart());
        policy.setDateEnd(dto.getDateEnd());
        policy.setPrice(dto.getPrice());
        policy.setClient(client);
        policy.setObservations(dto.getObservations());
        
        Policy updatedPolicy = policyRepository.save(policy);
        return policyMapper.toResponseDTO(updatedPolicy);
    }
    
    public void deletePolicy(Long id) {
        Policy policy = policyRepository.findById(id).orElseThrow(() -> new PolicyNotFoundException(id));
        policyRepository.delete(policy);
    }
}
