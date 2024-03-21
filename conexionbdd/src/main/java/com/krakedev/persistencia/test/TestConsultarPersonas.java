package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestConsultarPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	ArrayList<Persona> personas=AdminPersonas.buscarPorNombre("a");
	
	for (Persona persona : personas) {
		System.out.println(persona);
	}
} catch (Exception e) {
	// TODO: handle exception
}
	}

}
