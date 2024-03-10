package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf1=new Telefono("movi","098234234",20);
		Telefono telf2=new Telefono("claro","098200034",10);
		Telefono telf3=new Telefono("movi","098211134",30);
		AdminTelefono at=new AdminTelefono();
		int imprimir=at.contarMovi(telf1, telf2, telf3);
		
		System.out.println("numero de telfonos de la operadora movi "+ imprimir);
	}

}
