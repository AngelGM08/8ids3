package com.apibackend._ids3.service;

import com.apibackend._ids3.dto.request.RoleRequestDTO;
import com.apibackend._ids3.dto.response.RoleResponseDTO;
import com.apibackend._ids3.exception.RoleNotFoundException;
import com.apibackend._ids3.model.Role;
import com.apibackend._ids3.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleResponseDTO saveRoles(RoleRequestDTO dto) {
        Role role = new Role();
        role.setName(dto.getName());
        Role roleSave = roleRepository.save(role);

        return new RoleResponseDTO(roleSave.getId(), roleSave.getName());
    }

    public List<RoleResponseDTO> getRoles() {
        return roleRepository.findAll().stream().map(role -> new RoleResponseDTO(role.getId(), role.getName())).toList();
    }

    public Role getById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(id));
    }
}
