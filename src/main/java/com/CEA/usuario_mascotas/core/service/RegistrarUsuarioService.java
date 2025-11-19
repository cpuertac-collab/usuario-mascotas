package com.CEA.usuario_mascotas.core.service;

import org.springframework.stereotype.Service;

import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.port.UsuarioRepositoryPort;


@Service
public class RegistrarUsuarioService {
    
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public RegistrarUsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    public Usuario registrar(Usuario usuario) {
        return usuarioRepositoryPort.guardar(usuario);
    }
    public void cambiarClave(String id, String nuevaClave) {
    var user = usuarioRepositoryPort.buscarPorId(id)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

    user.cambiarClave(nuevaClave);
    usuarioRepositoryPort.guardar(user);
}

}
