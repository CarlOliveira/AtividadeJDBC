package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static ConnectionFactory instancia;
	
	private ConnectionFactory() {
		
	}
	
	public static ConnectionFactory getInstance() {
		if(instancia == null){
			instancia = new ConnectionFactory();
		}
		return instancia;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "admin");
	}
}
