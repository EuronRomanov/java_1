package com.krakedev.persistencia.entidades;

import java.util.Date;

public class Venta {
	private int id_venta;
	private Producto   codigo_producto ;
	private Date  fecha_venta;
	private int  cantidad;
	
	public Venta() {
		super();
	}

	public Venta(int id_venta, Producto codigo_producto, Date fecha_venta, int cantidad) {
		super();
		this.id_venta = id_venta;
		this.codigo_producto = codigo_producto;
		this.fecha_venta = fecha_venta;
		this.cantidad = cantidad;
	}

	public Venta(int id_venta, Producto codigo_producto, Date fecha_venta) {
		super();
		this.id_venta = id_venta;
		this.codigo_producto = codigo_producto;
		this.fecha_venta = fecha_venta;
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public Producto getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Producto codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Date getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Venta [id_venta=" + id_venta + ", codigo_producto=" + codigo_producto + ", fecha_venta=" + fecha_venta
				+ ", cantidad=" + cantidad + "]";
	}

	
	
}
