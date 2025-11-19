package com.CEA.usuario_mascotas.core.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.port.UsuarioRepositoryPort;
import com.CEA.usuario_mascotas.entrypoint.web.dto.UsuarioResponseDto;

@Service
public class ListarUsuariosService {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public ListarUsuariosService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    public List<UsuarioResponseDto> listar() {

        // Usamos el método definido en el puerto
        List<Usuario> usuarios = usuarioRepositoryPort.listarTodos();

        return usuarios.stream()
                .map(usuario -> new UsuarioResponseDto(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getEmail(),
                        usuario.getRol()
                ))
                .collect(Collectors.toList());
    }
}
