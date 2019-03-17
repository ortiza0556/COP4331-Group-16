import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class MovieBacklog <M extends Media>{
	
	private Connection conn;
	protected String filePath;
	
	public MovieBacklog () {
		connect();
		
	}
	
	protected void connect() {
		
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
	
	protected void Insert(Movie m, MovieStatus s, String userRating, int priority) {
		
		int id = m.getID();
		
		String sql = "INSERT INTO Movies_Backlog (MovieID,Status,UserRating,Priority) "
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1,id);
            
            switch(s) {
            	case TO_WATCH: stmt.setString(2, "To Watch"); 
            	break;
            	case WATCHING: stmt.setString(2, "Watching"); 
            	break;
            	case ON_HOLD: stmt.setString(2, "On Hold"); 
            	break;
            	case DROPPED: stmt.setString(2, "Dropped"); 
            	break;
            };
            
            stmt.setString(3, userRating);
            stmt.setInt(4, priority);
            
            stmt.executeUpdate();
            
            System.out.println("Entry added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
		
	}

	public ResultSet Search (String title) {
        String sql = "SELECT Title,Release,Genre,Rating,Plot,ProductionStudio FROM Movies WHERE "
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
            
            return rs;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }
}
