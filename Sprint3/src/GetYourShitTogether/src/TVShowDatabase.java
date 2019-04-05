import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TVShowDatabase extends Database<TVShow> {
	private Connection conn;
	public String resultText = null;

	public TVShowDatabase () {
		
		super.filePath = filePath;
		
	}
	
	protected void connect() {
		
		try {
			
			String database = "jdbc:sqlite:" + this.filePath;
			this.conn = DriverManager.getConnection(database);
			
			System.out.println("Connection made");
			
		} catch (SQLException e) {
			System.out.println("Failed to connect to database:" + e.getMessage());
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
	
	@Override
	protected void Insert(TVShow t) {
		connect();
		resultText = null;
		
		String title = t.getTitle();
		int release = t.getReleaseDate();
		String genre = t.getGenre();
		String rating = t.getRating();
		String director = t.getDirectors();
		
		String sql = "INSERT INTO TVShows (Title,Release,Genre,Rating,Director) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,title);
            stmt.setInt(2, release);
            stmt.setString(3, genre);
            stmt.setString(4, rating);
            stmt.setString(5, director);
            
            stmt.executeUpdate();
            close();
            resultText = "TV show successfully added";
            System.out.println("Entry added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
		
	}

	@Override
	public ObservableList<TVShow> Search (String title) {
        connect();
		resultText = null;
		
		String sql = "SELECT TVID,Title,Release,Genre,Rating,Plot,ProductionStudio,Director FROM TVShows WHERE "
                + "Title LIKE '%" + title + "%'";
        
        ObservableList<TVShow> result = FXCollections.observableArrayList();
        boolean added = false;
        
        try {
            Statement stmt = this.conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
            	TVShow currTVShow = new TVShow(rs.getString("Title"), rs.getString("Genre"), rs.getString("Rating"), 
            			rs.getInt("Release"), rs.getInt("TVID"), rs.getString("Director"));
            	
            	added = result.add(currTVShow);
            	
            	if(!added){
            		System.out.println("Error, TV Show not added properly");
            	}else {
            		added = false;
            	}
            }
            
            resultText = "Results found";
            close();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
        return null;
        
    }
	
	public int getMaxID() {
		connect();
		int max = -1;
		
		String sql = "SELECT MAX(TVID) FROM TVShows";
		
		try {
			Statement stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			max = rs.getInt(1);
		} catch (SQLException e) {
			
			
		}
		close();
		return max;
	}
}
