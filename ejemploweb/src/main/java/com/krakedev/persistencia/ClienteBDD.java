package com.krakedev.persistencia;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakedevDevException;
import com.krakedev.utils.ConexionBDD;

public class ClienteBDD {
	public void insertar(Cliente cliente) throws KrakedevDevException  {
		Connection con=null;
		String proceidmientoSql="insert into clientes(cedula, nombre, numerohijos) values(?,?,?)";
		try {
			 con=ConexionBDD.obtenerConexion();
			PreparedStatement ps=con.prepareStatement(proceidmientoSql);
			ps.setString(1, cliente.getCedula());
			ps.setString(2, cliente.getNombre());
			ps.setInt(3, cliente.getNumeroHijos());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakedevDevException("Error al insertar cliente");
		} catch (KrakedevDevException e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			if (con!=null) {
				try {
					con.close()
;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			}
		}
	}
	
	
	public void actualizar(Cliente cliente) throws KrakedevDevException  {
		Connection con=null;
		String proceidmientoSql="update clientes set  nombre=?, numerohijos=? where cedula=?";
		try {
			 con=ConexionBDD.obtenerConexion();
			PreparedStatement ps=con.prepareStatement(proceidmientoSql);
			
			ps.setString(1, cliente.getNombre());
			ps.setInt(2, cliente.getNumeroHijos());
			ps.setString(3, cliente.getCedula());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakedevDevException("Error al actualizar cliente");
		} catch (KrakedevDevException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	
	
	public ArrayList<Cliente>recuperarTodos() throws KrakedevDevException {
		ArrayList<Cliente> clientes=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cliente cliente=null;
		String proceidmientoSql="Select cedula,nombre,numeroHijos  from clientes";
		try {
			con=ConexionBDD.obtenerConexion();
			 ps=con.prepareStatement(proceidmientoSql);
			rs= ps.executeQuery();
			while(rs.next()){
				String cedula=rs.getString("cedula");
				String nombre=rs.getString("nombre");
				int numeroHijos=rs.getInt("numeroHijos");
				cliente=new Cliente(cedula, nombre);
				cliente.setNumeroHijos(numeroHijos);
				clientes.add(cliente);
			}
			 
		} catch (KrakedevDevException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakedevDevException("Error de consulta Detalle "+e.getMessage());
		}
		
		return clientes;
	}
	
	
	public Cliente buscarPorPK(String cedulaBusqueda) throws KrakedevDevException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cliente cliente=null;
		String proceidmientoSql="Select cedula,nombre,numeroHijos  from clientes where cedula=?";
		try {
			con=ConexionBDD.obtenerConexion();
			 ps=con.prepareStatement(proceidmientoSql);
			 ps.setString(1,cedulaBusqueda);
			rs= ps.executeQuery();
			if(rs.next()){
				String cedula=rs.getString("cedula");
				String nombre=rs.getString("nombre");
				int numeroHijos=rs.getInt("numeroHijos");
				cliente=new Cliente(cedula, nombre);
				cliente.setNumeroHijos(numeroHijos);
				
			}
			 
		} catch (KrakedevDevException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakedevDevException("Error de consulta Detalle "+e.getMessage());
		}
		
		return cliente;
	}
	
	
	public ArrayList<Cliente>nudcarPorNumeroHijos(int numero) throws KrakedevDevException {
		ArrayList<Cliente> clientes=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cliente cliente=null;
		String proceidmientoSql="Select cedula,nombre,numeroHijos  from clientes where numeroHijos>=?";
		try {
			con=ConexionBDD.obtenerConexion();
			 ps=con.prepareStatement(proceidmientoSql);
			 ps.setInt(1, numero);
			rs= ps.executeQuery();
			while(rs.next()){
				String cedula=rs.getString("cedula");
				String nombre=rs.getString("nombre");
				int numeroHijos=rs.getInt("numeroHijos");
				cliente=new Cliente(cedula, nombre);
				cliente.setNumeroHijos(numeroHijos);
				clientes.add(cliente);
			}
			 
		} catch (KrakedevDevException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakedevDevException("Error de consulta Detalle "+e.getMessage());
		}
		
		return clientes;
	}
}
