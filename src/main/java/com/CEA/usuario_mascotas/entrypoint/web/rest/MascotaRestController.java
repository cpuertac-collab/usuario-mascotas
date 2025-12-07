package com.CEA.usuario_mascotas.entrypoint.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CEA.usuario_mascotas.core.domain.Mascota;
import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.port.MascotaRepositoryPort;
import com.CEA.usuario_mascotas.core.port.UsuarioRepositoryPort;
import com.CEA.usuario_mascotas.core.service.RegistrarMascotaService;
import com.CEA.usuario_mascotas.entrypoint.web.dto.MascotaRequestDto;
import com.CEA.usuario_mascotas.entrypoint.web.dto.MascotaResponseDto;
import com.CEA.usuario_mascotas.entrypoint.web.mappers.MascotaWebMapper;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaRestController {

    private final RegistrarMascotaService registrarMascotaService;
    private final MascotaRepositoryPort mascotaRepositoryPort;
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public MascotaRestController(
            RegistrarMascotaService registrarMascotaService,
            MascotaRepositoryPort mascotaRepositoryPort,
            UsuarioRepositoryPort usuarioRepositoryPort
    ) {
        this.registrarMascotaService = registrarMascotaService;
        this.mascotaRepositoryPort = mascotaRepositoryPort;
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    // GET /api/mascotas → lista todas las mascotas
    @GetMapping
    public List<MascotaResponseDto> listarTodas() {
        return mascotaRepositoryPort.listarTodas()
                .stream()
                .map(MascotaWebMapper::toResponse)
                .toList();
    }

    // GET /api/mascotas/propietario/{idUsuario} → lista por dueño
    @GetMapping("/propietario/{idUsuario}")
    public List<MascotaResponseDto> listarPorPropietario(@PathVariable String idUsuario) {
        return mascotaRepositoryPort.listarPorPropietario(idUsuario)
                .stream()
                .map(MascotaWebMapper::toResponse)
                .toList();
    }

    // POST /api/mascotas → crear mascota nueva
    @PostMapping
    public ResponseEntity<MascotaResponseDto> crear(@RequestBody MascotaRequestDto dto) {

        Usuario propietario = usuarioRepositoryPort.buscarPorId(dto.getPropietarioId())
                .orElseThrow(() -> new IllegalArgumentException("Propietario no encontrado"));

        Mascota mascota = MascotaWebMapper.toDomain(dto, propietario);

        Mascota guardada = registrarMascotaService.registrar(mascota);

        MascotaResponseDto response = MascotaWebMapper.toResponse(guardada);

        return ResponseEntity.ok(response);
    }

    // DELETE /api/mascotas/{id} → eliminar mascota
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        var mascotaOpt = mascotaRepositoryPort.buscarPorId(id);
        if (mascotaOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        mascotaRepositoryPort.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}


