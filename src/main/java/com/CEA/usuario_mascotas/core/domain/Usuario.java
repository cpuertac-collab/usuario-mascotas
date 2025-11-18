package com.CEA.usuario_mascotas.core.domain;

import java.util.Objects;
import java.util.UUID;


public class Usuario {
    private final String id;
    private String nombre;
    private String email;
    private String claveHash;
    private String rol;


    // --- Constructor para crear nuevos usuarios ---
    public Usuario(String nombre, String email, String claveHash, String rol) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.email = email;
        this.claveHash = claveHash;
        this.rol = rol;
    }

    // --- Constructor para reconstruir usuario desde BD ---
    public Usuario(String id, String nombre, String email, String claveHash, 
                   String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.claveHash = claveHash;
        this.rol = rol;
    }

    // --- Reglas de dominio ---
    public void cambiarNombre(String nuevo) {
        if (nuevo == null || nuevo.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nuevo;
    }

    public void cambiarClave(String nuevaClaveHash) {
        if (nuevaClaveHash == null || nuevaClaveHash.isBlank()) {
            throw new IllegalArgumentException("Clave inválida.");
        }
        this.claveHash = nuevaClaveHash;
    }

    // --- Getters ---
    public String getId() { return id; }

    public String getNombre() { return nombre; }

    public String getEmail() { return email; }

    public String getClaveHash() { return claveHash; }

    public String getRol() { return rol; }

    // --- Equals & HashCode por ID ---
    // Esto es para que dos usuarios con el mismo ID sean considerados iguales
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Usuario usuario)) return false;
    return Objects.equals(id, usuario.id);
}

@Override
public int hashCode() {
    return Objects.hash(id);
}

    
}