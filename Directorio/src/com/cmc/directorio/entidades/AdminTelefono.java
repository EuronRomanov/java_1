package com.cmc.directorio.entidades;

public class AdminTelefono {

	
	public void activarMensajeria(Telefono telefono){
		if (telefono.getOperadora().equalsIgnoreCase("movi")) {
			telefono.setTieneWhatsapp(true);
		}
	}
	
	
	public int contarMovi(Telefono telf1, Telefono telf2,Telefono telf3){
		int contador=0;
		
		if (telf1.getOperadora().equalsIgnoreCase("movi")) {
			contador++;
		}
		if (telf2.getOperadora().equalsIgnoreCase("movi")) {
			contador++;
		}
		if (telf3.getOperadora().equalsIgnoreCase("movi")) {
			contador++;
		}
		return contador;
	}
	public int contarClaro(Telefono telf1, Telefono telf2,Telefono telf3,Telefono telf4){
		int contador=0;
		
		if (telf1.getOperadora().equalsIgnoreCase("claro")) {
			contador++;
		}
		if (telf2.getOperadora().equalsIgnoreCase("claro")) {
			contador++;
		}
		if (telf3.getOperadora().equalsIgnoreCase("claro")) {
			contador++;
		}
		if (telf4.getOperadora().equalsIgnoreCase("claro")) {
			contador++;
		}
		return contador;
	}
}
