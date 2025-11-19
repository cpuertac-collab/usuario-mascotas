package com.CEA.usuario_mascotas.core.service;

import org.springframework.stereotype.Service;

import com.CEA.usuario_mascotas.core.domain.Mascota;
import com.CEA.usuario_mascotas.core.port.MascotaRepositoryPort;

@Service
public class RegistrarMascotaService {
    
    private final MascotaRepositoryPort mascotaRepositoryPort;

    public RegistrarMascotaService(MascotaRepositoryPort mascotaRepositoryPort) {
        this.mascotaRepositoryPort = mascotaRepositoryPort;
    }

    public Mascota registrar(Mascota mascota) {
        return mascotaRepositoryPort.guardar(mascota);
    }


}
