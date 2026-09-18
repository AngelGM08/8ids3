package com.apibackend._ids3.dto.response;

import lombok.Getter;

@Getter
public class RoleResponseDTO {
    private Long id;
    private String name;

    public RoleResponseDTO(){}

    public RoleResponseDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }

}
