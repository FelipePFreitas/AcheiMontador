package com.felipefreitas.acheimontador.domain.exceptions;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    // Erros de Cliente (faixa 1-99)
    CPF_INVALIDO(400, 1, "CPF inválido"),
    CNPJ_INVALIDO(400, 2, "CNPJ inválido"),
    CLIENTE_JA_CADASTRADO(409, 3, "Cliente já cadastrado"),
    CARACTERES_ACIMA(400, 4, "Limite de caracteres excedido"),
    NULO_BRANCO(400, 5, "Campo obrigatório não pode ser nulo ou em branco"),
    CPF_NULO_BRANCO(400, 6, "CPF não pode ser nulo ou em branco"),
    DATA_NASCIMENTO_NULO_BRANCO(400, 7, "Data de nascimento não pode ser nula ou em branco"),
    CEP_INVALIDO(400, 8, "CEP inválido"),
    TIPO_CLIENTE_INVALIDO(400, 9, "Tipo de cliente inválido"),
    CNPJ_NULO_BRANCO(400, 10, "CNPJ não pode ser nulo ou em branco"),
    CPF_JA_CADASTRADO(409, 204, "CPF já cadastrado"),
    LOGIN_JA_CADASTRADO(409, 205, "Login já cadastrado");


    private final int httpStatus;
    private final int errorCode;
    private final String errorMessage;

    ErrorEnum(int httpStatus, int errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
