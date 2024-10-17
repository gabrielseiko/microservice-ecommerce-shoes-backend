package com.user_service.security.dto;


import lombok.Data;

@Data
public class LoginRequestDto {
    //DTO para encapsular los datos de la solicitud de autenticacion (login)

    private String email;
    private String password;
}
