package com.CEA.usuario_mascotas.core.domain.vo;

public final class Tamaño {

    private final String valor;

    public Tamaño(String valor) {
        if (!valor.equalsIgnoreCase("pequeño") &&
            !valor.equalsIgnoreCase("mediano") &&
            !valor.equalsIgnoreCase("grande")) {
            throw new IllegalArgumentException("El tamaño debe ser pequeño, mediano o grande.");
        }

        this.valor = valor.toLowerCase();
    }

    public String getValor() {
        return valor;
    }
}
