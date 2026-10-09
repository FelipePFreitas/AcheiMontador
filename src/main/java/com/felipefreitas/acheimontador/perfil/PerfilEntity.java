package com.felipefreitas.acheimontador.perfil;

import com.felipefreitas.acheimontador.endereco.entity.EnderecoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Table(name = "perfil")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class PerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String sobrenome;
    private String documento;
    private String email;
    private String telefone;
    private EnderecoEntity endereco;

}
