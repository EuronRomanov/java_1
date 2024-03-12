package com.cartas.test;

import com.cartas.entidades.Random;

public class TestRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int posicion = Random.obtenerPosicion();
		System.out.println("Posicion obtenida : "+ posicion);
		 if (posicion == 0 || posicion == 1) {
	            System.out.println("El método obtenerPosicion ha arrojado 0 o 1.");
	        } else {
	            System.out.println("El método obtenerPosicion no ha arrojado 0 o 1.");
	        }
	}
}
