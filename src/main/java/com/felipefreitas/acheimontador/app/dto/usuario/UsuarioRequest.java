package com.felipefreitas.acheimontador.app.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(

        @NotBlank(message = "E-mail não pode estar em branco")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "Senha não pode estar em branco")
        String senha) {
}