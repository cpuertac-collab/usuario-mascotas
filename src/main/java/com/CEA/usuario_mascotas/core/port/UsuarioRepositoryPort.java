package com.CEA.usuario_mascotas.core.port;

import com.CEA.usuario_mascotas.core.domain.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de dominio para gestionar usuarios.
 * El dominio NO sabe cómo se implementa (MySQL, JPA, archivos, etc.).
 */
public interface UsuarioRepositoryPort {

    Usuario guardar(Usuario usuario);

    Optional<Usuario> buscarPorId(String id);

    Optional<Usuario> buscarPorEmail(String email);

    List<Usuario> listarTodos();

    void eliminarPorId(String id);
}
