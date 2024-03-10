package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestActivos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminTelefono at=new AdminTelefono();
		
		
		Telefono telf=new Telefono("movi","098234234",20);
		System.out.println("operadora: "+telf.getOperadora()+
				" numero: "+telf.getNumero()+
				" codigo: "+telf.getCodigo()+
				"  tiene whatsapp: "+telf.isTieneWhatsapp());
		Contacto c=new Contacto("Pablo","Hernandez",telf,64.5);
		at.activarMensajeria(c.getTelefono());
		
		AdminContactos ac=new AdminContactos();
		ac.activarUsuario(c);
		
		System.out.println("nombre y apellido: "+c.getNombre()+" "+c.getApellido()+
				" telefono "+c.getTelefono().getNumero() +" operadora: "+
				c.getTelefono().getOperadora()+
				" codigo: "+c.getTelefono().getCodigo()+
				"  tiene whatsapp: "+c.getTelefono().isTieneWhatsapp()+
				" peso: "+c.getPeso()+
				" activo: "+c.isActivo());
		
		
	}

}
