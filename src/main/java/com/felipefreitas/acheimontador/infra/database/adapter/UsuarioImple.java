package com.felipefreitas.acheimontador.infra.database.adapter;

import com.felipefreitas.acheimontador.domain.model.Autenticacao;
import com.felipefreitas.acheimontador.domain.repository.UsuarioRepository;
import com.felipefreitas.acheimontador.infra.database.entity.UsuarioEntity;
import com.felipefreitas.acheimontador.infra.mapper.UsuarioMapper;
import com.felipefreitas.acheimontador.infra.persistence.UsuarioPersistence;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioImple implements UsuarioRepository {

    private final UsuarioPersistence usuarioPersistence;
    private final UsuarioMapper usuarioMapper;

    public UsuarioImple(UsuarioPersistence usuarioPersistence, UsuarioMapper usuarioMapper) {
        this.usuarioPersistence = usuarioPersistence;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioPersistence.existsByEmail(email);
    }

    @Override
    public Autenticacao save(Autenticacao autenticacao) {
        UsuarioEntity usuarioEntity = usuarioMapper.toModel(autenticacao);
        UsuarioEntity usuarioSalvo = usuarioPersistence.save(usuarioEntity);
        return usuarioMapper.toEntity(usuarioSalvo);
    }

    @Override
    public Optional<Autenticacao> findByEmail(String email) {
        return usuarioPersistence.findByEmail(email).stream().map(usuarioMapper::toEntity).findFirst();
    }
}
