package com.krakedev.artesanal.testJUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {

    @Test
    public void testRecargarCerveza() {

        Maquina rubia = new Maquina(
                "Pilsener",
                "cerveza",
                0.02,
                8000,
                "M001"
        );

        boolean resultado = rubia.recargarCerveza(3000);

        assertTrue(resultado);
        assertEquals(3000, rubia.getCantidadActual(), 0.0001);
    }
}