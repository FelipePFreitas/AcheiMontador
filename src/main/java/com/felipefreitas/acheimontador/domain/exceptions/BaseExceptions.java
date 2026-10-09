package com.felipefreitas.acheimontador.domain.exceptions;

import lombok.Getter;

@Getter
public class BaseExceptions extends RuntimeException {
    private final ErrorEnum errorEnum;

    public BaseExceptions(ErrorEnum errorEnum) {
        super(errorEnum.getErrorMessage());
        this.errorEnum = errorEnum;
    }
}
