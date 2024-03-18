package com.krakedev.test;

import com.krakedev.entidades.Cuenta;
import com.krakedev.entidades.Persona;

public class TestPersona {
	public static void main(String[] args) {
Cuenta cuenta=new Cuenta("1105665654",123.56);
System.out.println(cuenta);
System.out.println(cuenta.toString());

Persona p=new Persona("1714616123","Julian");
System.out.println(p);
System.out.println(p.toString());
	}
}
