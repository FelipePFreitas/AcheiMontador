package com.felipefreitas.acheimontador.app.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(

        @NotBlank(message = "Nome não pode estar em branco")
        String nome,

        @NotBlank(message = "Senha não pode estar em branco")
        String senha) {
}