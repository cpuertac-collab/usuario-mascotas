package com.CEA.usuario_mascotas.core.service;

import com.CEA.usuario_mascotas.core.domain.Mascota;
import com.CEA.usuario_mascotas.core.port.MascotaRepositoryPort;

public class RegistrarMascotaService {
    
    private final MascotaRepositoryPort mascotaRepositoryPort;

    public RegistrarMascotaService(MascotaRepositoryPort mascotaRepositoryPort) {
        this.mascotaRepositoryPort = mascotaRepositoryPort;
    }

    public Mascota registrar(Mascota mascota) {
        return mascotaRepositoryPort.guardar(mascota);
    }


}
