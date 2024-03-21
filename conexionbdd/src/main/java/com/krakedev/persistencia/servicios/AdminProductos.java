package com.krakedev.persistencia.servicios;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Producto;
import com.krakedev.presistencia.util.ConexionBDD;

public class AdminProductos {
private static final Logger LOGGER=LogManager.getLogger(AdminProductos.class);
	
	
	public static void insertar(Producto producto ) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Producto a insertar>>>"+producto);
		try {
			con=ConexionBDD.conectar();
			String nuevaProducto="insert into productos(codigo,"
					+ " nombre,"
					+ "precio,"
					+ "stock)  values (?,?,?,?)";
			
			ps=con.prepareStatement(nuevaProducto);
			ps.setInt(1, producto.getCodigo());
			ps.setString(2, producto.getNombre());
			ps.setBigDecimal(3,producto.getPrecio());
			ps.setInt(4, producto.getStock());
			
			
			
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
	
	public static void actualizar(Producto producto) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Producto a actualizar>>>"+producto);
		try {
			con=ConexionBDD.conectar();
			
			
			String nuevaProducto="update productos set"
					+ " nombre=?,"
					+ "precio=?,"
					+ "stock=?  where codigo=?";
			
			ps=con.prepareStatement(nuevaProducto);
			
			ps.setString(1, producto.getNombre());
			ps.setBigDecimal(2,producto.getPrecio());
			ps.setInt(3, producto.getStock());
			
			ps.setInt(4, producto.getCodigo());
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
	
	public static void eliminar(Producto producto) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Producto a eliminar>>>"+producto);
		try {
			con=ConexionBDD.conectar();
			String nuevaPersona=" delete from productos where codigo=?";
		
			ps=con.prepareStatement(nuevaPersona);
			ps.setInt(1, producto.getCodigo());
			
			
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
