package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.krakedev.persistencia.entidades.Venta;
import com.krakedev.presistencia.util.ConexionBDD;

public class AdminVentas {
private static final Logger LOGGER=LogManager.getLogger(AdminVentas .class);
	
	
	public static void insertar(Venta venta) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Venta a insertar>>>"+venta);
		try {
			con=ConexionBDD.conectar();
			String nuevaVenta="insert into ventas(id_venta,"
					+ "codigo_producto,"
					+ "fecha_venta,"
					+ "cantidad)  values (?,?,?,?)";
			
			ps=con.prepareStatement(nuevaVenta);
			ps.setInt(1, venta.getId_venta());
			ps.setInt(2, venta.getCodigo_producto().getCodigo());
			ps.setDate(3,new java.sql.Date(venta.getFecha_venta().getTime()));
			ps.setInt(4, venta.getCantidad());
			
			
			
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
	
	public static void actualizar(Venta venta) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Venta a actualizar>>"+venta);
		try {
			con=ConexionBDD.conectar();
			
			
			String nuevaVenta="update ventas  set "
					+ "codigo_producto=?,"
					+ "fecha_venta=?,"
					+ "cantidad=?  where id_venta=?";
			
			ps=con.prepareStatement(nuevaVenta);
		
			ps.setInt(1, venta.getCodigo_producto().getCodigo());
			ps.setDate(2,new java.sql.Date(venta.getFecha_venta().getTime()));
			ps.setInt(3, venta.getCantidad());
			ps.setInt(4, venta.getId_venta());
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
	
	public static void eliminar(Venta venta) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Venta a eliminar>>>"+venta);
		try {
			con=ConexionBDD.conectar();
			String nuevaPersona=" delete from ventas where id_venta=?";
			
			ps=con.prepareStatement(nuevaPersona);
			ps.setInt(1, venta.getId_venta());
			
			
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
