
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseInterface {
	
		private static String filePath;
		private static Connection conn;
	
		public DatabaseInterface (String fp) {
			
			filePath = fp;
			connect();
			
		}
		
		private static void connect() {
			
			try {
				
				String database = "jdbc:sqlite:" + filePath;
				conn = DriverManager.getConnection(database);
				
				System.out.println("Connection made");
				
			} catch (SQLException e) {
				System.out.println("I AM AN ERROR MESSAGE" +e.getMessage());
			}
		}
		
		public void close() {
			try {
				conn.close();
				
				System.out.println("Connection closed");
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
}
