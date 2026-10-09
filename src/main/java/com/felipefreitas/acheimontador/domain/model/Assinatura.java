package com.felipefreitas.acheimontador.domain.model;

import com.felipefreitas.acheimontador.domain.enums.Planos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Assinatura {
    private Long id;
    private boolean status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataExpiracao;
    private Planos planos;
    private Montador montador;

}
