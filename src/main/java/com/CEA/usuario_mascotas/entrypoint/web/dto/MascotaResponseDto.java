package com.CEA.usuario_mascotas.entrypoint.web.dto;

public class MascotaResponseDto {
    
    private String id;
    private String nombre;
    private String genero;
    private Double peso;
    private String tamaño;
    private String color;
    private String raza;
    private String fechaNacimiento;
    private String propietarioNombre;
    private Boolean domesticoOSalvaje;
    private Boolean tieneVacunas;
    private String veterinario;

    public MascotaResponseDto(
            String id,
            String nombre,
            String genero,
            Double peso,
            String tamaño,
            String color,
            String raza,
            String fechaNacimiento,
            String propietarioNombre,
            Boolean domesticoOSalvaje,
            Boolean tieneVacunas,
            String veterinario) {

        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.peso = peso;
        this.tamaño = tamaño;
        this.color = color;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.propietarioNombre = propietarioNombre;
        this.domesticoOSalvaje = domesticoOSalvaje;
        this.tieneVacunas = tieneVacunas;
        this.veterinario = veterinario;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getGenero() { return genero; }
    public Double getPeso() { return peso; }
    public String getTamaño() { return tamaño; }
    public String getColor() { return color; }
    public String getRaza() { return raza; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getPropietarioNombre() { return propietarioNombre; }
    public Boolean getDomesticoOSalvaje() { return domesticoOSalvaje; }
    public Boolean getTieneVacunas() { return tieneVacunas; }
    public String getVeterinario() { return veterinario; }
}
