import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TVShowBacklog {

	private Connection conn;
	protected FilePath fp = new FilePath();
	protected String filePath = fp.getFilePath();
	
	public TVShowBacklog () {
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
	
	public void Insert(TVShowBacklogItem t, WatchableMediaStatus s, String userRating, int priority) {
		
		int id = t.getID();
		
		if(CheckIfExists(id) == 0) {
			
			String sql = "INSERT INTO TVShows_Backlog (TVID,Status,UserRating,Priority) "
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
	            
	            System.out.println("Entry added.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		}else {
			System.out.println("Entry already exists.");
		}
		
	}
	
	public void Delete(TVShowBacklogItem t) {
		this.connect();
		
		int id = t.getID();
		System.out.println(id);
		
		if(CheckIfExists(id) != -1) {
			
			String sql = "DELETE FROM TVShows_Backlog WHERE TVID = ?";
			
	        try {
	            PreparedStatement stmt = this.conn.prepareStatement(sql);
	            stmt.setInt(1,id);
	            
	            stmt.executeUpdate();
	            
	            this.conn.close();
	            
	            System.out.println("Entry deleted.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		}else {
			System.out.println("Entry does not exist.");
		}
		
	}

	public void Update(TVShowBacklogItem t, String status, String userRating, int priority) {
		int id = t.getID();
		
		if(CheckIfExists(id) == 0) {
			
			String sql = "UPDATE TVShows_Backlog SET Status = ?, UserRating = ?, Priority = ? WHERE TVID = ?";
			
			
	        try {
	            PreparedStatement stmt = this.conn.prepareStatement(sql);

	            stmt.setString(1,status);
	            stmt.setString(2,userRating);
	            stmt.setInt(3,priority);
	            stmt.setInt(4,id);
	            stmt.executeUpdate();
	            
	            System.out.println("Entry updated.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		}else {
			System.out.println("Entry does not exist.");
		}
		
	}
	
	private int CheckIfExists (int id) {
        String sql = "SELECT TVID FROM TVShows_Backlog WHERE TVID = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1,id);
            
            ResultSet rs = stmt.executeQuery();
            
            int result= rs.getInt(1);

            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return -1;
        
    }
	
	public ObservableList<TVShowBacklogItem> fetchAll() {
		
		this.connect();
		
		 String sql = "SELECT TVShows.TVID,Title,Genre,Status,UserRating,Priority FROM TVShows JOIN TVShows_backlog ON TVShows.TVID IS TVShows_backlog.TVID";
	        
	        ObservableList<TVShowBacklogItem> result = FXCollections.observableArrayList();
	        boolean added = false;
	        
	        try {
	            Statement stmt = this.conn.createStatement();
	            
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            while(rs.next()) {
	            	TVShowBacklogItem currTVShow = new TVShowBacklogItem(rs.getInt("TVID"),rs.getString("Title"),rs.getString("Genre"),rs.getString("Status"),rs.getString("UserRating"),rs.getInt("Priority"));
	            	
	            	added = result.add(currTVShow);
	            	
	            	if(!added){
	            		System.out.println("Error, tvshow not added properly");
	            	}else {
	            		added = false;
	            	}
	            }
	            
	            this.close();
	            return result;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        
	        return null;
		
	}
}
