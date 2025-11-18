package com.CEA.usuario_mascotas.core.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Mascota{
    private final String id;
    private String nombre;
    private String genero;
    private double peso;
    private double tamaño;
    private String color;
    private String raza;
    private Usuario propietario;
    private Boolean tieneVacunas;
    private String veterinario;
    private LocalDate fechaNacimiento;
    private boolean domesticoOSalvaje;


    // --- Constructor para CREAR nuevas mascotas ---
    public Mascota(
            String nombre,
            String genero,
            double peso,
            Double tamaño,
            String color,
            String raza,
            LocalDate fechaNacimiento,
            Usuario propietario,
            boolean domesticoOSalvaje,
            boolean tieneVacunas,
            String veterinario
    ) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.genero = genero;
        this.peso = validarPeso(peso);
        this.tamaño = tamaño;
        this.color = color;
        this.raza = raza;
        this.fechaNacimiento = validarFecha(fechaNacimiento);
        this.propietario = propietario;
        this.domesticoOSalvaje = domesticoOSalvaje;
        this.tieneVacunas = tieneVacunas;
        this.veterinario = veterinario;
    }

    // --- Constructor para RECONSTRUIR desde BD ---
    public Mascota(
            String id,
            String nombre,
            String genero,
            double peso,
            Double tamaño,
            String color,
            String raza,
            String especie,
            LocalDate fechaNacimiento,
            Usuario propietario,
            boolean domesticoOSalvaje,
            boolean tieneVacunas,
            String veterinario
    ) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.peso = validarPeso(peso);
        this.tamaño = tamaño;
        this.color = color;
        this.raza = raza;
        this.fechaNacimiento = validarFecha(fechaNacimiento);
        this.propietario = propietario;
        this.domesticoOSalvaje = domesticoOSalvaje;
        this.tieneVacunas = tieneVacunas;
        this.veterinario = veterinario;
    }

    // --- Invariantes del dominio ---
    private double validarPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }
        return peso;
    }

    private LocalDate validarFecha(LocalDate fecha) {
        if (fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura.");
        }
        return fecha;
    }

    // --- Reglas de dominio ---
    public void actualizarPeso(double nuevoPeso) {
        this.peso = validarPeso(nuevoPeso);
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
    public String getGenero() { return genero; }
    public double getPeso() { return peso; }
    public Double getTamaño() { return tamaño; }
    public String getColor() { return color; }
    public String getRaza() { return raza; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
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