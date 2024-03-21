package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.presistencia.util.Convertidor;

public class TestEliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p=new Persona();
		try {
			p.setCedula("1803892376");
			
			AdminPersonas.eliminar(p);
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error en el sistema "+e.getMessage());
		}
		
	}

}
