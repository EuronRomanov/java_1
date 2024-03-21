package com.krakedev.persistencia.test;

import java.math.BigDecimal;

import com.krakedev.persistencia.entidades.Producto;
import com.krakedev.persistencia.servicios.AdminProductos;

public class TestInsertarProducto {

	public static void main(String[] args) {
					// TODO Auto-generated method stub
			try {
			Producto p=new Producto(9, "Leche Vita", new BigDecimal(0.89), 1000);
			
			AdminProductos.insertar(p);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error en el sistema "+e.getMessage());
			}
	}

}
