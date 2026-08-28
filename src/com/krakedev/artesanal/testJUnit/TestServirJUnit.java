package com.krakedev.artesanal.testJUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.krakedev.artesanal.Maquina;

public class TestServirJUnit {

    @Test
    public void testServirCerveza() {

        Maquina rubia = new Maquina(
                "Pilsener",
                "cerveza",
                0.02,
                8000,
                "M001"
        );

        rubia.llenarMaquina();

        double valor = rubia.servirCerveza(1000);

        assertEquals(20, valor, 0.0001);
        assertEquals(6800, rubia.getCantidadActual(), 0.0001);
    }
}