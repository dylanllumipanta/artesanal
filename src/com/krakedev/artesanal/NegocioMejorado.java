
package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

    private ArrayList<Maquina> maquinas = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private int ultimoCodigo = 100;

    public ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String generarCodigo() {
        int numero = (int) (Math.random() * 100) + 1;
        return "M-" + numero;
    }

    public boolean agregarMaquina(
            String nombre,
            String descripcion,
            double precioPorML) {

        String codigo = generarCodigo();

        if (recuperarMaquina(codigo) != null) {
            return false;
        }

        Maquina maquina = new Maquina(
                nombre,
                descripcion,
                precioPorML,
                codigo
        );

        maquinas.add(maquina);

        return true;
    }

    public void cargarMaquinas() {
        for (Maquina maquina : maquinas) {
            maquina.llenarMaquina();
        }
    }

    public Maquina recuperarMaquina(String codigo) {
        for (Maquina maquina : maquinas) {
            if (maquina.getCodigo().equals(codigo)) {
                return maquina;
            }
        }

        return null;
    }

    public void registrarCliente(String nombre, String cedula) {
        ultimoCodigo++;

        Cliente cliente = new Cliente(nombre, cedula);
        cliente.setCodigo(ultimoCodigo);

        clientes.add(cliente);
    }

    public Cliente buscarClientePorCedula(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }

        return null;
    }

    public Cliente buscarClientePorCodigo(int codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }

        return null;
    }

    public void registrarConsumo(Cliente cliente, double valor) {
        double totalActual = cliente.getTotalConsumido();
        cliente.setTotalConsumido(totalActual + valor);
    }

    public void consumirCerveza(
            int codigoCliente,
            String codigoMaquina,
            double cantidad) {

        Maquina maquina = recuperarMaquina(codigoMaquina);
        Cliente cliente = buscarClientePorCodigo(codigoCliente);

        if (maquina != null && cliente != null) {
            double valor = maquina.servirCerveza(cantidad);
            registrarConsumo(cliente, valor);
        }
    }

    public double consultarValorVendido() {
        double totalVendido = 0;

        for (Cliente cliente : clientes) {
            totalVendido += cliente.getTotalConsumido();
        }

        return totalVendido;
    }
}
