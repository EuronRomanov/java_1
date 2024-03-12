package com.cartas.servicios;

import java.util.ArrayList;

import com.cartas.entidades.Naipe;
import com.cartas.entidades.Carta;

public class Juego {
private Naipe naipe;
private ArrayList<ArrayList<Carta>> cartasJugadores=new ArrayList<>();
private ArrayList<Carta> naipeBarajado;



public Juego( ArrayList<String>  jugadores) {
	naipe=new Naipe();
	naipeBarajado=naipe.barajar();
	
	for (String integer : jugadores) {
		ArrayList<Carta> listaCartas=new ArrayList<Carta>();
		cartasJugadores.add(listaCartas);
	}

}

public Juego() {
	naipe=new Naipe();
	naipeBarajado=naipe.barajar();
}

public void entregarCartas(int cartasPorJugador) {
	
	/*
	for (int i = 1; i <= naipeBarajado.size(); i+=cartasPorJugador) {
		for (int j = (i-1); j < (i+cartasPorJugador) ; j++) {
			for (ArrayList<Carta> arrayList : cartasJugadores) {
				arrayList.add(naipeBarajado.get(j));
			}
		}
	}
	*/
	
	int contador =0;
	for (int i = 0; i < cartasPorJugador; i++) {
		for (ArrayList<Carta> cartaJugador : cartasJugadores) {
			cartaJugador.add(naipeBarajado.get(contador++));
		}
		contador+=cartasPorJugador;
	}
	
	/* int jugadorActual = 0;
     int cartaActual = 0;
     while (cartaActual < cartasPorJugador * cartasJugadores.size()) {
         cartasJugadores.get(jugadorActual).add(naipeBarajado.get(cartaActual));
         cartaActual++;
         jugadorActual = (jugadorActual + 1) % cartasJugadores.size();
     }*/
	
}

public ArrayList<ArrayList<Carta>> getCartasJugadores() {
	return cartasJugadores;
}

public int devolverTotal(int i) {
	ArrayList<Carta> cartas=this.cartasJugadores.get(i);
	int total=0;
	
	for (Carta carta : cartas) {
		total+=carta.getNumero().getValor();
	}
	return total;
}

public String determinarGanador() {
	int idGanador=0;
	int sumaGanador=devolverTotal(0);
	for (int i = 1; i < cartasJugadores.size(); i++) {
		int total=devolverTotal(i);
		if (sumaGanador<=total) {
			idGanador=i;
			sumaGanador=total;
		}
	}
	
	
	return "jugador "+(idGanador+1);
}





}
