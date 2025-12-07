package com.CEA.usuario_mascotas.entrypoint.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CEA.usuario_mascotas.core.domain.Usuario;
import com.CEA.usuario_mascotas.core.port.UsuarioRepositoryPort;
import com.CEA.usuario_mascotas.core.service.RegistrarUsuarioService;
import com.CEA.usuario_mascotas.core.service.ListarUsuariosService;
import com.CEA.usuario_mascotas.entrypoint.web.dto.UsuarioRequestDto;
import com.CEA.usuario_mascotas.entrypoint.web.dto.UsuarioResponseDto;
import com.CEA.usuario_mascotas.entrypoint.web.mappers.UsuarioWebMapper;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    private final RegistrarUsuarioService registrarUsuarioService;
    private final ListarUsuariosService listarUsuariosService;
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioRestController(
            RegistrarUsuarioService registrarUsuarioService,
            ListarUsuariosService listarUsuariosService,
            UsuarioRepositoryPort usuarioRepositoryPort
    ) {
        this.registrarUsuarioService = registrarUsuarioService;
        this.listarUsuariosService = listarUsuariosService;
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    // GET /api/usuarios → lista todos
    @GetMapping
    public List<UsuarioResponseDto> listar() {
        return listarUsuariosService.listar();
    }

    // GET /api/usuarios/{id} → obtiene un usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable String id) {
        return usuarioRepositoryPort.buscarPorId(id)
                .map(UsuarioWebMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/usuarios → crea un usuario nuevo
    @PostMapping
    public ResponseEntity<UsuarioResponseDto> crear(@RequestBody UsuarioRequestDto dto) {
        Usuario usuario = UsuarioWebMapper.toDomain(dto);
        Usuario guardado = registrarUsuarioService.registrar(usuario);
        UsuarioResponseDto response = UsuarioWebMapper.toResponse(guardado);
        return ResponseEntity.ok(response);
    }

    // DELETE /api/usuarios/{id} → elimina un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (usuarioRepositoryPort.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        usuarioRepositoryPort.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}