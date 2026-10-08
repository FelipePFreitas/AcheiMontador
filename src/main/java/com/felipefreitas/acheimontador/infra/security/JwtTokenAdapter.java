package com.felipefreitas.acheimontador.infra.security;

import com.felipefreitas.acheimontador.app.port.output.GerarTokenOutputPort;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenAdapter implements GerarTokenOutputPort {

    private final JwtService jwtService;

    public JwtTokenAdapter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public TokenGerado gerar(String username) {
        return new TokenGerado(
                jwtService.generateToken(username),
                jwtService.getExpirationMillis()
        );
    }
}
