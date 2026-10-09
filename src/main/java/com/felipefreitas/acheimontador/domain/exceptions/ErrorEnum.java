package com.felipefreitas.acheimontador.domain.exceptions;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    // Erros de Cliente (faixa 1-99)
    CPF_INVALIDO(1, "CPF inválido"),
    CNPJ_INVALIDO(2, "CNPJ inválido"),
    CLIENTE_JA_CADASTRADO(3, "Cliente já cadastrado"),
    CARACTERES_ACIMA(4, "Limite de caracteres excedido"),
    NULO_BRANCO(5, "Campo obrigatório não pode ser nulo ou em branco"),
    CPF_NULO_BRANCO(6, "CPF não pode ser nulo ou em branco"),
    DATA_NASCIMENTO_NULO_BRANCO(7, "Data de nascimento não pode ser nula ou em branco"),
    CEP_INVALIDO(8, "CEP inválido"),
    TIPO_CLIENTE_INVALIDO(9, "Tipo de cliente inválido"),
    CNPJ_NULO_BRANCO(10, "CNPJ não pode ser nulo ou em branco"),
    CPF_JA_CADASTRADO(204, "CPF já cadastrado"),
    LOGIN_JA_CADASTRADO(205, "Login já cadastrado");

    private final int errorCode;
    private final String errorMessage;

    ErrorEnum(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
