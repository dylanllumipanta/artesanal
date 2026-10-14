package com.krakedev.negocio.test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestNegocio {
	public static void main(String[] args) {
		
		Maquina nueva = new Maquina("Cerveza club","Cerveza fria",0.02,8000,"M001");
		Negocio negocio1 = new Negocio("mi negocio", nueva);
		
		System.out.println("nombre: " + negocio1.getNombre());
		System.out.println("maquina: " + negocio1.getMaquinaA());
		
		Maquina m1 = negocio1.getMaquinaA();
		double capacidad = m1.getCapacidadMaxima();
	}

}
