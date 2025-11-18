package com.CEA.usuario_mascotas.entrypoint.web.dto;

public class UsuarioResponseDto {
    
    private String id;
    private String nombre;
    private String email;
    private String rol;

    public UsuarioResponseDto(String id, String nombre, String email, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getRol() { return rol; }
}
