package com.krakedev.estaticos.ejercicio.test;

import java.util.ArrayList;

import com.krakedev.estaticos.ejercicio.entidades.Alarma;
import com.krakedev.estaticos.ejercicio.logica.AdminAlarmas;
import com.krakedev.estaticos.ejercicio.utils.DiasSemana;

public class TestAlarmas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alarma alarma1=new Alarma(DiasSemana.LUNES,5,45);
		Alarma alarma2=new Alarma(DiasSemana.LUNES,1,20);
		Alarma alarma3=new Alarma(DiasSemana.MARTES,4,15);
		Alarma alarma4=new Alarma(DiasSemana.MIERCOLES,1,25);
		Alarma alarma5=new Alarma(DiasSemana.JUEVES,12,30);
		Alarma alarma6=new Alarma(DiasSemana.VIERNES,13,5);
		Alarma alarma7=new Alarma(DiasSemana.SABADO,9,60);
		Alarma alarma8=new Alarma(DiasSemana.DOMINGO,8,50);
		Alarma alarma9=new Alarma(DiasSemana.DOMINGO,4,5);
		
		AdminAlarmas admin=new AdminAlarmas();

		admin.agregarAlarma(alarma1);
		admin.agregarAlarma(alarma2);
		admin.agregarAlarma(alarma3);
		admin.agregarAlarma(alarma4);
		admin.agregarAlarma(alarma5);
		admin.agregarAlarma(alarma6);
		admin.agregarAlarma(alarma7);
		admin.agregarAlarma(alarma8);
		admin.agregarAlarma(alarma9);
		
		 ArrayList<Alarma> alarmas=admin.getAlarmas();
		 for (Alarma alarma : alarmas) {
			System.out.println(alarma.toString());
		}

	}

}
