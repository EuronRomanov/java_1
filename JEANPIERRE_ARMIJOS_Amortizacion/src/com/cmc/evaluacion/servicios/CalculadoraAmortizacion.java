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
	System.out.println(  "N |" +  "cuota | "  + "Inicio | "
			+  "Interes | "  + "Abo,capital | Saldo" );
	for (int i = 0; i < prestamo.getCuotas().length; i++) {
		prestamo.getCuotas()[i].mostrarPrestamo();
	}
}


public static double calcularCuota2(Prestamo prestamo) {
	double cuota=0;
	double i=(prestamo.getInteres())/100;
	cuota=(prestamo.getMonto()*i)/(1-Math.pow((1-i), (prestamo.getPlazo())));
	return Utilitario.redondear(cuota);
}

public static void generarTabla2(Prestamo prestamo) {
  
	
	
	prestamo.getCuotas()[0]=new Cuota(1);
	prestamo.getCuotas()[0].setInicio(prestamo.getMonto());
	prestamo.getCuotas()[0].setAbonoCapital(prestamo.getMonto()/prestamo.getPlazo());
	
    for (int i = 1; i < prestamo.getPlazo(); i++) {
    	prestamo.getCuotas()[i]=new Cuota(i+1);
    	calcularValoresCuota2(prestamo.getInteres(),prestamo.getCuotas()[i-1],prestamo.getCuotas()[i]);
    }
    calcularValoresCuota2(prestamo.getInteres(),prestamo.getCuotas()[prestamo.getCuotas().length-1],null);
    
}

private static  void calcularValoresCuota2(double interes, Cuota cuota, Cuota cuota2) {
	// TODO Auto-generated method stub
	double intereses=cuota.getInicio()*(((interes))/100.0);
	double capital=cuota.getAbonoCapital();
	double saldo=cuota.getInicio()-capital;
	double valorCuota=intereses+capital;
	cuota.setInteres(intereses);
	cuota.setCuota(valorCuota);
	cuota.setSaldo(saldo);
	
	//cuota2=new Cuota(cuota.get);
	
	if (cuota2!=null) {
		cuota2.setInicio(cuota.getSaldo());
		cuota2.setAbonoCapital(capital);
		
	}
	
	
}

public static void pagar(Prestamo prestamo,double pago) {
	double diferencia;
	for (int i = 0; i < prestamo.getPlazo(); i++) {
		double cuota=prestamo.getCuotas()[i].getCuota()  ;
		
		
		if (cuota>pago) {
			pago-=cuota;
			prestamo.getCuotas()[i].setPediente(Math.abs(pago));
			break;
		}else if(cuota<pago) {
			prestamo.getCuotas()[i].setPediente(0);
			prestamo.getCuotas()[i].setPagado(true);
			pago=Utilitario.redondear(pago-cuota);
		}else if(cuota==pago){
			prestamo.getCuotas()[i].setPediente(0);
			prestamo.getCuotas()[i].setPagado(true);
			break;
		}
		
			
		
		
		
		
		
	}
}



public static  void mostrarTabla2(Prestamo prestamo) {
	System.out.println(  "N |" +  "cuota | "  + "Inicio | "
			+  "Interes | "  + "Abo,capital | Saldo" );
	for (int i = 0; i < prestamo.getCuotas().length; i++) {
		prestamo.getCuotas()[i].mostrarPrestamoTotal();
	}
}


}
