package com.apibackend._ids3.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleRequestDTO {
    @NotBlank(message = "El nombre del rol es obligatorio")
    private String name;
}
