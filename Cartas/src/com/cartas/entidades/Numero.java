package com.cartas.entidades;

public class Numero {
private String numeroCarta;
private int valor;





public Numero(String numeroCarta, int valor) {
	super();
	this.numeroCarta = numeroCarta;
	this.valor = valor;
}
public void imprimir() {
	System.out.println(this.numeroCarta+"-"+this.valor);
}

public void setNumeroCarta(String numeroCarta) {
	this.numeroCarta = numeroCarta;
}
public void setValor(int valor) {
	this.valor = valor;
}
public String getNumeroCarta() {
	return numeroCarta;
}
public int getValor() {
	return valor;
}


}
