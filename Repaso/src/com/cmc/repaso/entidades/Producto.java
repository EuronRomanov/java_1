package com.cmc.repaso.entidades;

public class Producto {
private String nombre;
private double precio;


public Producto(String nombre, double precio) {
	super();
	this.nombre = nombre;
	this.precio = precio;
}


public void setPrecio(double precio) {
	if (precio<0) {
		this.precio = precio*-1;
	} else {
		this.precio = precio;
	}
	
}


public  double calcularPrecioPromo(double descuento) {
	return (this.precio)-(this.precio*(descuento/100.0));
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public double getPrecio() {
	return precio;
}




}
