package com.felipefreitas.rhexpress.infra.database.adapter;

import com.felipefreitas.rhexpress.domain.model.Usuario;
import com.felipefreitas.rhexpress.domain.repository.UsuarioRepository;
import com.felipefreitas.rhexpress.infra.database.entity.UsuarioEntity;
import com.felipefreitas.rhexpress.infra.mapper.UsuarioMapper;
import com.felipefreitas.rhexpress.infra.persistence.UsuarioPersistence;
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
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioMapper.toModel(usuario);
        UsuarioEntity usuarioSalvo = usuarioPersistence.save(usuarioEntity);
        return usuarioMapper.toEntity(usuarioSalvo);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioPersistence.findByEmail(email).stream().map(usuarioMapper::toEntity).findFirst();
    }
}
