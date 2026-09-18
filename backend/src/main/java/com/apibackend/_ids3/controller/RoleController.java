package com.apibackend._ids3.controller;

import com.apibackend._ids3.dto.request.RoleRequestDTO;
import com.apibackend._ids3.dto.response.RoleResponseDTO;
import com.apibackend._ids3.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService roleService;
    
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    
    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {
        List<RoleResponseDTO> role = roleService.getRoles();
        return ResponseEntity.ok(role);
    }
    
    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(@Valid @RequestBody RoleRequestDTO dto) {
        RoleResponseDTO role = roleService.saveRoles(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }
}
