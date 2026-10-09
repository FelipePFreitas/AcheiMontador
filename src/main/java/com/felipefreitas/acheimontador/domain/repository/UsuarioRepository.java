package com.felipefreitas.acheimontador.domain.repository;

import com.felipefreitas.acheimontador.domain.model.Autenticacao;

import java.util.Optional;

public interface UsuarioRepository {

    boolean existsByEmail(String email);

    Autenticacao save(Autenticacao autenticacao);

    Optional<Autenticacao> findByEmail(String email);

}
