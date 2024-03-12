package com.cartas.entidades;

import java.util.ArrayList;

public class Naipe {
	
private ArrayList<Numero> numerosPosibles=new ArrayList();
private ArrayList<Carta> cartas=new ArrayList();

public Naipe() {
	numerosPosibles.add(new Numero("A", 11));
	for (int i = 2; i <= 10; i++) {
		numerosPosibles.add(new Numero(String.valueOf(i), i));
	}
	numerosPosibles.add(new Numero("J", 10));
	numerosPosibles.add(new Numero("Q", 10));
	numerosPosibles.add(new Numero("K", 10));
	
	Palos palos=new Palos();
	for (Numero numero : numerosPosibles) {
		cartas.add(new Carta(numero,palos.getCorazonNegro()));
		cartas.add(new Carta(numero,palos.getCorazonRojo()));
		cartas.add(new Carta(numero,palos.getDiamante()));
		cartas.add(new Carta(numero,palos.getTrebol()));
	}
	
}


public ArrayList<Carta> getCartas() {
	return cartas;
}



public ArrayList<Carta> barajar(){
	ArrayList<Carta> auxiliar=new ArrayList();
	int posicion;
	for (int i = 1; i <= 100; i++) {
		 posicion =Random.obtenerPosicion();
		 
		 if (auxiliar.size()==0) {
			 cartas.get(posicion).setEstado("C");
				
				auxiliar.add( cartas.get(posicion));
		} else {
			if (cartas.get(posicion).getEstado().equals("N")) {
				 cartas.get(posicion).setEstado("C");
					
					auxiliar.add( cartas.get(posicion));
			}
		}
	}
	
	
	for (Carta carta : cartas) {
		if (carta.getEstado().equals("N")) {
			 carta.setEstado("C");
				
				auxiliar.add( carta);
		}
	}
	return auxiliar;
}

}
