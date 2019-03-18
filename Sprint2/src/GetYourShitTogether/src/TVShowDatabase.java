import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TVShowDatabase extends Database<TVShow> {
	private Connection conn;

	public TVShowDatabase () {
		
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
	protected void Insert(TVShow t) {
		String title = t.getTitle();
		int release = t.getReleaseDate();
		String genre = t.getGenre();
		String rating = t.getRating();
		String plot = t.getPlot();
		String prodStudio = t.getStudio();
		
		String sql = "INSERT INTO TVShows (Title,Release,Genre,Rating,Plot,ProductionStudio) "
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
	public ObservableList<TVShow> Search (String title) {
        String sql = "SELECT TVID,Title,Release,Genre,Rating,Plot,ProductionStudio,Director FROM TVShows WHERE "
                + "Title LIKE '%" + title + "%'";
        
        ObservableList<TVShow> result = FXCollections.observableArrayList();
        boolean added = false;
        
        try {
            Statement stmt = this.conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
            	TVShow currTVShow = new TVShow(rs.getString("Title"), rs.getString("Genre"), rs.getString("Rating"), 
            			rs.getInt("Release"), rs.getString("Plot"), rs.getInt("AnimeID"), rs.getString("ProductionStudio"), rs.getString("Director"));
            	
            	added = result.add(currTVShow);
            	
            	if(!added){
            		System.out.println("Error, anime not added properly");
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
