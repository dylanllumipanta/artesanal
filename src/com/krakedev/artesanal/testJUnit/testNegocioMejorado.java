
package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class testNegocioMejorado {

    @Test
    public void testRegistrarCliente() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Carlos", "1234567890");

        Cliente cliente = negocio.buscarClientePorCedula("1234567890");

        assertNotNull(cliente);
        assertEquals("Carlos", cliente.getNombre());
        assertEquals("1234567890", cliente.getCedula());
        assertEquals(101, cliente.getCodigo());
        assertEquals(0.0, cliente.getTotalConsumido(), 0.001);
    }

    @Test
    public void testBuscarClientePorCedula() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Maria", "0987654321");

        Cliente cliente = negocio.buscarClientePorCedula("0987654321");

        assertNotNull(cliente);
        assertEquals("Maria", cliente.getNombre());
    }

    @Test
    public void testBuscarClientePorCedulaInexistente() {
        NegocioMejorado negocio = new NegocioMejorado();

        Cliente cliente = negocio.buscarClientePorCedula("0000000000");

        assertNull(cliente);
    }

    @Test
    public void testBuscarClientePorCodigo() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Carlos", "1234567890");
        negocio.registrarCliente("Maria", "0987654321");

        Cliente cliente = negocio.buscarClientePorCodigo(102);

        assertNotNull(cliente);
        assertEquals("Maria", cliente.getNombre());
        assertEquals(102, cliente.getCodigo());
    }

    @Test
    public void testBuscarClientePorCodigoInexistente() {
        NegocioMejorado negocio = new NegocioMejorado();

        Cliente cliente = negocio.buscarClientePorCodigo(999);

        assertNull(cliente);
    }

    @Test
    public void testRegistrarConsumo() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Pedro", "1122334455");

        Cliente cliente = negocio.buscarClientePorCodigo(101);

        negocio.registrarConsumo(cliente, 5.50);

        assertEquals(5.50, cliente.getTotalConsumido(), 0.001);
    }

    @Test
    public void testConsultarValorVendido() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Carlos", "1234567890");
        negocio.registrarCliente("Maria", "0987654321");

        Cliente cliente1 = negocio.buscarClientePorCodigo(101);
        Cliente cliente2 = negocio.buscarClientePorCodigo(102);

        negocio.registrarConsumo(cliente1, 5.50);
        negocio.registrarConsumo(cliente2, 7.25);

        assertEquals(12.75, negocio.consultarValorVendido(), 0.001);
    }

    @Test
    public void testRecuperarMaquinaInexistente() {
        NegocioMejorado negocio = new NegocioMejorado();

        Maquina maquina = negocio.recuperarMaquina("M-999");

        assertNull(maquina);
    }

    @Test
    public void testAgregarMaquina() {
        NegocioMejorado negocio = new NegocioMejorado();

        boolean resultado = negocio.agregarMaquina(
                "Pilsener",
                "Cerveza artesanal",
                0.02
        );

        assertTrue(resultado);
        assertEquals(1, negocio.getMaquinas().size());
    }

    @Test
    public void testCargarMaquinasSinMaquinas() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.cargarMaquinas();

        assertTrue(negocio.getMaquinas().isEmpty());
    }
}
