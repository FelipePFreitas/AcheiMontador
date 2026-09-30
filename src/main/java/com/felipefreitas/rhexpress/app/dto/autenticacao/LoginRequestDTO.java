package com.felipefreitas.rhexpress.app.dto.autenticacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO(
        @NotBlank(message = "Login é obrigatório")
        String login,

        @NotBlank(message = "Senha é obrigatória")
        String senha
) {
}
