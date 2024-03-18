package com.krakedev.entidades;

public class Gato extends Animal {

	@Override
	public void dormir() {
		// TODO Auto-generated method stub
		System.out.println("Gato está durmiendo");
	}

	public void maullar() {
		System.out.println("maullar");
	}
	public void maullar(String adjetivo) {
		System.out.println("Gato maullando "+ adjetivo);
	}
}
