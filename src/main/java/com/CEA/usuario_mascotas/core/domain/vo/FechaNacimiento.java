package com.CEA.usuario_mascotas.core.domain.vo;

import java.time.LocalDate;

public final class FechaNacimiento {

    private final LocalDate valor;

    // Constructor para LocalDate
    public FechaNacimiento(LocalDate valor) {
        validar(valor);
        this.valor = valor;
    }

    // Nuevo constructor que recibe String (para formularios)
    public FechaNacimiento(String valorComoTexto) {
        if (valorComoTexto == null || valorComoTexto.isBlank()) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede estar vacía.");
        }

        LocalDate fecha = LocalDate.parse(valorComoTexto); // convierte String → LocalDate
        validar(fecha);
        this.valor = fecha;
    }

    private void validar(LocalDate fecha) {
        if (fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura.");
        }
    }

    public LocalDate getValor() {
        return valor;
    }
}
