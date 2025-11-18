package com.CEA.usuario_mascotas.adapter.repository;

import com.CEA.usuario_mascotas.adapter.config.entity.MascotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotaJpaRepository extends JpaRepository<MascotaEntity, String> {

    List<MascotaEntity> findByPropietarioId(String propietarioId);
}
