package com.apibackend._ids3.controller;

import com.apibackend._ids3.dto.request.ServiceRequestDTO;
import com.apibackend._ids3.dto.response.ServiceResponseDTO;
import com.apibackend._ids3.service.ServiceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/services")
public class ServiceController {
    private final ServiceService serviceService;
    
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
    
    @GetMapping
    public ResponseEntity<List<ServiceResponseDTO>> getServices(){
        List<ServiceResponseDTO> services = serviceService.getAllServices();
        return ResponseEntity.ok().body(services);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> getServiceById(@PathVariable Long id){
        ServiceResponseDTO service = serviceService.getServiceById(id);
        return ResponseEntity.ok(service);
    }
    
    @PostMapping
    public ResponseEntity<ServiceResponseDTO> createService(@Valid @RequestBody ServiceRequestDTO dto){
        ServiceResponseDTO service = serviceService.saveService(dto);
        return ResponseEntity.ok(service);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> updateService(@PathVariable Long id, @Valid @RequestBody ServiceRequestDTO dto){
        ServiceResponseDTO service = serviceService.updateService(id, dto);
        return ResponseEntity.ok(service);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> deleteService(@PathVariable Long id){
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
