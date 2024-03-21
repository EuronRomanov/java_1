package com.krakedev.persistencia.servicios;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.presistencia.util.ConexionBDD;
import com.krakedev.presistencia.util.Convertidor;

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
	
	
	//buscar
	
	public static ArrayList<Persona> buscarPorNombre(String nombreBusquedad) throws Exception {
		ArrayList<Persona> personas=new ArrayList<Persona>();
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		LOGGER.trace("Buscar en personas>>"+nombreBusquedad);
		try {
			con=ConexionBDD.conectar();
			String nuevaPersona="select * from personas where nombre like ?";
			
			ps=con.prepareStatement(nuevaPersona);
			ps.setString(1, "%"+nombreBusquedad+"%");
			
			
			rs=ps.executeQuery();
			
			while (rs.next()) {
				
				String cedula=rs.getString("cedula");
				 String nombre=rs.getString("nombre");
				 String apellido=rs.getString("apellido");
				 EstadoCivil estadoCivil=new EstadoCivil();
				 estadoCivil.setCodigo(rs.getString("estado_civil_codigo"));
				 int numeroHijos=rs.getInt("numero_hijos");
				 double estatura=rs.getDouble("estatura");
				 
				// Obtener el valor del ResultSet
		          
		            String valorMoneyString = rs.getString("cantidad_ahorrada");
		            
		           
		         //  String  valorMoneyString1 = valorMoneyString.replace("$", "").replace(",", "");
	
				BigDecimal cantidadAhorrada=convertirStringToBigDecimal(valorMoneyString);
				 Date fechaNacimiento=rs.getDate("fecha_nacimiento");
				 Date horaNacimiento=Convertidor.convertirHora2( rs.getTime("hora_nacimiento").toString());
				
				Persona p=new Persona(cedula, nombre, apellido, estadoCivil, numeroHijos, estatura, cantidadAhorrada, fechaNacimiento, horaNacimiento);
				personas.add(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			
			LOGGER.error("Error al  consultar personas", e);
			 
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error cn la base de datos", e);
				throw new Exception("Error con la base de datos");
				
			}
		}
		
		return personas;
		
	}
	
	//buscar por codigo 
	
	public static Persona buscarPorClave(String nombreBusquedad) throws Exception {
		Persona persona=null;
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		LOGGER.trace("Buscar en personas>>"+nombreBusquedad);
		try {
			con=ConexionBDD.conectar();
			String nuevaPersona="select * from personas where cedula=?";
			
			ps=con.prepareStatement(nuevaPersona);
			ps.setString(1, nombreBusquedad);
			
			
			rs=ps.executeQuery();
			
			if (rs.next()) {
				
				String cedula=rs.getString("cedula");
				 String nombre=rs.getString("nombre");
				 String apellido=rs.getString("apellido");
				 EstadoCivil estadoCivil=new EstadoCivil();
				 estadoCivil.setCodigo(rs.getString("estado_civil_codigo"));
				 int numeroHijos=rs.getInt("numero_hijos");
				 double estatura=rs.getDouble("estatura");
				 
				// Obtener el valor del ResultSet
		          
		            String valorMoneyString = rs.getString("cantidad_ahorrada");
		            
		           
		         //  String  valorMoneyString1 = valorMoneyString.replace("$", "").replace(",", "");
	
				BigDecimal cantidadAhorrada=convertirStringToBigDecimal(valorMoneyString);
				 Date fechaNacimiento=rs.getDate("fecha_nacimiento");
				 Date horaNacimiento=Convertidor.convertirHora2( rs.getTime("hora_nacimiento").toString());
				
				 persona=new Persona(cedula, nombre, apellido, estadoCivil, numeroHijos, estatura, cantidadAhorrada, fechaNacimiento, horaNacimiento);
				
			}else {
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			
			LOGGER.error("Error al  consultar personas", e);
			 
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error cn la base de datos", e);
				throw new Exception("Error con la base de datos");
				
			}
		}
		
		return persona;
		
	}
	
	//buscar y obtenr varios resultados
	
		public static ArrayList<Persona> buscarPorFecha(String fechaBusquedad) throws Exception {
			ArrayList<Persona> personas=new ArrayList<Persona>();
			
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			LOGGER.trace("Buscar en personas>>"+fechaBusquedad);
			try {
				con=ConexionBDD.conectar();
				String nuevaPersona="select * from personas where fecha_nacimiento=?";
				
				ps=con.prepareStatement(nuevaPersona);
				ps.setDate(1,new java.sql.Date(Convertidor.convertirFecha(fechaBusquedad).getTime()));
				
				
				rs=ps.executeQuery();
				
				while (rs.next()) {
					
					String cedula=rs.getString("cedula");
					 String nombre=rs.getString("nombre");
					 String apellido=rs.getString("apellido");
					 EstadoCivil estadoCivil=new EstadoCivil();
					 estadoCivil.setCodigo(rs.getString("estado_civil_codigo"));
					 int numeroHijos=rs.getInt("numero_hijos");
					 double estatura=rs.getDouble("estatura");
					 
					// Obtener el valor del ResultSet
			          
			            String valorMoneyString = rs.getString("cantidad_ahorrada");
			            
			           
			         //  String  valorMoneyString1 = valorMoneyString.replace("$", "").replace(",", "");
		
					BigDecimal cantidadAhorrada=convertirStringToBigDecimal(valorMoneyString);
					 Date fechaNacimiento=rs.getDate("fecha_nacimiento");
					 Date horaNacimiento=Convertidor.convertirHora2( rs.getTime("hora_nacimiento").toString());
					
					Persona p=new Persona(cedula, nombre, apellido, estadoCivil, numeroHijos, estatura, cantidadAhorrada, fechaNacimiento, horaNacimiento);
					personas.add(p);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				//System.out.println(e.getMessage());
				//e.printStackTrace();
				
				LOGGER.error("Error al  consultar personas", e);
				 
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					LOGGER.error("Error cn la base de datos", e);
					throw new Exception("Error con la base de datos");
					
				}
			}
			
			return personas;
			
		}
	
	
	
	private static BigDecimal convertirStringToBigDecimal(String valorString) {
        try {
            // Crear un objeto NumberFormat para el formato de moneda
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
            
            // Convertir el String a un Number
            Number number = format.parse(valorString);
            
            // Convertir el Number a BigDecimal
            return new BigDecimal(number.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
	
}
