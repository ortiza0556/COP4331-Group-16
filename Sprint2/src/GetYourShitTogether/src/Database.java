
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


abstract class Database {
	
		private String filePath;
		private Connection conn;
	
		public Database (String filePath) {
			
			this.filePath = filePath;
			connect();
			
		}
		
		private void connect() {
			
			try {
				
				String database = "jdbc:sqlite:" + this.filePath;
				this.conn = DriverManager.getConnection(database);
				
				System.out.println("Connection made");
				
			} catch (SQLException e) {
				System.out.println("Failed to connect to databse:" + e.getMessage());
			}
		}
		
		public void close() {
			try {
				this.conn.close();
				
				System.out.println("Connection closed");
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		abstract void Insert ();
		
		abstract ResultSet Search (String title);
}
