package com.krakedev.artesanal.testJUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.krakedev.artesanal.Maquina;

public class TestCodigoJUnit {

    @Test
    public void testCodigo() {

        Maquina rubia = new Maquina(
                "Pilsener",
                "cerveza",
                0.02,
                8000,
                "M001"
        );

        assertEquals("M001", rubia.getCodigo());
    }
}