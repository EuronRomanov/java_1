package com.krakedev.presistencia.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.servicios.AdminPersonas;

public class Convertidor {
private static final String FORMATO_FECHA="yyyy/MM/dd";
private static final String FORMATO_HORA="hh:mm";
private static final Logger LOGGER=LogManager.getLogger( Convertidor.class);

public static Date convertirFecha(String fechaStr) throws Exception {
SimpleDateFormat sdf=new SimpleDateFormat(FORMATO_FECHA);
Date fechaDate=null;
try {
	LOGGER.trace("Convirtiendo fecha"+fechaStr);
	 fechaDate=sdf.parse(fechaStr);
	 LOGGER.trace("Converido fecha"+fechaDate);
} catch (ParseException e) {
	LOGGER.error("No es el formato correcto"+fechaStr, e);
	// TODO: handle exception
	e.printStackTrace();
	throw new Exception("La fecha no tiene el formato correcto");
}
	return fechaDate;
}

public static Date convertirHora(String fechaStr) throws Exception {
SimpleDateFormat sdf=new SimpleDateFormat(FORMATO_HORA);
Date fechaDate=null;
try {
	 fechaDate=sdf.parse(fechaStr);
} catch (ParseException e) {
	// TODO: handle exception
	e.printStackTrace();
	throw new Exception("La fecha no tiene el formato correcto");
}
	return fechaDate;
}


public static Date convertirHora2(String fechaStr) throws Exception {
SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
Date fechaDate=null;
try {
	 fechaDate=sdf.parse(fechaStr);
} catch (ParseException e) {
	// TODO: handle exception
	e.printStackTrace();
	throw new Exception("La fecha no tiene el formato correcto");
}
	return fechaDate;
}


public static String formatoHora(Date fecha) {
SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
String fechaDate="";
try {
	 fechaDate=sdf.format(fecha);
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	//throw new Exception("La fecha no tiene el formato correcto");
}
	return fechaDate;
}

}
