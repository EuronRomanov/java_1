package com.cmc.directorio.entidades;

public class AdminContactos {

	public Contacto buscarMasPesado(Contacto c1,Contacto c2) {
		if (c1.getPeso()>c2.getPeso()) {
			return c1;
		} else {
			return c2;
		}
	}
	
	
	public boolean compararOperadoras(Contacto c1,Contacto c2) {
		String operadora2=c2.getTelefono().getOperadora();
		String operadora1=c1.getTelefono().getOperadora();
		if (operadora1.equalsIgnoreCase(operadora2)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public void activarUsuario(Contacto c) {
		if (c.getTelefono().isTieneWhatsapp()) {
			c.setActivo(true);
		}
	}
}
