package com.CEA.usuario_mascotas.core.domain.vo;

import java.time.LocalDate;

public final class FechaNacimiento {

    private final LocalDate valor;

    public FechaNacimiento(LocalDate valor) {
        if (valor.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura.");
        }
        this.valor = valor;
    }

    public LocalDate getValor() {
        return valor;
    }
}
