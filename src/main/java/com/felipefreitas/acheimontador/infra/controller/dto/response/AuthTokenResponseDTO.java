package com.felipefreitas.acheimontador.infra.controller.dto.response;

public record AuthTokenResponseDTO(
        String tokenType,
        String accessToken,
        long expiresInMillis
) {
}
