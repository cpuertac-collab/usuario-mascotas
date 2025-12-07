package com.CEA.usuario_mascotas.entrypoint.web.mappers;

import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.entrypoint.web.dto.UsuarioRequestDto;
import com.CEA.usuario_mascotas.entrypoint.web.dto.UsuarioResponseDto;

public class UsuarioWebMapper {
    
    // Convierte DTO → Dominio
    public static Usuario toDomain(UsuarioRequestDto dto) {
        return new Usuario(
            dto.getNombre(),
            dto.getEmail(),
            dto.getClaveHash(),
            dto.getRol()
        );
    }

    // Convierte Dominio → DTO (para devolver JSON en las APIs REST)
    public static UsuarioResponseDto toResponse(Usuario usuario) {
        return new UsuarioResponseDto(
            usuario.getId(),
            usuario.getNombre(),
            usuario.getEmail(),
            usuario.getRol()
        );
    }
}

