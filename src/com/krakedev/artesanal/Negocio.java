package com.krakedev.artesanal;

public class Negocio {

    private String nombre;

    private String ruc;

    private Maquina maquinaA;

    private int UltimoCodigo = 100;

    public Negocio() {

    }

    public Negocio(String nombre, String ruc) {

        this.nombre = nombre;
        this.ruc = ruc;
    }

    public Negocio(String nombre, Maquina maquinaA) {

        this.nombre = nombre;
        this.maquinaA = maquinaA;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getRuc() {

        return ruc;
    }

    public void setRuc(String ruc) {

        this.ruc = ruc;
    }

    public Maquina getMaquinaA() {

        return maquinaA;
    }

    public void setMaquinaA(Maquina maquinaA) {

        this.maquinaA = maquinaA;
    }

    public void asignarCodigoCliente(Cliente cliente) {

        cliente.setCodigo(UltimoCodigo);

        UltimoCodigo++;
    }
    
    public void cargarMaquinaA() {
        maquinaA.llenarMaquina();
    }

    public void consumirCervezaMaquinaA(Cliente cliente, double ml) {
        double valor = maquinaA.servirCerveza(ml);
        cliente.setTotalConsumido(cliente.getTotalConsumido() + valor);
    }
    
    
}

