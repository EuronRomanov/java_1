package com.krakedev.persistencia.test;

import java.math.BigDecimal;

import com.krakedev.persistencia.entidades.Producto;
import com.krakedev.persistencia.servicios.AdminProductos;

public class TestActualizarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
		Producto p=new Producto(9, "Leche Vita 1L", new BigDecimal(1.10), 200);
		
		AdminProductos.actualizar(p);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el sistema "+e.getMessage());
		}
	}

}
