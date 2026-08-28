package com.krakedev.artesanal;

public class Maquina {

    private String nombreCerveza;
    private String descripcion;
    private double precioPorML;
    private double capacidadMaxima;
    private double cantidadActual;
    private String codigo;

    public Maquina(String nombreCerveza, String descripcion, double precioPorML,
            double capacidadMaxima, String codigo) {

        this.nombreCerveza = nombreCerveza;
        this.descripcion = descripcion;
        this.precioPorML = precioPorML;
        this.capacidadMaxima = capacidadMaxima;
        this.codigo = codigo;
        this.cantidadActual = 0;
    }

    public Maquina(String nombreCerveza, String descripcion, double precioPorML,
            String codigo) {

        this.nombreCerveza = nombreCerveza;
        this.descripcion = descripcion;
        this.precioPorML = precioPorML;
        this.capacidadMaxima = 10000;
        this.codigo = codigo;
        this.cantidadActual = 0;
    }

    public String getNombreCerveza() {
        return nombreCerveza;
    }

    public void setNombreCerveza(String nombreCerveza) {
        this.nombreCerveza = nombreCerveza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioPorML() {
        return precioPorML;
    }

    public void setPrecioPorML(double precioPorML) {
        this.precioPorML = precioPorML;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void imprimir() {

        String mensaje;

        mensaje = "Código: " + codigo
                + ", Nombre cerveza: " + nombreCerveza
                + ", Descripción: " + descripcion
                + ", Precio por Ml: " + precioPorML
                + ", Capacidad Máxima: " + capacidadMaxima
                + ", Cantidad Actual: " + cantidadActual;

        System.out.println(mensaje);
    }

    public void llenarMaquina() {

        this.cantidadActual = this.capacidadMaxima - 200;
    }

    public boolean recargarCerveza(double cantidad) {

        double limitePermitido;

        limitePermitido = capacidadMaxima - 200;

        if (cantidadActual + cantidad <= limitePermitido) {

            cantidadActual = cantidadActual + cantidad;
            return true;

        } else {

            return false;
        }
    }

    public double servirCerveza(double cantidad) {

        if (cantidadActual >= cantidad) {

            cantidadActual = cantidadActual - cantidad;

            double valor;

            valor = cantidad * precioPorML;

            return valor;

        } else {

            return 0;
        }
    }
}