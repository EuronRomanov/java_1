package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Producto producto=new Producto("tomates", 50);

System.out.println(producto.getNombre()+" precio "+ producto.getPrecio());

System.out.println("valor escuento "+producto.calcularPrecioPromo(50));
producto.setPrecio(-4);
System.out.println("comprobar si el precio es negativo "+producto.getPrecio());

producto.setPrecio(100);
System.out.println("comprobar si el precio es negativo "+producto.getPrecio());
	}

}
