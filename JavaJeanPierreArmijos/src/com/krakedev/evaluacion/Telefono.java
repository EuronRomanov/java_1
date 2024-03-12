package com.krakedev.evaluacion;

public class Telefono {
private String numero;
private String tipo;
private String estado;





public Telefono(String numero, String tipo) {
	super();
	this.numero = numero;
	this.tipo = tipo;
	
	if ((numero!=null && tipo!=null && numero.length()==10 && tipo.equals("Movil") || (numero!=null && tipo!=null && numero.length()==7 && tipo.equals("Convencional"))) ) {
		this.estado="C";
	} else {
		this.estado="E";
	}
}


public String getNumero() {
	return numero;
}
public String getTipo() {
	return tipo;
}
public String getEstado() {
	return estado;
}


}
