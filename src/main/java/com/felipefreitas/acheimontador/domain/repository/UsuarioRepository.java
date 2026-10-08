package com.felipefreitas.acheimontador.domain.repository;

import com.felipefreitas.acheimontador.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    boolean existsByEmail(String email);

    Usuario save(Usuario usuario);

    Optional<Usuario> findByEmail(String email);

}
