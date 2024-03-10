package com.cmc.directorio.test;

import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContacto1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf=new Telefono("movi","098234234",20);
		Contacto c=new Contacto("Pablo","Hernandez",telf,64.5);
		
		System.out.println("nombre y apellido: "+c.getNombre()+" "+c.getApellido()+
				" telefono "+c.getTelefono().getNumero() +" operadora: "+c.getTelefono().getOperadora()+
				" peso: "+c.getPeso());
	}

}
