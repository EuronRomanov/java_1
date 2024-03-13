package com.cmc.evaluacion.servicios;

import java.util.ArrayList;
import java.util.HashMap;

import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;

public class Banco {
	
	
private ArrayList<Prestamo>prestamos=null;
private ArrayList<Cliente>clientes=new ArrayList<>();


private HashMap<String, ArrayList<Prestamo>> cuentas=new  HashMap<String, ArrayList<Prestamo>>();

public Cliente buscarCliente(String cedula) {
	Cliente clienteEncontrado=null;
	for (Cliente cliente : clientes) {
		if (cliente.getCedula().equals(cedula)) {
			clienteEncontrado=cliente;
		}
	}
	
	return clienteEncontrado;
			
	
}

public void registrarCliente(Cliente cliente) {
	
	if (buscarCliente(cliente.getCedula())==null) {
		clientes.add(cliente);
		
	}else {
		System.out.println("Cliente ya existe :"+cliente.getCedula());
	}
	
}


public void asignarPrestamo(String cedula,Prestamo prestamo) {
	
	Cliente cliente=buscarCliente(cedula);
	
	
	if (cliente!=null) {
		
		CalculadoraAmortizacion.generarTabla(prestamo);
		
		//System.out.println(cedula);
		//prestamos.add(prestamo);
		if (cuentas.containsKey(cedula)) {
			cuentas.get(cedula).add(prestamo);
		}else {
			prestamos=new ArrayList<>();
			prestamos.add(prestamo);
			cuentas.put(cedula, prestamos);
		}
		
	}else {
		System.out.println("No es cliente del banco");
	}
	
}


public ArrayList<Prestamo> buscarPrestamos(String cedula){
	ArrayList<Prestamo> tmp=null;
	if (buscarCliente(cedula)!=null) {
		
		tmp=cuentas.get(cedula);
	}
	
return tmp;
}


public ArrayList<Prestamo> getPrestamos() {
	return prestamos;
}
public ArrayList<Cliente> getClientes() {
	return clientes;
}





}
