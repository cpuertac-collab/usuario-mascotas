package com.CEA.usuario_mascotas.core.service;

import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.port.UsuarioRepositoryPort;

public class RegistrarUsuarioService {
    
    private final UsuarioRepositoryPort usuarioRepository;

    public RegistrarUsuarioService(UsuarioRepositoryPort usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario ejecutar(
            String nombre,
            String email,
            String claveHash,
            String rol
    ) {
        Usuario nuevo = new Usuario(nombre, email, claveHash, rol);
        return usuarioRepository.guardar(nuevo);
    }
}
