package com.felipefreitas.acheimontador.infra.config;

import com.felipefreitas.acheimontador.infra.mapper.UsuarioMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {

    @Bean
    public UsuarioMapper usuarioMapper() {
        return Mappers.getMapper(UsuarioMapper.class);
    }
}
