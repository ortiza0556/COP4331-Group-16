
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseInterface {
	
		private String filePath;
		private Connection conn;
	
		public DatabaseInterface (String filePath) {
			
			this.filePath = filePath;
			connect();
			
		}
		
		private void connect() {
			
			try {
				
				String database = "jdbc:sqlite:" + this.filePath;
				this.conn = DriverManager.getConnection(database);
				
				System.out.println("Connection made");
				
			} catch (SQLException e) {
				System.out.println("I AM AN ERROR MESSAGE" + e.getMessage());
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
		
		public void InsertIntoAnimeTable (String title, int release, String genre, String rating, String plot, String prodStudio) {
			String sql = "INSERT INTO Anime (Title,Release,Genre,Rating,Plot,ProductionStudio) "
					+ "VALUES(?,?,?,?,?,?)";
			try {
				PreparedStatement stmt = this.conn.prepareStatement(sql);
				stmt.setString(1,title);
				stmt.setInt(2, release);
				stmt.setString(3, genre);
				stmt.setString(4, rating);
				stmt.setString(5, plot);
				stmt.setString(6, prodStudio);
				
				stmt.executeUpdate();
				
				System.out.println("Entry added");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		public void SearchAnimeTable (String title) {
			String sql = "SELECT Title,Release,Genre,Rating,Plot,ProductionStudio FROM Anime WHERE "
					+ "Title LIKE '%" + title + "%'";
			
			try {
				Statement stmt = this.conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					
					System.out.println("Title:" + rs.getString("Title"));
					System.out.println("Release:" + rs.getInt("Release"));
					System.out.println("Genre:" + rs.getString("Genre"));
					System.out.println("Rating:" + rs.getString("Rating"));
					System.out.println("Plot:" + rs.getString("Plot"));
					System.out.println("ProductionStudio:" + rs.getString("ProductionStudio"));
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
}
