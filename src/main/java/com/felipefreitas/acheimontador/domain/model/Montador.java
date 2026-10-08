package com.felipefreitas.acheimontador.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Montador {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String documento;
    private Endereco endereco;

}
