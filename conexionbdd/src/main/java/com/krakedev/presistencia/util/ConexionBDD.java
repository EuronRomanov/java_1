package com.krakedev.presistencia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBDD {
private  final static String DRIVE="org.postgresql.Driver";
private  final static String URL="jdbc:postgresql://localhost:5432/postgres";
private  final static String USUARIO="postgres";
private  final static String CLAVE="";


	public static  Connection conectar() throws Exception {
		Connection connection=null;
		try {
			Class.forName(DRIVE);
			connection=DriverManager.getConnection( URL,USUARIO, CLAVE);
		} catch (ClassNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error de infraestructura");
		}catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al conectarse, revize usuario y clave");
		}
		
		
		return connection;
	}
}
