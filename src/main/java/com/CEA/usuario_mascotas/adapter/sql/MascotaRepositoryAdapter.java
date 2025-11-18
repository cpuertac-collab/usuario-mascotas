package com.CEA.usuario_mascotas.adapter.sql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.CEA.usuario_mascotas.adapter.config.entity.MascotaEntity;
import com.CEA.usuario_mascotas.adapter.mappers.MascotaMapper;
import com.CEA.usuario_mascotas.adapter.repository.MascotaJpaRepository;
import com.CEA.usuario_mascotas.core.domain.Mascota;
import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.port.MascotaRepositoryPort;
import com.CEA.usuario_mascotas.core.port.UsuarioRepositoryPort;

@Repository
public class MascotaRepositoryAdapter implements MascotaRepositoryPort {

    private final MascotaJpaRepository jpa;
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public MascotaRepositoryAdapter(MascotaJpaRepository jpa,
                                    UsuarioRepositoryPort usuarioRepositoryPort) {
        this.jpa = jpa;
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Mascota guardar(Mascota mascota) {
        MascotaEntity entity = MascotaMapper.toEntity(mascota);
        MascotaEntity guardado = jpa.save(entity);

        Usuario propietario = usuarioRepositoryPort.buscarPorId(guardado.getPropietarioId())
                .orElseThrow();

        return MascotaMapper.toDomain(guardado, propietario);
    }

    @Override
    public Optional<Mascota> buscarPorId(String id) {
        return jpa.findById(id).map(entity -> {
            Usuario propietario = usuarioRepositoryPort.buscarPorId(entity.getPropietarioId())
                    .orElseThrow();
            return MascotaMapper.toDomain(entity, propietario);
        });
    }

    @Override
    public List<Mascota> listarPorPropietario(String propietarioId) {
        return jpa.findByPropietarioId(propietarioId).stream()
                .map(entity -> {
                    Usuario propietario = usuarioRepositoryPort.buscarPorId(propietarioId)
                            .orElseThrow();
                    return MascotaMapper.toDomain(entity, propietario);
                })
                .toList();
    }

    @Override
    public List<Mascota> listarTodas() {
        return jpa.findAll().stream()
                .map(entity -> {
                    Usuario propietario = usuarioRepositoryPort.buscarPorId(entity.getPropietarioId())
                            .orElseThrow();
                    return MascotaMapper.toDomain(entity, propietario);
                })
                .toList();
    }

    @Override
    public void eliminarPorId(String id) {
        jpa.deleteById(id);
    }
}