package com.CEA.usuario_mascotas.entrypoint.web.mappers;

import java.util.UUID;

import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.entrypoint.web.dto.UsuarioRequestDto;

public class UsuarioWebMapper {
    
    public static Usuario toDomain(UsuarioRequestDto dto) {

        return new Usuario(
                UUID.randomUUID().toString(),
                dto.getNombre(),
                dto.getEmail(),
                dto.getClaveHash(),
                dto.getRol()
        );
    }
}
