package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;

public class CalculadoraAmortizacion {

	
public static  double calcularCuota(Prestamo prestamo) {
	double cuota=0;
	double i=(prestamo.getInteres()/12)/100;
	cuota=(prestamo.getMonto()*i)/(1-Math.pow((1+i), (-1*prestamo.getPlazo())));
	return Utilitario.redondear(cuota);
}

public static void generarTabla(Prestamo prestamo) {
	double valorCuota=calcularCuota(prestamo);
	Cuota cuota=new Cuota(1);
	cuota.setCuota(valorCuota);
	
	prestamo.getCuotas()[0]=new Cuota(1);
	prestamo.getCuotas()[0].setCuota(valorCuota);
	prestamo.getCuotas()[0].setInicio(prestamo.getMonto());
	

	for (int i = 1; i < prestamo.getCuotas().length; i++) {
	

	
	prestamo.getCuotas()[i]=new Cuota(i+1);
	calcularValoresCuota(prestamo.getInteres(),prestamo.getCuotas()[i-1],prestamo.getCuotas()[i]);

		
	}
	
	
	calcularValoresCuota(prestamo.getInteres(),prestamo.getCuotas()[prestamo.getCuotas().length-1],null);
	
	prestamo.getCuotas()[prestamo.getCuotas().length-1].setSaldo(0);

	
}

private static  void calcularValoresCuota(double interes, Cuota cuota, Cuota cuota2) {
	// TODO Auto-generated method stub
	double intereses=cuota.getInicio()*(((interes)/12.0)/100.0);
	double capital=cuota.getCuota()-intereses;
	double saldo=cuota.getInicio()-capital;
	cuota.setInteres(intereses);
	cuota.setAbonoCapital(capital);
	cuota.setSaldo(saldo);
	
	//cuota2=new Cuota(cuota.get);
	
	if (cuota2!=null) {
		cuota2.setInicio(saldo);
		cuota2.setCuota(cuota.getCuota());
	}
	
	
}

public static  void mostrarTabla(Prestamo prestamo) {
	for (int i = 0; i < prestamo.getCuotas().length; i++) {
		prestamo.getCuotas()[i].mostrarPrestamo();
	}
}
}
