package com.felipefreitas.acheimontador.infra.security;

import com.felipefreitas.acheimontador.app.port.output.AutenticarCredenciaisOutputPort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityAutenticacaoAdapter implements AutenticarCredenciaisOutputPort {

    private final AuthenticationManager authenticationManager;

    public SpringSecurityAutenticacaoAdapter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String authenticate(String login, String senha) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login, senha)
        ).getName();
    }
}
