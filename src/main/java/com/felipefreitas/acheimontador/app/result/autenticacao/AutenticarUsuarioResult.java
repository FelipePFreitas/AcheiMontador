package com.felipefreitas.acheimontador.app.result.autenticacao;

public record AutenticarUsuarioResult(
        String tokenType,
        String accessToken,
        long expiresInMillis
) {
}
