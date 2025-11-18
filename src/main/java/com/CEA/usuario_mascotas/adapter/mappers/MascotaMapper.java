package com.CEA.usuario_mascotas.adapter.mappers;

import com.CEA.usuario_mascotas.adapter.config.entity.MascotaEntity;
import com.CEA.usuario_mascotas.core.domain.Mascota;
import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.domain.vo.*;

public class MascotaMapper {

    public static MascotaEntity toEntity(Mascota mascota) {
        return new MascotaEntity(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getGenero().getValor(),
                mascota.getPeso().getValor(),
                mascota.getTamaño().getValor(),
                mascota.getColor().getValor(),
                mascota.getRaza(),
                mascota.getFechaNacimiento().getValor(),
                mascota.getPropietario().getId(),
                mascota.isDomesticoOSalvaje(),
                mascota.isTieneVacunas(),
                mascota.getVeterinario()
        );
    }

    public static Mascota toDomain(MascotaEntity entity, Usuario propietario) {
        return new Mascota(
                entity.getId(),
                entity.getNombre(),
                new Genero(entity.getGenero()),
                new Peso(entity.getPeso()),
                new Tamaño(entity.getTamaño()),
                new Color(entity.getColor()),
                entity.getRaza(),
                new FechaNacimiento(entity.getFechaNacimiento()),
                propietario,
                entity.isDomesticoOSalvaje(),
                entity.isTieneVacunas(),
                entity.getVeterinario()
        );
    }
}
