package com.clearminds.test;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.agregarCelda(new Celda("A1"));
		maquina.agregarCelda(new Celda("A2"));
		maquina.agregarCelda(new Celda("A3"));
		maquina.agregarCelda(new Celda("B1"));
		maquina.agregarCelda(new Celda("B2"));
		maquina.agregarCelda(new Celda("B3"));
		
		
		
		Producto producto1=new Producto("KE34","Papitas",0.85);
		maquina.cargarProducto(producto1, "B1", 4);
		
		Producto producto2=new Producto("D456","Doritos",0.70);
		maquina.cargarProducto(producto2, "A1", 6);
		
		Producto producto3=new Producto("KE34","aceite",5.85);
		maquina.cargarProducto(producto3, "B2", 4);
		
		Producto producto4=new Producto("D456","Arandanos",40.70);
		maquina.cargarProducto(producto4, "A2", 6);
		
		Producto producto5=new Producto("KE34","Jet Precio",0.25);
		maquina.cargarProducto(producto5, "B3", 4);
		
		Producto producto6=new Producto("D456","DeTodito",0.6);
		maquina.cargarProducto(producto6, "A3", 6);
		
		
		ArrayList<Producto> productos=maquina.buscarMenores(0.85);
		
		
		System.out.println("Productos Menores: "+ productos.size());
		for (Producto producto : productos) {
			System.out.println(producto.toString());
		}
		
	}

}
