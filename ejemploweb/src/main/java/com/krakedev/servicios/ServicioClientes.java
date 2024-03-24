package com.krakedev.servicios;

import java.util.ArrayList;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakedevDevException;
import com.krakedev.persistencia.ClienteBDD;

@Path("clientes")
public class ServicioClientes {
	
	@Path("metodo1")
	@GET
 public String saludar() {
	 return "Hola mundo RestWeb services";
 }
 
	
 @Path("mbuscar")
 @GET
 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Cliente buscar() {
		Cliente cliente=new Cliente("1209309290","Juan");
		cliente.setNumeroHijos(2);
		return cliente;
	}

 
 @Path("insertar")
 @POST
@Consumes(MediaType.APPLICATION_JSON)
 public Response insertar(Cliente cliente) {
	 System.out.println(">>>>>>>"+cliente);
	 ClienteBDD clienteBDD=new ClienteBDD();
	 try {
		clienteBDD.insertar(cliente);
		return Response.ok().build();
	} catch (KrakedevDevException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return Response.serverError().build();
	}
 }
 
 @Path("actualizar")
 @PUT
@Consumes(MediaType.APPLICATION_JSON)
 public Response actualizr(Cliente cliente) {
	 System.out.println("Actualizando>>>>>>>"+cliente);
	 ClienteBDD clienteBDD=new ClienteBDD();
	 try {
		clienteBDD.actualizar(cliente);
		return Response.ok().build();
	} catch (KrakedevDevException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return Response.serverError().build();
	}
 }
 
 @Path("all")
 @GET
 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
 public Response obtenerClientes(){
	 ClienteBDD cli=new ClienteBDD();
	 ArrayList<Cliente>clientes=null;
	 try {
		clientes=cli.recuperarTodos();
		return Response.ok(clientes).build();
	} catch (KrakedevDevException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 return Response.serverError().build();
	}
	
 }
 
 
 @Path("buscarPorCedula/{cedulaParam}")
 @GET
 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
 public Response buscarPorCedula(@PathParam("cedulaParam") String cedula){
	 ClienteBDD cli=new ClienteBDD();
	Cliente cliente=null;
	 try {
		cliente=cli.buscarPorPK(cedula);
		return Response.ok(cliente).build();
	} catch (KrakedevDevException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 return Response.serverError().build();
	}
	
 }
 
 
 @Path("buscarPorHijos/{numeroParam}")
 @GET
 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
 public Response buscarporNumeroHijos(@PathParam("numeroParam") int hijos){
	 ClienteBDD cli=new ClienteBDD();
	 ArrayList<Cliente>clientes=null;
	 try {
		clientes=cli.nudcarPorNumeroHijos(hijos);
		return Response.ok(clientes).build();
	} catch (KrakedevDevException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 return Response.serverError().build();
	}
	
 }
 
}
