package com.felipefreitas.acheimontador.infra.exceptionhandler;

import com.felipefreitas.acheimontador.domain.exceptions.ErrorEnum;
import com.felipefreitas.acheimontador.domain.exceptions.BaseExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseExceptions.class)
    public ResponseEntity<ProblemDetail> handleBaseException(BaseExceptions ex) {
        ErrorEnum error = ex.getErrorEnum();
        HttpStatus status = statusFor(error);

        // Cria o padrão oficial do Spring
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                status,
                error.getErrorMessage()
        );

        // Adiciona o seu código de erro customizado como uma propriedade extra
        problemDetail.setProperty("errorCode", error.getErrorCode());
        problemDetail.setTitle("Erro na Regra de Negócio");

        return ResponseEntity.status(status).body(problemDetail);
    }

    private HttpStatus statusFor(ErrorEnum error) {
        return switch (error) {
            case CPF_INVALIDO, CNPJ_INVALIDO, CARACTERES_ACIMA, NULO_BRANCO,
                    CPF_NULO_BRANCO, DATA_NASCIMENTO_NULO_BRANCO, CEP_INVALIDO,
                    TIPO_CLIENTE_INVALIDO, CNPJ_NULO_BRANCO -> HttpStatus.BAD_REQUEST;
            case CLIENTE_JA_CADASTRADO, CPF_JA_CADASTRADO, LOGIN_JA_CADASTRADO ->
                    HttpStatus.CONFLICT;
        };
    }
}
