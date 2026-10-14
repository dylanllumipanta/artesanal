
package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

    public static void main(String[] args) {

        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Carlos", "1234567890");
        negocio.registrarCliente("Maria", "0987654321");
        negocio.registrarCliente("Pedro", "1122334455");

        Cliente clienteCedula =
                negocio.buscarClientePorCedula("1234567890");

        if (clienteCedula != null) {
            System.out.println("Cliente encontrado por cedula:");
            System.out.println(clienteCedula.getNombre());
            System.out.println(clienteCedula.getCodigo());
        } else {
            System.out.println("Cliente no encontrado por cedula");
        }

        Cliente clienteCodigo =
                negocio.buscarClientePorCodigo(102);

        if (clienteCodigo != null) {
            System.out.println("Cliente encontrado por codigo:");
            System.out.println(clienteCodigo.getNombre());
            System.out.println(clienteCodigo.getCedula());
        } else {
            System.out.println("Cliente no encontrado por codigo");
        }
    }
}
