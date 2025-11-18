package com.CEA.usuario_mascotas.core.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.CEA.usuario_mascotas.core.domain.vo.*;

public class Mascota{
    private final String id;
    private String nombre;
    private Genero genero;
    private Peso peso;
    private Tamaño tamaño;
    private Color color;
    private String raza;
    private Usuario propietario;
    private Boolean tieneVacunas;
    private String veterinario;
    private FechaNacimiento fechaNacimiento;
    private boolean domesticoOSalvaje;


    // --- Constructor para CREAR nuevas mascotas ---
    public Mascota(
            String nombre,
            Genero genero,
            Peso peso,
            Tamaño tamaño,
            Color color,
            String raza,
            FechaNacimiento fechaNacimiento,
            Usuario propietario,
            boolean domesticoOSalvaje,
            boolean tieneVacunas,
            String veterinario
    ) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.genero = genero;
        this.peso = peso;
        this.tamaño = tamaño;
        this.color = color;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.propietario = propietario;
        this.domesticoOSalvaje = domesticoOSalvaje;
        this.tieneVacunas = tieneVacunas;
        this.veterinario = veterinario;
    }

    // --- Constructor para RECONSTRUIR desde BD ---
    public Mascota(
            String id,
            String nombre,
            Genero genero,
            Peso peso,
            Tamaño tamaño,
            Color color,
            String raza,
            FechaNacimiento fechaNacimiento,
            Usuario propietario,
            boolean domesticoOSalvaje,
            boolean tieneVacunas,
            String veterinario
    ) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.peso = peso;
        this.tamaño = tamaño;
        this.color = color;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.propietario = propietario;
        this.domesticoOSalvaje = domesticoOSalvaje;
        this.tieneVacunas = tieneVacunas;
        this.veterinario = veterinario;
    }

    // --- Reglas de dominio ---
    public void actualizarPeso(Peso nuevoPeso) {
        this.peso = nuevoPeso;
    }

    public void cambiarColor(Color nuevoColor) {
        this.color = nuevoColor;
    }

    public void cambiarTamaño(Tamaño nuevoTamaño) {
        this.tamaño = nuevoTamaño;
    }

    public void marcarVacunada() {
        this.tieneVacunas = true;
    }

    public void cambiarPropietario(Usuario nuevoPropietario) {
        this.propietario = nuevoPropietario;
    }

    // --- Getters ---
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public Genero getGenero() { return genero; }
    public Peso getPeso() { return peso; }
    public Tamaño getTamaño() { return tamaño; }
    public Color getColor() { return color; }
    public String getRaza() { return raza; }
    public FechaNacimiento getFechaNacimiento() { return fechaNacimiento; }
    public Usuario getPropietario() { return propietario; }
    public boolean isDomesticoOSalvaje() { return domesticoOSalvaje; }
    public boolean isTieneVacunas() { return tieneVacunas; }
    public String getVeterinario() { return veterinario; }

    // --- Igualdad basada en ID ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mascota mascota)) return false;
        return Objects.equals(id, mascota.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}