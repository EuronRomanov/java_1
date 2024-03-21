package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.presistencia.util.ConexionBDD;

public class AdminPersonas {
private static final Logger LOGGER=LogManager.getLogger(AdminPersonas.class);
	
	
	public static void insertar(Persona persona) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Persona a insertar>>>"+persona);
		try {
			con=ConexionBDD.conectar();
			String nuevaPersona="insert into personas(cedula,"
					+ "nombre,"
					+ "apellido,"
					+ "estado_civil_codigo,"
					+ "numero_hijos,"
					+ "estatura,"
					+ "cantidad_ahorrada,"
					+ "fecha_nacimiento,"
					+ " hora_nacimiento)  values (?,?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(nuevaPersona);
			ps.setString(1, persona.getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3,persona.getApellido());
			ps.setString(4, persona.getEstadoCivil().getCodigo());
			
			ps.setInt(5, persona.getNumeroHijos());
			ps.setDouble(6, persona.getEstatura());
			ps.setBigDecimal(7, persona.getCantidadAhorrada());
			ps.setDate(8, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(9, new java.sql.Time(persona.getHoraNacimiento().getTime()));
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			LOGGER.error("Error al insertar ", e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error cn la base de datos", e);
				throw new Exception("Error con la base de datos");
				
			}
		}
		
	}
	
	///actualizar
	
	public static void actualizar(Persona persona) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Persona a actualizar>>>"+persona);
		try {
			con=ConexionBDD.conectar();
			String nuevaPersona="update personas set "
					+ "nombre=?,"
					+ "apellido=?,"
					+ "estado_civil_codigo=?,"
					+ "numero_hijos=?,"
					+ "estatura=?,"
					+ "cantidad_ahorrada=?,"
					+ "fecha_nacimiento=?,"
					+ " hora_nacimiento=?  where cedula=?";
			
			ps=con.prepareStatement(nuevaPersona);
			
			ps.setString(1, persona.getNombre());
			ps.setString(2,persona.getApellido());
			ps.setString(3, persona.getEstadoCivil().getCodigo());
			ps.setInt(4, persona.getNumeroHijos());
			ps.setDouble(5, persona.getEstatura());
			ps.setBigDecimal(6, persona.getCantidadAhorrada());
			ps.setDate(7, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(8, new java.sql.Time(persona.getHoraNacimiento().getTime()));
			ps.setString(9, persona.getCedula());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			LOGGER.error("Error al actualizarr ", e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error cn la base de datos", e);
				throw new Exception("Error con la base de datos");
				
			}
		}
		
	}
	
	
	//eliminar
	
	public static void eliminar(Persona persona) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Persona a eliminar>>"+persona);
		try {
			con=ConexionBDD.conectar();
			String nuevaPersona=" delete from personas where  cedula=?";
			
			ps=con.prepareStatement(nuevaPersona);
			ps.setString(1, persona.getCedula());
			
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			
			LOGGER.error("Error al  eliminar", e);
			 
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error cn la base de datos", e);
				throw new Exception("Error con la base de datos");
				
			}
		}
		
	}
	
}
