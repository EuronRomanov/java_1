package com.krakedev.demo.test;

import com.krakedev.demo.Producto;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Producto producto =new Producto(1,"arroz");
		producto.setDescripcion("quintal");
		producto.setPeso(500.2);
		
		System.out.println("codigo: "+ producto.getCodigo()+
				"nombre : "+ producto.getNombre()+
				"descripcion: "+producto.getDescripcion()+
				"peso: "+ producto.getPeso());
		
	}

}
