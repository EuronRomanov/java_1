package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Estudiante;

public class TestEstudiante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Estudiante estudiante1=new Estudiante("Juan");
		
		estudiante1.calificar(7);
Estudiante estudiante2=new Estudiante("Pedro");
		
		estudiante2.calificar(8);
		
		System.out.println("Estudiante 1 "+ 
		" Nombre: "+estudiante1.getNombre()+
		" Nota: "+estudiante1.getNota()+
		" Resultado: "+estudiante1.getResultado());
		
		System.out.println("Estudiante 2 "+ 
				"  Nombre: "+estudiante2.getNombre()+
				"  Nota: "+estudiante2.getNota()+
				" Resultado: "+estudiante2.getResultado());
		
	}

}
