package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

    public static void main(String[] args) {

        boolean resultado;

        Maquina rubia = new Maquina(
                "Pilsener",
                "Cerveza fría",
                0.02,
                8000,
                "M001"
        );

        System.out.println("-------ESTADO INICIAL-----");

        rubia.imprimir();

        System.out.println("-------RECARGA 1-----");

        resultado = rubia.recargarCerveza(3000);

        System.out.println("¿Se recargó correctamente? " + resultado);

        rubia.imprimir();
    }
}