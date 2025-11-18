package com.CEA.usuario_mascotas.entrypoint.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CEA.usuario_mascotas.core.service.ListarUsuariosService;
import com.CEA.usuario_mascotas.core.service.RegistrarUsuarioService;
import com.CEA.usuario_mascotas.entrypoint.web.dto.UsuarioRequestDto;
import com.CEA.usuario_mascotas.entrypoint.web.dto.UsuarioResponseDto;
import com.CEA.usuario_mascotas.entrypoint.web.mappers.UsuarioWebMapper;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final RegistrarUsuarioService registrarUsuarioService;
    private final ListarUsuariosService listarUsuariosService;

    public UsuarioController(
            RegistrarUsuarioService registrarUsuarioService,
            ListarUsuariosService listarUsuariosService) {
        this.registrarUsuarioService = registrarUsuarioService;
        this.listarUsuariosService = listarUsuariosService;
    }

    // Mostrar formulario
    @GetMapping("/crear")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new UsuarioRequestDto());
        return "usuarios/crear";  // Archivo Thymeleaf: templates/usuarios/crear.html
    }

    // Guardar usuario (POST)
    @PostMapping("/crear")
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioRequestDto dto) {

        var usuario = UsuarioWebMapper.toDomain(dto);
        registrarUsuarioService.registrar(usuario);

        return "redirect:/usuarios/listar";
    }

    // Listar usuarios
    @GetMapping("/listar")
    public String listarUsuarios(Model model) {

        List<UsuarioResponseDto> usuarios = listarUsuariosService.listar();
        model.addAttribute("usuarios", usuarios);

        return "usuarios/listar"; // templates/usuarios/listar.html
    }
    
}
