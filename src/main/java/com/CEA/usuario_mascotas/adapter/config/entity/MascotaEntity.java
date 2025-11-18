package com.CEA.usuario_mascotas.adapter.config.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "mascotas")
public class MascotaEntity {

    @Id
    private String id;

    private String nombre;
    private String genero;
    private double peso;
    private String tamaño;
    private String color;
    private String raza;
    private LocalDate fechaNacimiento;

    private String propietarioId;         // referencia al Usuario
    private boolean domesticoOSalvaje;
    private boolean tieneVacunas;
    private String veterinario;

    public MascotaEntity() {}

    public MascotaEntity(String id, String nombre, String genero, double peso,
                         String tamaño, String color, String raza,
                         LocalDate fechaNacimiento, String propietarioId,
                         boolean domesticoOSalvaje, boolean tieneVacunas,
                         String veterinario) {

        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.peso = peso;
        this.tamaño = tamaño;
        this.color = color;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.propietarioId = propietarioId;
        this.domesticoOSalvaje = domesticoOSalvaje;
        this.tieneVacunas = tieneVacunas;
        this.veterinario = veterinario;
    }

    // getters y setters ...

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getTamaño() { return tamaño; }
    public void setTamaño(String tamaño) { this.tamaño = tamaño; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getPropietarioId() { return propietarioId; }
    public void setPropietarioId(String propietarioId) { this.propietarioId = propietarioId; }

    public boolean isDomesticoOSalvaje() { return domesticoOSalvaje; }
    public void setDomesticoOSalvaje(boolean domesticoOSalvaje) { this.domesticoOSalvaje = domesticoOSalvaje; }

    public boolean isTieneVacunas() { return tieneVacunas; }
    public void setTieneVacunas(boolean tieneVacunas) { this.tieneVacunas = tieneVacunas; }

    public String getVeterinario() { return veterinario; }
    public void setVeterinario(String veterinario) { this.veterinario = veterinario; }
}
