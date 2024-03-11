package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
  private Celda celda1;
  private Celda celda2;
  private Celda celda3;
  private Celda celda4;
  private double saldo;
  
  public void configurarMaquina(String codigo1,String codigo2,String codigo3,String codigo4) {
	  celda1=new Celda(codigo1);
	  celda2=new Celda(codigo2);
	  celda3=new Celda(codigo3);
	  celda4=new Celda(codigo4);
  }
  
  public void mostrarConfiguracion() {
	  System.out.println("CELDA 1:"+celda1.getCodigo()+
			  "\nCELDA 2:"+celda2.getCodigo()+
			  "\nCELDA 3:"+celda3.getCodigo()+
			  "\nCELDA 4:"+celda4.getCodigo());
  }
  
  
  public Celda buscarCelda(String codigo) {
	  Celda celdaEcontrada=null;
	  if (celda1.getCodigo().equalsIgnoreCase(codigo)) {
		  celdaEcontrada=celda1;
	} else if (celda2.getCodigo().equalsIgnoreCase(codigo)){
		  celdaEcontrada=celda2;
	}else if (celda3.getCodigo().equalsIgnoreCase(codigo)){
		  celdaEcontrada=celda3;
	}else if (celda4.getCodigo().equalsIgnoreCase(codigo)){
		  celdaEcontrada=celda4;
	}
	  return celdaEcontrada;
  }
  
  
  
  
  public void cargarProducto(Producto producto,String codigo, int stock) {
	  Celda celdaRecuperada=buscarCelda(codigo);
	  celdaRecuperada.ingresarProducto(producto, stock);
  }
  
  public void mostrarProductos() {
	  System.out.println("******************CELDA "+celda1.getCodigo()+" \nstock: "+celda1.getStock()+"\n"+((celda1.getProducto()!=null)?celda1.getProducto().toString():"La celda no tiene producto!!!")+
			  "\n******************CELDA "+celda2.getCodigo()+" \nstock: "+celda2.getStock()+"\n"+((celda2.getProducto()!=null)?celda2.getProducto().toString():"La celda no tiene producto!!!")+
			  "\n******************CELDA "+celda3.getCodigo()+" \nstock: "+celda3.getStock()+"\n"+((celda3.getProducto()!=null)?celda3.getProducto().toString():"La celda no tiene producto!!!")+
			  "\n******************CELDA "+celda4.getCodigo()+" \nstock: "+celda4.getStock()+"\n"+((celda4.getProducto()!=null)?celda4.getProducto().toString():"La celda no tiene producto!!!")+
			  "\nSaldo: "+saldo);
  }
  
  
  public Producto buscarProductoEnCelda(String codigo) {
	  Producto celdaEcontrada=null;
	  if (celda1.getCodigo().equalsIgnoreCase(codigo)) {
		  celdaEcontrada=celda1.getProducto();
	} else if (celda2.getCodigo().equalsIgnoreCase(codigo)){
		  celdaEcontrada=celda2.getProducto();
	}else if (celda3.getCodigo().equalsIgnoreCase(codigo)){
		  celdaEcontrada=celda3.getProducto();
	}else if (celda4.getCodigo().equalsIgnoreCase(codigo)){
		  celdaEcontrada=celda4.getProducto();
	}
	  return celdaEcontrada;
  }
  
  
  public double consultarPrecio(String codigo) {
	  double celdaEcontrada=0;
	  if (celda1.getCodigo().equalsIgnoreCase(codigo)) {
		  celdaEcontrada=celda1.getProducto().getPrecio();
	} else if (celda2.getCodigo().equalsIgnoreCase(codigo)){
		  celdaEcontrada=celda2.getProducto().getPrecio();
	}else if (celda3.getCodigo().equalsIgnoreCase(codigo)){
		  celdaEcontrada=celda3.getProducto().getPrecio();
	}else if (celda4.getCodigo().equalsIgnoreCase(codigo)){
		  celdaEcontrada=celda4.getProducto().getPrecio();
	}
	  return celdaEcontrada;
  }
  
  public Celda buscarCeldaProducto(String codigoProducto) {
	  Celda celdaEcontrada=null;
	  if (celda1.getProducto()!=null&&celda1.getProducto().getCodigo().equalsIgnoreCase(codigoProducto)) {
		  celdaEcontrada=celda1;
	} else if (celda2.getProducto()!=null&& celda2.getProducto().getCodigo().equalsIgnoreCase(codigoProducto)){
		  celdaEcontrada=celda2;
	}else if (celda3.getProducto()!=null&&celda3.getProducto().getCodigo().equalsIgnoreCase(codigoProducto)){
		  celdaEcontrada=celda3;
	}else if (celda4.getProducto()!=null&&celda4.getProducto().getCodigo().equalsIgnoreCase(codigoProducto)){
		  celdaEcontrada=celda4;
	}
	  return celdaEcontrada;
  }
  
  
  public void incrementarProductos(String codigoProducto,int stock) {
	 
	  Celda celdaEncontrada=buscarCeldaProducto(codigoProducto);
	  int cantidadActual=celdaEncontrada.getStock();
	  celdaEncontrada.setStock(cantidadActual+stock);
  }
  
  
  public void vender (String codigo) {
	  Celda celdaRecuperada=buscarCelda(codigo);
	 int cantidadActual= celdaRecuperada.getStock();
	 celdaRecuperada.setStock(cantidadActual-1);
	 
	 this.saldo+=celdaRecuperada.getProducto().getPrecio();
	 
	 this.mostrarProductos();
	
  }
  
  
  public double venderConCambio(String codigo,double valorIngresado) {
	  double cambio=0;
	  Celda celdaRecuperada=buscarCelda(codigo);
		 int cantidadActual= celdaRecuperada.getStock();
		 celdaRecuperada.setStock(cantidadActual-1);
		 
		 this.saldo+=celdaRecuperada.getProducto().getPrecio();
		 cambio=valorIngresado-celdaRecuperada.getProducto().getPrecio();
	  return cambio;
  }
}
