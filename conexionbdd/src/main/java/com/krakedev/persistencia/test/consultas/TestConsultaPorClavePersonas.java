package com.krakedev.persistencia.test.consultas;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestConsultaPorClavePersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try {
		Persona p=AdminPersonas.buscarPorClave("1703892325");
		System.out.println(p);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
	}

}
