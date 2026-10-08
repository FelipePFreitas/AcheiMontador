package com.felipefreitas.acheimontador.app.dto.autenticacao;

public record AuthTokenResponseDTO(
        String tokenType,
        String accessToken,
        long expiresInMillis
) {
}
