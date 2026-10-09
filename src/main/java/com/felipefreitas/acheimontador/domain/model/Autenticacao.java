package com.felipefreitas.acheimontador.domain.model;

import com.felipefreitas.acheimontador.domain.enums.RoleUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Autenticacao {
    private Long id;
    private String email;
    private String senha;
    private RoleUsuario role;
    private Long usuarioId;
}
