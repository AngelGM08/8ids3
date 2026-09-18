package com.apibackend._ids3.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    @Size(min = 13, message = "El RFC debe ser de 13 caracteres")
    private String rfc;

    private String contact;

    @Size(min = 10, message = "El teléfono debe ser de 10 caracteres")
    private String phoneContact;

    private String address;

    @NotNull(message = "El rol es obligatorio")
    private Long roleId;
}
