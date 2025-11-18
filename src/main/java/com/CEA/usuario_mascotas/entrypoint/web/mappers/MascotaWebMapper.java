package com.CEA.usuario_mascotas.entrypoint.web.mappers;

import com.CEA.usuario_mascotas.core.domain.Mascota;
import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.domain.vo.Color;
import com.CEA.usuario_mascotas.core.domain.vo.FechaNacimiento;
import com.CEA.usuario_mascotas.core.domain.vo.Genero;
import com.CEA.usuario_mascotas.core.domain.vo.Peso;
import com.CEA.usuario_mascotas.core.domain.vo.Tamaño;
import com.CEA.usuario_mascotas.entrypoint.web.dto.MascotaRequestDto;


public class MascotaWebMapper {
    
    public static Mascota toDomain(MascotaRequestDto dto, Usuario propietario) {

        return new Mascota(
                dto.getNombre(),
                new Genero(dto.getGenero()),
                new Peso(dto.getPeso()),
                new Tamaño(dto.getTamaño()),
                new Color(dto.getColor()),
                dto.getRaza(),
                new FechaNacimiento(dto.getFechaNacimiento()),
                propietario,
                dto.getDomesticoOSalvaje(),
                dto.getTieneVacunas(),
                dto.getVeterinario()
        );
    }
}
