package com.felipefreitas.acheimontador.infra.mapper;

import com.felipefreitas.acheimontador.domain.model.Usuario;
import com.felipefreitas.acheimontador.infra.database.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioEntity usuarioEntity);

    UsuarioEntity toModel(Usuario usuario);
}
