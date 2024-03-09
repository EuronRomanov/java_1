package clearminds.cuentas;

import java.util.Date;

public class Cuenta {
private String id;
private String tipo="A";
private double saldo=0.0;





public Cuenta(String id) {
	super();
	this.id = id;
	
}




public Cuenta(String id, String tipo, double saldo) {
	super();
	this.id = id;
	this.tipo = tipo;
	this.saldo = saldo;
}


public void imprimir(){
	System.out.println("************************\n"+
"CUENTA\n"+
"************************\n"+
"Numero de Cuenta: "+this.id+
"\nTipo: "+this.tipo+
"\nSaldo: USD "+this.saldo+
"\n************************\n");
}


public void imprimirConMIEstilo(){
	System.out.println("************** Cuenta *************\n"+
"fecha "+new Date().toString()+
"\n---------------- o -----------------"+
"\nNumero de Cuenta: "+this.id+
"\nTipo: "+this.tipo+
"\nSaldo: "+this.saldo);
}




public String getId() {
	return id;
}

public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public double getSaldo() {
	return saldo;
}
public void setSaldo(double saldo) {
	this.saldo = saldo;
}





}
