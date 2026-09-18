package com.apibackend._ids3.mapper;

import com.apibackend._ids3.dto.request.UserRequestDTO;
import com.apibackend._ids3.dto.response.UserResponseDTO;
import com.apibackend._ids3.model.Role;
import com.apibackend._ids3.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequestDTO dto, Role role) {
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRfc(dto.getRfc());
        user.setContact(dto.getContact());
        user.setPhoneContact(dto.getPhoneContact());
        user.setAddress(dto.getAddress());
        user.setRole(role);

        return user;
    }

    public UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRfc(),
                user.getContact(),
                user.getPhoneContact(),
                user.getAddress(),
                user.getRole().getName(),
                user.getActive()
        );
    }
}
