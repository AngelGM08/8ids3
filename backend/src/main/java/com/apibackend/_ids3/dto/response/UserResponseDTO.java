package com.apibackend._ids3.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String rfc;
    private String contact;
    private String phoneContact;
    private String address;
    private String role;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserResponseDTO(){}

    public UserResponseDTO(Long id, String name, String email, String rfc, String contact, String phoneContact, String address, String role, Boolean active,  LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rfc = rfc;
        this.contact = contact;
        this.phoneContact = phoneContact;
        this.address = address;
        this.role = role;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
