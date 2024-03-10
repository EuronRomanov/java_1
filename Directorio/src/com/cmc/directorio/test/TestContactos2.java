package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf1=new Telefono("movi","0982342384",20);
		Contacto c1=new Contacto("Pablo","Hernandez",telf1,80);
		
		Telefono telf2=new Telefono("claro","0900342489",5);
		Contacto c2=new Contacto("Juan","Hernandez",telf2,70.5);
		
		AdminContactos ac=new AdminContactos();
		Contacto c=ac.buscarMasPesado(c1, c2);
		
		System.out.println("nombre y apellido: "+c.getNombre()+" "+c.getApellido()+
				" telefono "+c.getTelefono().getNumero() +" operadora: "+c.getTelefono().getOperadora()+
				" peso: "+c.getPeso());
		
		
		System.out.println("Son de la misma operadora "+ac.compararOperadoras(c1, c2));
		
		
		
	}

}
