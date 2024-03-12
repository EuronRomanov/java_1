package com.cartas.test;

import java.util.ArrayList;

import com.cartas.entidades.Carta;
import com.cartas.entidades.Naipe;
import com.cartas.servicios.Juego;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <String > jugadores=new ArrayList();
		for (int i = 0; i < 5; i++) {
			jugadores.add(""+i);
		}
Juego juego=new Juego(jugadores );

juego.entregarCartas(5); // Entregar 5 cartas a cada jugador

// Mostrar las cartas de cada jugador
for (int i = 0; i < juego.getCartasJugadores().size(); i++) {
    System.out.println("Cartas del jugador " + jugadores.get(i) + ": " + juego.getCartasJugadores().get(i).size());
    
    for (Carta carta: juego.getCartasJugadores().get(i)) {
		System.out.println(carta.getNumero().getNumeroCarta());
	}
}


	}

}
