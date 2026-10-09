package com.felipefreitas.acheimontador.infra.mapper;

import com.felipefreitas.acheimontador.domain.model.Autenticacao;
import com.felipefreitas.acheimontador.infra.database.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Autenticacao toEntity(UsuarioEntity usuarioEntity);

    UsuarioEntity toModel(Autenticacao autenticacao);
}
