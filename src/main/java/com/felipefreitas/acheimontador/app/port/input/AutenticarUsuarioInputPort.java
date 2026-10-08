package com.felipefreitas.acheimontador.app.port.input;

import com.felipefreitas.acheimontador.app.dto.autenticacao.AuthTokenResponseDTO;
import com.felipefreitas.acheimontador.app.dto.autenticacao.LoginRequestDTO;

public interface AutenticarUsuarioInputPort {

    AuthTokenResponseDTO authenticate(LoginRequestDTO request);
}
