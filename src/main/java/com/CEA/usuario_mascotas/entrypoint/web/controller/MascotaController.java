package com.CEA.usuario_mascotas.entrypoint.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.port.UsuarioRepositoryPort;
import com.CEA.usuario_mascotas.core.service.RegistrarMascotaService;
import com.CEA.usuario_mascotas.entrypoint.web.dto.MascotaRequestDto;
import com.CEA.usuario_mascotas.entrypoint.web.mappers.MascotaWebMapper;



@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    private final RegistrarMascotaService registrarMascotaService;
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public MascotaController(RegistrarMascotaService registrarMascotaService,
                             UsuarioRepositoryPort usuarioRepositoryPort) {
        this.registrarMascotaService = registrarMascotaService;
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @PostMapping("/crear")
    public String crearMascota(MascotaRequestDto dto, Model model) {

        Usuario propietario = usuarioRepositoryPort.buscarPorId(dto.getPropietarioId())
                .orElseThrow(() -> new IllegalArgumentException("Propietario no encontrado"));

        var mascota = MascotaWebMapper.toDomain(dto, propietario);

        registrarMascotaService.registrar(mascota);

        return "redirect:/mascotas/lista";
    }
}