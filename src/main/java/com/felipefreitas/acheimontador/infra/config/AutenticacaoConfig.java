package com.felipefreitas.acheimontador.infra.config;

import com.felipefreitas.acheimontador.app.port.output.AutenticarCredenciaisOutputPort;
import com.felipefreitas.acheimontador.app.port.output.GerarTokenOutputPort;
import com.felipefreitas.acheimontador.app.usecase.AutenticacaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutenticacaoConfig {

    @Bean
    public AutenticacaoUseCase autenticacaoUseCase(
            AutenticarCredenciaisOutputPort autenticacao,
            GerarTokenOutputPort geradorDeToken) {
        return new AutenticacaoUseCase(autenticacao, geradorDeToken);
    }
}
