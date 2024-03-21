package com.krakedev.conexionbdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexion {

	
	public static java.sql.Date getDateSQL(String fechaStr){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		Date fecha=null;
		java.sql.Date fechaSQL=null;
		try {
			fecha=sdf.parse(fechaStr);
			long  fechaMilis=fecha.getTime();
			fechaSQL=new java.sql.Date(fechaMilis);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaSQL;
	}
	
	
	
	
	public static java.sql.Time getTimeSQL(String horaStr){
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		Date fecha=null;
		java.sql.Time horaSQL=null;
		try {
			fecha=sdf.parse(horaStr);
			long  fechaMilis=fecha.getTime();
			horaSQL=new java.sql.Time(fechaMilis);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return horaSQL;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement ps=null;
try {
	Class.forName("org.postgresql.Driver");
	connection=DriverManager.getConnection( "jdbc:postgresql://localhost:5432/postgres",
	        "postgres", "");
	System.out.println("conexion exitosa");
	
	
	String nuevaPersona="insert into persona(cedula,nombre,apellido,estatura,fecha_nacimiento)  values (?,?,?,?,?)";
	
	ps=connection.prepareStatement(nuevaPersona);
	ps.setString(1, "1713514162");
	ps.setString(2, "FLAVIO GEOVANNY");
	ps.setString(3, "BRAVO LUZURIAGA");
	ps.setDouble(4, 170.5);
	ps.setDate(5, getDateSQL("1996/08/14"));
	
	
	int insertedRows = ps.executeUpdate();
	System.out.printf("insertado %s Personas(s)%n", insertedRows);
	
	
	String nuevoPrestamo="insert into prestamo values(?,?,?,?,?)";
	ps=connection.prepareStatement(nuevoPrestamo);
	ps.setString(1, "1713514162");
	ps.setBigDecimal(2, new BigDecimal("200.5"));
	ps.setDate(3, getDateSQL("2006/05/27"));
	ps.setTime(4, getTimeSQL("05:06:00"));
	ps.setString(5, "Pedro");
	insertedRows = ps.executeUpdate();
	System.out.printf("insertado %s Prestamo(s)%n", insertedRows);
	
} catch (ClassNotFoundException | SQLException e) {
	// TODO: handle exception
}
	}

}
