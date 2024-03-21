package com.krakedev.persistencia.test.consultas;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class testCnsultaPorFechaPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Persona> personas=AdminPersonas.buscarPorFecha("2020/12/23");
			
			for (Persona persona : personas) {
				System.out.println(persona);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
