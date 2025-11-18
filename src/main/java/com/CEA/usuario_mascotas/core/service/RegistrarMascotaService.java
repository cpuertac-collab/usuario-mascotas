package com.CEA.usuario_mascotas.core.service;

import com.CEA.usuario_mascotas.core.domain.Mascota;
import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.domain.vo.Color;
import com.CEA.usuario_mascotas.core.domain.vo.FechaNacimiento;
import com.CEA.usuario_mascotas.core.domain.vo.Genero;
import com.CEA.usuario_mascotas.core.domain.vo.Peso;
import com.CEA.usuario_mascotas.core.domain.vo.Tamaño;
import com.CEA.usuario_mascotas.core.port.MascotaRepositoryPort;
import com.CEA.usuario_mascotas.core.port.UsuarioRepositoryPort;

public class RegistrarMascotaService {
    
    private final MascotaRepositoryPort mascotaRepository;
    private final UsuarioRepositoryPort usuarioRepository;

    public RegistrarMascotaService(MascotaRepositoryPort mascotaRepository, UsuarioRepositoryPort usuarioRepository) {
        this.mascotaRepository = mascotaRepository;
        this.usuarioRepository = usuarioRepository;
    }

     public Mascota ejecutar(
            String nombre,
            String genero,
            double peso,
            String tamaño,
            String color,
            String raza,
            String especie,
            java.time.LocalDate fechaNacimiento,
            String propietarioId,
            boolean domesticoOSalvaje,
            boolean tieneVacunas,
            String veterinario
    ) {

        Usuario propietario = usuarioRepository.buscarPorId(propietarioId)
                .orElseThrow(() -> new IllegalArgumentException("El propietario no existe"));

        Mascota mascota = new Mascota(
                nombre,
                new Genero(genero),
                new Peso(peso),
                new Tamaño(tamaño),
                new Color(color),
                raza,
                new FechaNacimiento(fechaNacimiento),
                propietario,
                domesticoOSalvaje,
                tieneVacunas,
                veterinario
        );

        return mascotaRepository.guardar(mascota);
    }


}
