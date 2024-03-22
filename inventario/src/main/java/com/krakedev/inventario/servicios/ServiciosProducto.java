package com.krakedev.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.entidades.Producto;



@Path("productos")
public class ServiciosProducto {

	
	@Path("insertar")
	 @POST
	@Consumes(MediaType.APPLICATION_JSON)
	 public void insertar(Producto producto) {
		 System.out.println(">>>>>>>"+producto);
	 }
	
	@Path("actualizar")
	 @PUT
	@Consumes(MediaType.APPLICATION_JSON)
	 public void actualizr(Producto producto) {
		 System.out.println("Actualizando>>>>>>>"+producto);
	 }
	
	@Path("consultar")
	 @GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Producto> buscar() {
		ArrayList<Producto> productos=new ArrayList<Producto>();
			Categoria categoria1=new Categoria(1,"Lacteo");
			Categoria categoria2=new Categoria(2,"Gaseosa");
			Categoria categoria3=new Categoria(3,"Productos Limpieza");
			
			Producto producto1=new Producto("1234","Leche parmalac",categoria1,1.09,234);
			Producto producto2=new Producto("1305","Cocacola",categoria2,1.50,60);
			Producto producto3=new Producto("1205","Papel Higienico",categoria3,2,103);
			productos.add(producto1);
			productos.add(producto2);
			productos.add(producto3);
			
			return productos;
		}

	
	
}
