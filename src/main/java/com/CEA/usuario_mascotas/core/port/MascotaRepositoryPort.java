package com.CEA.usuario_mascotas.core.port;

import com.CEA.usuario_mascotas.core.domain.Mascota;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de dominio para gestionar mascotas.
 * La infraestructura proveerá la implementación.
 */
public interface MascotaRepositoryPort {

    Mascota guardar(Mascota mascota);

    Optional<Mascota> buscarPorId(String id);

    List<Mascota> listarPorPropietario(String propietarioId);

    List<Mascota> listarTodas();

    void eliminarPorId(String id);
}
