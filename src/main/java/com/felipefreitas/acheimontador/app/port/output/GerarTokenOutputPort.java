package com.felipefreitas.acheimontador.app.port.output;

public interface GerarTokenOutputPort {

    TokenGerado gerar(String username);

    record TokenGerado(String valor, long validadeMillis) {
    }
}
