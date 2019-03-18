import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VideoGameDatabase extends Database<VideoGame> {
	private Connection conn;

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
		String title = v.getTitle();
		int release = v.getReleaseDate();
		String genre = v.getGenre();
		String rating = v.getRating();
		String plot = v.getPlot();
		String prodStudio = v.getStudio();
		
		String sql = "INSERT INTO VideoGames (Title,Release,Genre,Rating,Plot,ProductionStudio) "
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

	@Override
	public ObservableList<VideoGame> Search (String title) {
        String sql = "SELECT VGID,Title,Release,Genre,Rating,Synopsis,DevStudio,Platform FROM VideoGames WHERE "
                + "Title LIKE '%" + title + "%'";
        
        ObservableList<VideoGame> result = FXCollections.observableArrayList();
        boolean added = false;
        
        try {
            Statement stmt = this.conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                VideoGame currVG = new VideoGame(rs.getString("Title"), rs.getString("Genre"), rs.getString("Rating"), rs.getInt("Release"), rs.getString("Synopsis"), 
                		rs.getInt("VGID"), rs.getString("DevStudio"), rs.getString("Platform"));
            	added = result.add(currVG);
            	
            	if(!added){
            		System.out.println("Error, movie not added properly");
            	}else {
            		added = false;
            	}
            }
            
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }
}
