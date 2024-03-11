package com.clearminds.maquina;

import java.util.ArrayList;
import java.util.Iterator;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {

	private ArrayList<Celda> celdas=new ArrayList<>(); 
	private double saldo;
	
	
	public void agregarCelda(Celda celda) {
		
		celdas.add(celda);
	}

	public void mostrarConfiguracion() {
		// TODO Auto-generated method stub
		for (int i = 0; i < celdas.size(); i++) {
			System.out.println("Celda"+(i+1)+":"+celdas.get(i).getCodigo());
		}
	}
	
	
	public Celda buscarCelda(String codigo) {
		Celda celdaEncontrada=null;
		for (int i = 0; i < celdas.size(); i++) {
			
			
			if (celdas.get(i).getCodigo().equals(codigo)) {
				celdaEncontrada=celdas.get(i);
				
				break;
			}
		}
		
		return celdaEncontrada;
	}
	
	 public void cargarProducto(Producto producto,String codigo, int stock) {
		  Celda celdaRecuperada=buscarCelda(codigo);
		  celdaRecuperada.ingresarProducto(producto, stock);
	  }
	 
	 
	 public void mostrarProductos() {
		 for (Celda celda : celdas) {
			  System.out.println("CELDA "+celda.getCodigo()+" stock: "+celda.getStock()+" "+((celda.getProducto()!=null)?celda.getProducto().toString():"Sin producto asignado"));
		}
		 
		 System.out.println("Saldo: "+saldo);
	 }
	 
	 
	 public Producto buscarProductoEnCelda(String codigo) {
		  Producto celdaEcontrada=null;
		for (Celda celda : celdas) {
			 if (celda.getCodigo().equalsIgnoreCase(codigo)) {
				  celdaEcontrada=celda.getProducto();
			} 
		}
		  
		 
		  return celdaEcontrada;
	  }

	 
	 public double consultarPrecio(String codigo) {
		  double celdaEcontrada=0;
		  
		  for (Celda celda : celdas) {
			  if (celda.getCodigo().equalsIgnoreCase(codigo)) {
				  celdaEcontrada=celda.getProducto().getPrecio();
			} 
		}
		  
		  return celdaEcontrada;
	  }
	 
	 
	 public Celda buscarCeldaProducto(String codigoProducto) {
		  Celda celdaEcontrada=null;
		  
		  for (Celda celda : celdas) {
			  if (celda.getProducto()!=null&&celda.getProducto().getCodigo().equalsIgnoreCase(codigoProducto)) {
				  celdaEcontrada=celda;
			} 
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
	  
	  public   ArrayList<Producto> buscarMenores(double limite) {
		 
		  ArrayList<Producto> productos=new ArrayList();
			 for (Celda celda : celdas) {
				 
				 if (celda.getProducto().getPrecio()<=limite) {
					
					 productos.add(celda.getProducto());

				}
			}
			 
			return productos;
		 }
}
