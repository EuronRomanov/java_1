package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Directorio {
  private ArrayList<Contacto> contactos=new ArrayList();
  private Date fechaModificacion;
  private  ArrayList<Contacto> correctos=new ArrayList();
  private  ArrayList<Contacto> incorrectos=new ArrayList();
  
  public boolean agregarContacto(Contacto contacto) {
	  
	  if (buscarPorCedula(contacto.getCedula())==null) {
		  contactos.add(contacto);
		  this.fechaModificacion=new Date();
		  return true;
	}else {
		  return false;
	}
	  
	 
  }
  
  
  
  public Contacto buscarPorCedula(String cedula) {
	  Contacto temp=null;
	  for (Contacto contacto : contactos) {
	if (contacto.getCedula().equals(cedula)) {
		temp=contacto;
	}
	}
	  
	  return temp;
  }
  
  public String consultarUltimaModificacion () {
	  SimpleDateFormat formateador = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
	  return formateador.format(fechaModificacion);
  }
  
  public int contarPerdidos() {
	  int i=0;
	  for (Contacto contacto : contactos) {
		if (contacto.getDireccion()==null) {
			i++;
		}
	}
	  
	  return i;
  }
  
  public int contarFijos() {
	  int i=0;
	  for (Contacto contacto : contactos) {
		  ArrayList<Telefono> telefonos=contacto.getTelefonos();
		  for (Telefono telefono : telefonos) {
			  if (telefono.getEstado().equals("C") &&
					  telefono.getTipo().equalsIgnoreCase("Convencional")  ) {
					i++;
				}
		}
		
	}
	  
	  return i;
  }
  
  public void depurar() {
	  for (Contacto contacto : contactos) {
			if (contacto.getDireccion()==null) {
				incorrectos.add(contacto);
			}else {
				correctos.add(contacto);
			}
		}
	  
	  contactos.clear();
  }



public ArrayList<Contacto> getCorrectos() {
	return correctos;
}



public ArrayList<Contacto> getIncorrectos() {
	return incorrectos;
}



public ArrayList<Contacto> getContactos() {
	return contactos;
}
  
  
  
  
  
}
