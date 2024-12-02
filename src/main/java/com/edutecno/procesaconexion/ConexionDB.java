package com.edutecno.procesaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConexionDB {
     
    	private static final   String url = "jdbc:postgresql://localhost:5432/DBHoroscopoChino";
    	private static final   String user = "postgres";
    	private static final   String password = "Hat422@";
       

        public static Connection getConexion() {
            try {
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }
	
	
/*	
	
		 public static Connection getConnection() throws SQLException {
			   		


		
		// TODO Auto-generated method stub
		
	       String url = "jdbc:postgresql://localhost:5432/DBHoroscopoChino"; // Cambia 'localhost', '5432' y 'tu_base_de_datos' según tu configuración.
	        String usuario = "postgres"; // Cambia por tu usuario de PostgreSQL
	        String contrasena = "Hat422@"; // Cambia por tu contraseña

	        Connection conexion = null;

	        try {
	            // Registrar el driver (opcional con versiones modernas de JDBC)
	     //       Class.forName("org.postgresql.Driver");

	            // Establecer la conexión
	            conexion = DriverManager.getConnection(url, usuario, contrasena);
	            System.out.println("Conexión exitosa a la base de datos!");

	            // Aquí puedes ejecutar consultas o manejar operaciones con la base de datos.

	        } catch (SQLException e) {
	            System.out.println("Error al conectar a la base de datos");
	            e.printStackTrace();
	     //   } catch (ClassNotFoundException e) {
	            System.out.println("No se encontró el controlador JDBC");
	            e.printStackTrace();
	        } finally {
	            // Cerrar la conexión cuando hayas terminado
	            if (conexion != null) {
	                try {
	                    conexion.close();
	                    System.out.println("Conexión cerrada.");
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
    }
			return conexion;

	}
*/	    
	
	



}
