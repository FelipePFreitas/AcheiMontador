package com.felipefreitas.acheimontador.infra.persistence;

import com.felipefreitas.acheimontador.infra.database.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioPersistence extends JpaRepository<UsuarioEntity, Long> {
    boolean existsByEmail(String email);

    UsuarioEntity save(UsuarioEntity usuario);

    Optional<UsuarioEntity> findByEmail(String email);
}
