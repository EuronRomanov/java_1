package com.krakedev.conexionbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
try {
	Class.forName("org.postgresql.Driver");
	connection=DriverManager.getConnection( "jdbc:postgresql://localhost:5432/postgres",
	        "postgres", "");
	
	System.out.println("conexion exitosa");
} catch (ClassNotFoundException | SQLException e) {
	// TODO: handle exception
}
	}

}
