package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_connection {
	private static DB_connection instance; // Singleton Instance
	private Connection connection; // Connection
	// Connection Parameters
	private final String username="ajerez";
	private final String password="4j3r3z";
	private final String host = "192.168.254.215";
	private final String port = "1521";
	private final String service = "orcl";
	
	
	private DB_connection() {
		try {
		connection = DriverManager.getConnection(getConnectionString(), username, password);
		} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Error connecting to the database.");
		}
		}
		public String getConnectionString() {
		return String.format("jdbc:oracle:thin:@%s:%s:%s", this.host, this.port, this.service);
		}
		public static DB_connection getInstance() {
			if (instance == null) {
			instance = new DB_connection();
			}
			return instance;
			}
			public Connection getConnection() {
			return connection;
			}


}
