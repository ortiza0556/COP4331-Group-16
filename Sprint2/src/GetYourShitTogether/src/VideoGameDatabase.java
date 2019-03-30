import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VideoGameDatabase extends Database<VideoGame> {
	private Connection conn;
	public String resultText = null;

	public VideoGameDatabase () {
		
		super.filePath = filePath;
		connect();
		
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
	protected void Insert(VideoGame v) {
		resultText = null;
		String title = v.getTitle();
		int release = v.getReleaseDate();
		String genre = v.getGenre();
		String rating = v.getRating();
		String platform = v.getPlatform();
		platform = platform.substring(1, platform.length()-1);
		
		String sql = "INSERT INTO VideoGames (Title,Release,Genre,Rating,Platform) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,title);
            stmt.setInt(2, release);
            stmt.setString(3, genre);
            stmt.setString(4, rating);
            stmt.setString(5,  platform);
            
            stmt.executeUpdate();
            
            System.out.println("Entry added");
            resultText= "Video game successfully added";
                    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
		
	}

	@Override
	public ObservableList<VideoGame> Search (String title) {
        
		resultText = null;
        
		String sql = "SELECT VGID,Title,Release,Genre,Rating,Synopsis,DevStudio,Platform FROM VideoGames WHERE "
                + "Title LIKE '%" + title + "%'";
        
        ObservableList<VideoGame> result = FXCollections.observableArrayList();
        boolean added = false;
        
        try {
            Statement stmt = this.conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                VideoGame currVG = new VideoGame(rs.getString("Title"), rs.getString("Genre"), rs.getString("Rating"), rs.getInt("Release"), 
                		rs.getInt("VGID"), rs.getString("Platform"));
            	added = result.add(currVG);
            	
            	if(!added){
            		System.out.println("Error, video game not added properly");
            	}else {
            		added = false;
            	}
            }
            
            resultText = "Results found";
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }
}
