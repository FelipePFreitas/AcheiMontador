package com.felipefreitas.acheimontador.domain.enums;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum Planos {
    MENSAL("Plano Mensal", new BigDecimal("9.90")),
    SEMESTRAL("Plano Semestral", new BigDecimal("50.00")),
    ANUAL("Plano Anual", new BigDecimal("95.00"));

    private String descricao;
    private BigDecimal valor;

    Planos(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
