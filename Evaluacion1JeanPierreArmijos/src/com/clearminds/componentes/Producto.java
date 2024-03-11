package com.clearminds.componentes;

public class Producto {

	private String nombre;
	private double precio;
	private String codigo;
	
	
	
	
	
	public Producto(String codigo,String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.codigo = codigo;
	}

	public void incrementarPrecio(int porcentajeIncremento) {
		double aumento=(porcentajeIncremento/100.0)*precio;
		this.precio+=aumento;
	}

	public void disminuirPrecio(double descuento) {
		
		this.precio-=descuento;
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

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Nombre Producto:" + nombre + " Precio:" + precio ;
	}
	
	
	
	
}
