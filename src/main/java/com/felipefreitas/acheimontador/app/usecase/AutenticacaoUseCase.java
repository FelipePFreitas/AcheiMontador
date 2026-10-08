package com.felipefreitas.acheimontador.app.usecase;

import com.felipefreitas.acheimontador.app.dto.autenticacao.AuthTokenResponseDTO;
import com.felipefreitas.acheimontador.app.dto.autenticacao.LoginRequestDTO;
import com.felipefreitas.acheimontador.app.port.input.AutenticarUsuarioInputPort;
import com.felipefreitas.acheimontador.app.port.output.AutenticarCredenciaisOutputPort;
import com.felipefreitas.acheimontador.app.port.output.GerarTokenOutputPort;

public class AutenticacaoUseCase implements AutenticarUsuarioInputPort {

    private final AutenticarCredenciaisOutputPort autenticacao;
    private final GerarTokenOutputPort geradorDeToken;

    public AutenticacaoUseCase(AutenticarCredenciaisOutputPort autenticacao,
                               GerarTokenOutputPort geradorDeToken) {
        this.autenticacao = autenticacao;
        this.geradorDeToken = geradorDeToken;
    }

    @Override
    public AuthTokenResponseDTO authenticate(LoginRequestDTO request) {
        String username = autenticacao.authenticate(request.login(), request.senha());
        GerarTokenOutputPort.TokenGerado token = geradorDeToken.gerar(username);
        return new AuthTokenResponseDTO("Bearer", token.valor(), token.validadeMillis());
    }
}
