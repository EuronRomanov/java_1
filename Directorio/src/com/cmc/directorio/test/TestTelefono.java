package com.cmc.directorio.test;

import com.cmc.directorio.entidades.Telefono;

public class TestTelefono {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Telefono telf=new Telefono("movi","09941234123",10);

System.out.println("operadora: "+telf.getOperadora()+
		" numero: "+telf.getNumero()+
		" codigo: "+telf.getCodigo()+
		"  tiene whatsapp: "+telf.isTieneWhatsapp());

	}

}
