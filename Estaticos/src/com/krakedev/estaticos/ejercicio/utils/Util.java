package com.krakedev.estaticos.ejercicio.utils;

import java.util.HashMap;

public class Util {
	
	
public static String formatearHora(int hora) {
	String valor="";
	if (0<=hora && hora<10) {
		valor="0"+hora;
	} else {
valor=hora+"";
	}
	
	return valor;
} 

public static String formatearDia(int dia) {
	HashMap<Integer, String> dias=new HashMap<Integer, String>();
	dias.put(0, "Lunes");
	dias.put(1, "Martes");
	dias.put(2, "Miercoles");
	dias.put(3, "Jueves");
	dias.put(4, "Viernes");
	dias.put(5, "Sabado");
	dias.put(6, "Domingo");
	return dias.get(dia);
}


}
