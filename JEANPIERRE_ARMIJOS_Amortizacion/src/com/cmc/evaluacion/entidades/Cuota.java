package com.cmc.evaluacion.entidades;

import com.cmc.evaluacion.servicios.Utilitario;

public class Cuota {
private int numero;
private double cuota;
private double capital;
private double inicio;
private double interes;
private double abonoCapital;
private double saldo;
private boolean pagado=false;
private double pediente;





public Cuota(int numero) {
	super();
	this.numero = numero;
	
}
public double getCuota() {
	return cuota;
}
public void setCuota(double cuota) {
	this.cuota = cuota;
}
public double getCapital() {
	return capital;
}
public void setCapital(double capital) {
	this.capital = capital;
}
public double getInicio() {
	return inicio;
}
public void setInicio(double inicio) {
	this.inicio = inicio;
}
public double getInteres() {
	return interes;
}
public void setInteres(double interes) {
	this.interes = interes;
}
public double getAbonoCapital() {
	return abonoCapital;
}
public void setAbonoCapital(double abonoCapital) {
	this.abonoCapital = abonoCapital;
}
public double getSaldo() {
	return saldo;
}
public void setSaldo(double saldo) {
	this.saldo = saldo;
}


public boolean isPagado() {
	return pagado;
}
public void setPagado(boolean pagado) {
	this.pagado = pagado;
}
public double getPediente() {
	return pediente;
}
public void setPediente(double pediente) {
	this.pediente = pediente;
}
public void mostrarPrestamo() {
	System.out.println(numero + "|" + Utilitario.redondear(cuota) + " | "  +Utilitario.redondear(inicio)  + " | "
			+ Utilitario.redondear(interes) + " | " + Utilitario.redondear(abonoCapital)  + " | " +Utilitario.redondear( saldo)  );
	
}

public void mostrarPrestamoTotal() {
	System.out.println(numero + "|" + Utilitario.redondear(cuota) + " | "  +Utilitario.redondear(inicio)  + " | "
			+ Utilitario.redondear(interes) + " | " + Utilitario.redondear(abonoCapital)  + " | " +Utilitario.redondear( saldo)+ " | "+pagado+ " | "+pediente );
	
}



}
