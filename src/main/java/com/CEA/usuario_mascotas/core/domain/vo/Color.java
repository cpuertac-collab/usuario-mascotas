package com.CEA.usuario_mascotas.core.domain.vo;

public final class Color {

    private final String valor;

    public Color(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El color no puede ser vacío.");
        }

        this.valor = valor.toLowerCase();
    }

    public String getValor() {
        return valor;
    }
}
