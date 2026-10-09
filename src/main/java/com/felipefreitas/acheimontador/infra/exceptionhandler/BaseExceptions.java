package com.felipefreitas.acheimontador.infra.exceptionhandler;

import com.felipefreitas.acheimontador.domain.exceptions.ErrorEnum;
import lombok.Getter;

@Getter
public class BaseExceptions extends RuntimeException {
    private final ErrorEnum errorEnum;

    public BaseExceptions(ErrorEnum errorEnum) {
        super(errorEnum.getErrorMessage());

        this.errorEnum = errorEnum;
    }
}
