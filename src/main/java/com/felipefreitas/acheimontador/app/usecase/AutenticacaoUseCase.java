package com.felipefreitas.acheimontador.app.usecase;

import com.felipefreitas.acheimontador.app.command.autenticacao.AutenticarUsuarioCommand;
import com.felipefreitas.acheimontador.app.port.input.AutenticarUsuarioInputPort;
import com.felipefreitas.acheimontador.app.port.output.AutenticarCredenciaisOutputPort;
import com.felipefreitas.acheimontador.app.port.output.GerarTokenOutputPort;
import com.felipefreitas.acheimontador.app.result.autenticacao.AutenticarUsuarioResult;

public class AutenticacaoUseCase implements AutenticarUsuarioInputPort {

    private final AutenticarCredenciaisOutputPort autenticacao;
    private final GerarTokenOutputPort geradorDeToken;

    public AutenticacaoUseCase(AutenticarCredenciaisOutputPort autenticacao,
                               GerarTokenOutputPort geradorDeToken) {
        this.autenticacao = autenticacao;
        this.geradorDeToken = geradorDeToken;
    }

    @Override
    public AutenticarUsuarioResult authenticate(AutenticarUsuarioCommand command) {
        String username = autenticacao.authenticate(command.login(), command.senha());
        GerarTokenOutputPort.TokenGerado token = geradorDeToken.gerar(username);
        return new AutenticarUsuarioResult("Bearer", token.valor(), token.validadeMillis());
    }
}
