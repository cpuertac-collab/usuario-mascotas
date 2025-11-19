package com.CEA.usuario_mascotas.adapter.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.CEA.usuario_mascotas.adapter.config.entity.MascotaEntity;
import com.CEA.usuario_mascotas.adapter.mappers.MascotaMapper;
import com.CEA.usuario_mascotas.core.domain.Mascota;
import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.port.MascotaRepositoryPort;

@Repository
public class MascotaRepositoryAdapter implements MascotaRepositoryPort {

    private final MascotaJpaRepository jpaRepository;

    public MascotaRepositoryAdapter(MascotaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Mascota guardar(Mascota mascota) {
        MascotaEntity entity = MascotaMapper.toEntity(mascota);
        MascotaEntity guardado = jpaRepository.save(entity);
        return MascotaMapper.toDomain(guardado, mascota.getPropietario());
    }

    @Override
    public Optional<Mascota> buscarPorId(String id) {
        return jpaRepository.findById(id)
                .map(entity -> {
                    Usuario placeholderPropietario =
                            new Usuario(entity.getPropietarioId(), null, null, null);
                    return MascotaMapper.toDomain(entity, placeholderPropietario);
                });
    }

    @Override
    public List<Mascota> listarPorPropietario(String propietarioId) {
        return jpaRepository.findByPropietarioId(propietarioId)
                .stream()
                .map(entity -> {
                    Usuario placeholderPropietario =
                            new Usuario(entity.getPropietarioId(), null, null, null);
                    return MascotaMapper.toDomain(entity, placeholderPropietario);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Mascota> listarTodas() {
        return jpaRepository.findAll()
                .stream()
                .map(entity -> {
                    Usuario placeholderPropietario =
                            new Usuario(entity.getPropietarioId(), null, null, null);
                    return MascotaMapper.toDomain(entity, placeholderPropietario);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPorId(String id) {
        jpaRepository.deleteById(id);
    }
}
