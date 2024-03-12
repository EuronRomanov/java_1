package com.cartas.entidades;

public class Random {

	public static int obtenerPosicion(){
		int valor=0;
		
		valor=(int)(Math.random()*51)  ;
		return valor;
	}
	
}
