package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.Producto;
import com.krakedev.persistencia.entidades.Venta;
import com.krakedev.persistencia.servicios.AdminVentas;
import com.krakedev.presistencia.util.Convertidor;

public class TestActuallizarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Producto p=new Producto(9, "Leche Vita", new BigDecimal(0.89), 1000);
			Date fechaVenta=Convertidor.convertirFecha("2024/04/23");
			Venta v=new Venta(11,p, fechaVenta,10);
			
			AdminVentas.actualizar(v);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el sistema "+e.getMessage());
		}
	}

}
