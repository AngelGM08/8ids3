package com.apibackend._ids3.mapper;

import com.apibackend._ids3.dto.request.PolicyRequestDTO;
import com.apibackend._ids3.dto.response.PolicyResponseDTO;
import com.apibackend._ids3.model.Policy;
import com.apibackend._ids3.model.User;
import org.springframework.stereotype.Component;

@Component
public class PolicyMapper {
    public Policy toEntity(PolicyRequestDTO dto, User user) {
        Policy policy = new Policy();
        
        policy.setTotalHours(dto.getTotalHours());
        policy.setDateStart(dto.getDateStart());
        policy.setDateEnd(dto.getDateEnd());
        policy.setPrice(dto.getPrice());
        policy.setClient(user);
        policy.setObservations(dto.getObservations());
        return policy;
    }
    
    public PolicyResponseDTO toResponseDTO(Policy policy) {
        return new PolicyResponseDTO(
                policy.getId(),
                policy.getTotalHours(),
                policy.getDateStart(),
                policy.getDateEnd(),
                policy.getPrice(),
                policy.getClient().getName(),
                policy.getObservations(),
                policy.getCreatedAt(),
                policy.getUpdatedAt()
        );
    }
}
