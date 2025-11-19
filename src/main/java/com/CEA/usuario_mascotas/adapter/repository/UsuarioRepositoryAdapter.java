package com.CEA.usuario_mascotas.adapter.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.CEA.usuario_mascotas.adapter.config.entity.UsuarioEntity;
import com.CEA.usuario_mascotas.adapter.mappers.UsuarioMapper;
import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.port.UsuarioRepositoryPort;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository jpaRepository;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity guardado = jpaRepository.save(entity);
        return UsuarioMapper.toDomain(guardado);
    }

    @Override
    public Optional<Usuario> buscarPorId(String id) {
        return jpaRepository.findById(id)
                .map(UsuarioMapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(UsuarioMapper::toDomain);
    }

    @Override
    public List<Usuario> listarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPorId(String id) {
        jpaRepository.deleteById(id);
    }
}
