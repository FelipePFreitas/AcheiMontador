package com.felipefreitas.rhexpress.infra.mapper;

import com.felipefreitas.rhexpress.domain.model.Usuario;
import com.felipefreitas.rhexpress.infra.database.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioEntity usuarioEntity);

    UsuarioEntity toModel(Usuario usuario);
}
