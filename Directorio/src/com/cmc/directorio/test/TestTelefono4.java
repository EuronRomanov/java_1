package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf1=new Telefono("movi","098234234",20);
		Telefono telf2=new Telefono("claro","098200034",10);
		Telefono telf3=new Telefono("claro","098211134",30);
		Telefono telf4=new Telefono("claro","098211134",50);
		AdminTelefono at=new AdminTelefono();
		int imprimir=at.contarClaro(telf1, telf2, telf3,telf4);
		
		System.out.println("numero de telfonos de la operadora movi "+ imprimir);
	}

}
