package com.CEA.usuario_mascotas.adapter.sql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.CEA.usuario_mascotas.adapter.config.entity.UsuarioEntity;
import com.CEA.usuario_mascotas.adapter.mappers.UsuarioMapper;
import com.CEA.usuario_mascotas.adapter.repository.UsuarioJpaRepository;
import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.port.UsuarioRepositoryPort;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository jpa;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity guardado = jpa.save(entity);
        return UsuarioMapper.toDomain(guardado);
    }

    @Override
    public Optional<Usuario> buscarPorId(String id) {
        return jpa.findById(id)
                .map(UsuarioMapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return jpa.findByEmail(email)
                .map(UsuarioMapper::toDomain);
    }

    @Override
    public List<Usuario> listarTodos() {
        return jpa.findAll().stream()
                .map(UsuarioMapper::toDomain)
                .toList();
    }

    @Override
    public void eliminarPorId(String id) {
        jpa.deleteById(id);
    }
}