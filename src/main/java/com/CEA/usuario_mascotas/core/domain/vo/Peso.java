package com.CEA.usuario_mascotas.core.domain.vo;

public final class Peso {
    private final double valor;

    public Peso(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor positivo.");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}