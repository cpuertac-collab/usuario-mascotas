package com.CEA.usuario_mascotas.entrypoint.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/recuperar")
    public String mostrarFormularioRecuperar() {
        return "usuarios/recuperar"; // templates/usuarios/recuperar.html
    }

    // Procesar email y mostrar formulario de nueva contraseña
@PostMapping("/recuperar")
public String procesarRecuperar(@RequestParam("email") String email, Model model) {

    var userOpt = listarUsuariosService.buscarPorEmail(email);

    if (userOpt.isEmpty()) {
        model.addAttribute("error", "No existe un usuario con ese correo.");
        return "usuarios/recuperar";
    }

    // Pasamos el ID a la vista
    model.addAttribute("idUsuario", userOpt.get().getId());

    return "usuarios/cambiar-clave";
    }

    // Cambiar contraseña
@PostMapping("/cambiar-clave")
public String cambiarClave(@RequestParam("idUsuario") String id,
                           @RequestParam("nuevaClave") String nuevaClave) {

    registrarUsuarioService.cambiarClave(id, nuevaClave);

    return "redirect:/login?claveCambiada";
}

}