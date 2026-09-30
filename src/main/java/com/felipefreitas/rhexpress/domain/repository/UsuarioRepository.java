package com.felipefreitas.rhexpress.domain.repository;

import com.felipefreitas.rhexpress.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    boolean existsByEmail(String email);

    Usuario save(Usuario usuario);

    Optional<Usuario> findByEmail(String email);

}
