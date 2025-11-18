package com.CEA.usuario_mascotas.entrypoint.web.dto;

public class MascotaRequestDto {
    
    private String nombre;
    private String genero;
    private Double peso;
    private String tamaño;
    private String color;
    private String raza;
    private String fechaNacimiento;
    private String propietarioId; // ID del usuario propietario
    private Boolean domesticoOSalvaje;
    private Boolean tieneVacunas;
    private String veterinario;

    public MascotaRequestDto() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(String propietarioId) {
        this.propietarioId = propietarioId;
    }

    public Boolean getDomesticoOSalvaje() {
        return domesticoOSalvaje;
    }

    public void setDomesticoOSalvaje(Boolean domesticoOSalvaje) {
        this.domesticoOSalvaje = domesticoOSalvaje;
    }

    public Boolean getTieneVacunas() {
        return tieneVacunas;
    }

    public void setTieneVacunas(Boolean tieneVacunas) {
        this.tieneVacunas = tieneVacunas;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }
}
