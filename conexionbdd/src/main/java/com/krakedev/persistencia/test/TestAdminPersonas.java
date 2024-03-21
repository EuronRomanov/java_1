package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.presistencia.util.Convertidor;

public class TestAdminPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			EstadoCivil ec=new EstadoCivil("U","Union Libre");
			Persona p=new Persona("1803892370","Maria","Coronel",ec);
			try {
				Date fechaNac=Convertidor.convertirFecha("2019/12/23");
				Date horaNac=Convertidor.convertirHora("09:23");
				p.setFechaNacimiento(fechaNac);
				p.setHoraNacimiento(horaNac);
				p.setEstatura(175.9);
				p.setCantidadAhorrada(new BigDecimal(2204.56));
				p.setNumeroHijos(1);
				
				AdminPersonas.insertar(p);
			} catch (Exception e) {
				// TODO: handle exception
				
				System.out.println("Error en el sistema "+e.getMessage());
			}
			
			
	}

}
