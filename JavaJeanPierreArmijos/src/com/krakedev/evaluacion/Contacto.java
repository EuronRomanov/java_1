package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Contacto {
	
private String cedula;
private String nombre;
private String apellido;
private Direccion direccion;
private ArrayList<Telefono> telefonos=new ArrayList<>();


public Contacto(String cedula, String nombre, String apellido) {
	super();
	this.cedula = cedula;
	this.nombre = nombre;
	this.apellido = apellido;
}


public String getCedula() {
	return cedula;
}


public void setCedula(String cedula) {
	this.cedula = cedula;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getApellido() {
	return apellido;
}


public void setApellido(String apellido) {
	this.apellido = apellido;
}


public Direccion getDireccion() {
	return direccion;
}


public void setDireccion(Direccion direccion) {
	this.direccion = direccion;
}




public ArrayList<Telefono> getTelefonos() {
	return telefonos;
}


public void setTelefonos(ArrayList<Telefono> telefonos) {
	this.telefonos = telefonos;
}



public void imprimir() {
	System.out.println("***"+nombre +" "+apellido+"***\n"+
((direccion==null)?"No tiene asociada una dirección":"Dirección: "+direccion.getCallePrincipal()+" y "+direccion.getCalleSecundaria()));
	//System.out.println("Cédula: " + cedula + "\n Nombre: " + nombre + "\n Apellido:" + apellido + "\n Direccion:\n" + direccion+"\n");
}


public void agregarTelefono(Telefono telefono) {
	telefonos.add(telefono);
	
}
public void mostrarTelefonos() {
	System.out.println("Teléfonos con estado 'C':");
	for (Telefono telefono : telefonos) {
		if (telefono.getEstado().equalsIgnoreCase("C")) {
			System.out.println("Número: "+telefono.getNumero()+", Tipo: "+telefono.getTipo());
		}
	}
}

public ArrayList<Telefono>  recuperarIncorrectos(){
	ArrayList<Telefono> temp=new ArrayList<Telefono>();
	for (Telefono telefono : telefonos) {
		
		if (telefono.getEstado().equalsIgnoreCase("E")) {
			
			temp.add(telefono);
		}
	}
	return temp;
}

}
