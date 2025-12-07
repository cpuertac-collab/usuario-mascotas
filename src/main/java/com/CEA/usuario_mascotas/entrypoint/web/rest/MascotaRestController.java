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
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<?> crear(@RequestBody MascotaRequestDto dto) {

    try {
        // 1. Buscar propietario
        Usuario propietario = usuarioRepositoryPort.buscarPorId(dto.getPropietarioId())
                .orElseThrow(() -> new IllegalArgumentException("Propietario no encontrado"));

        // 2. Construir la mascota de dominio
        Mascota mascota = MascotaWebMapper.toDomain(dto, propietario);

        // 3. Guardar en BD mediante el caso de uso
        Mascota guardada = registrarMascotaService.registrar(mascota);

        // 4. Devolver DTO de respuesta
        MascotaResponseDto response = MascotaWebMapper.toResponse(guardada);

        return ResponseEntity.ok(response);

    } catch (IllegalArgumentException e) {
        // Errores de negocio / validación → 400 Bad Request
        return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
        // Errores inesperados → 500, pero con mensaje para debug
        e.printStackTrace(); // se verá en la consola
        return ResponseEntity.internalServerError().body("Error interno al crear la mascota");
    }
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


