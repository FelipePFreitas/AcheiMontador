package com.felipefreitas.acheimontador.infra.security;

import com.auth0.jwt.JWT; // CORREÇÃO: Import correto da biblioteca Auth0
import com.auth0.jwt.algorithms.Algorithm; // CORREÇÃO
import com.auth0.jwt.exceptions.JWTVerificationException; // CORREÇÃO
import com.auth0.jwt.interfaces.DecodedJWT; // CORREÇÃO
import com.auth0.jwt.interfaces.JWTVerifier; // CORREÇÃO
import org.springframework.beans.factory.annotation.Value; // Adicionado para ler o application.properties
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    private static final String ISSUER = "acheimontador-api";

    private final Algorithm algorithm;
    private final JWTVerifier verifier;
    private final long expirationMillis;

    // Ajustado o construtor para receber as propriedades mapeadas do Spring
    public JwtService(@Value("${api.security.token.secret}") String secret,
                      @Value("${api.security.token.expiration:28800000}") long expirationMillis) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(this.algorithm)
                .withIssuer(ISSUER)
                .build();
        this.expirationMillis = expirationMillis;
    }

    public String generateToken(String username) {
        Instant now = Instant.now();
        Instant expiration = now.plusMillis(expirationMillis);

        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(username)
                .withIssuedAt(Date.from(now))
                .withExpiresAt(Date.from(expiration))
                .sign(algorithm);
    }

    public String extractUsername(String token) {
        return verifyToken(token).getSubject();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            DecodedJWT decodedJWT = verifyToken(token);
            Instant expiresAt = decodedJWT.getExpiresAt().toInstant();
            return decodedJWT.getSubject().equals(userDetails.getUsername()) &&
                    expiresAt.isAfter(Instant.now());
        } catch (JWTVerificationException ex) {
            return false;
        }
    }

    public long getExpirationMillis() {
        return expirationMillis;
    }

    private DecodedJWT verifyToken(String token) {
        return verifier.verify(token);
    }
}
