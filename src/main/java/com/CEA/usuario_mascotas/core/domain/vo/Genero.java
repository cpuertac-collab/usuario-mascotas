package com.CEA.usuario_mascotas.core.domain.vo;

public final class Genero {

    private final String valor;

    public Genero(String valor) {
        if (!valor.equalsIgnoreCase("macho") && !valor.equalsIgnoreCase("hembra")) {
            throw new IllegalArgumentException("El género debe ser 'macho' o 'hembra'.");
        }
        this.valor = valor.toLowerCase();
    }

    public String getValor() {
        return valor;
    }
}
