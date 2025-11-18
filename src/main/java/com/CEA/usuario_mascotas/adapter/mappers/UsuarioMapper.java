package com.CEA.usuario_mascotas.adapter.mappers;

import com.CEA.usuario_mascotas.adapter.config.entity.UsuarioEntity;
import com.CEA.usuario_mascotas.core.domain.Usuario;

public class UsuarioMapper {
    
    public static UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getClaveHash(),
                usuario.getRol()
        );
    }

    public static Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getNombre(),
                entity.getEmail(),
                entity.getClaveHash(),
                entity.getRol()
        );
    }
}
