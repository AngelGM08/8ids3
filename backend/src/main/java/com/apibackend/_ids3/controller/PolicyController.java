package com.apibackend._ids3.controller;

import com.apibackend._ids3.dto.request.PolicyRequestDTO;
import com.apibackend._ids3.dto.response.PolicyResponseDTO;
import com.apibackend._ids3.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/policies")
public class PolicyController {
    private final PolicyService policyService;
    
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }
    
    @GetMapping
    public ResponseEntity<List<PolicyResponseDTO>> getAllUsers(){
        List<PolicyResponseDTO> policies = policyService.getPolicies();
        return ResponseEntity.ok().body(policies);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> getPolicyById(@PathVariable Long id){
        PolicyResponseDTO policy = policyService.getPolicyById(id);
        return ResponseEntity.ok(policy);
    }
    
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<PolicyResponseDTO>> getAllPoliciesByClient(@PathVariable Long clientId){
        List<PolicyResponseDTO> policy = policyService.getPoliciesByClient(clientId);
        return ResponseEntity.ok().body(policy);
    }
    
    @PostMapping
    public ResponseEntity<PolicyResponseDTO> createPolicy(@Valid @RequestBody PolicyRequestDTO dto){
        PolicyResponseDTO policy = policyService.savePolicy(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(policy);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> updatePolicy(@PathVariable Long id, @Valid @RequestBody PolicyRequestDTO dto){
        PolicyResponseDTO policy = policyService.updatePolicy(id, dto);
        return ResponseEntity.ok(policy);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id){
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}
