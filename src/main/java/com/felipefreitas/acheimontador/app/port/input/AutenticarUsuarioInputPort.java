package com.felipefreitas.acheimontador.app.port.input;

import com.felipefreitas.acheimontador.app.command.autenticacao.AutenticarUsuarioCommand;
import com.felipefreitas.acheimontador.app.result.autenticacao.AutenticarUsuarioResult;

public interface AutenticarUsuarioInputPort {

    AutenticarUsuarioResult authenticate(AutenticarUsuarioCommand command);
}
