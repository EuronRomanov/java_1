package com.krakedev.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.krakedev.excepciones.KrakedevDevException;

public class ConexionBDD {
	public static Connection obtenerConexion() throws KrakedevDevException {
		Context ctx=null;
		DataSource ds=null;
		Connection con=null;
			try {
				ctx = new InitialContext();
				//JDNI
				ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ConexionPG");
				con = ds.getConnection();
			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new KrakedevDevException("Error de conexion");
			} 
			
			
			
			return con;
		
	}
}
