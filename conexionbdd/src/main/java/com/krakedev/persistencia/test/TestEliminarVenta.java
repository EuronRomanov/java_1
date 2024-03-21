package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.Producto;
import com.krakedev.persistencia.entidades.Venta;
import com.krakedev.persistencia.servicios.AdminVentas;
import com.krakedev.presistencia.util.Convertidor;

public class TestEliminarVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Venta v=new Venta();
			v.setId_venta(10);
			
			AdminVentas.eliminar(v);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el sistema "+e.getMessage());
		}
	}

}
