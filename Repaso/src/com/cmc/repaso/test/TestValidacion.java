package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Validacion;

public class TestValidacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Validacion validacion=new Validacion();


System.out.println("El mosnto es mayor a cero: "+ validacion.validarMonto(200));
System.out.println("El mosnto es mayor a cero: "+ validacion.validarMonto(0));

	}

}
