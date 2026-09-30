package com.felipefreitas.rhexpress.app.dto.autenticacao;

public record AuthTokenResponseDTO(
        String tokenType,
        String accessToken,
        long expiresInMillis
) {
}
