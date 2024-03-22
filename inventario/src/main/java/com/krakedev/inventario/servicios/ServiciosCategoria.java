package com.krakedev.inventario.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.entidades.Producto;

@Path("categorias")
public class ServiciosCategoria {
	@Path("insertar")
	 @POST
	@Consumes(MediaType.APPLICATION_JSON)
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public Categoria insertar(Categoria categoria) {
		System.out.println("insertado "+categoria);
		 return categoria;
	 }
}
