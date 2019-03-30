import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;


public class AnimeDatabase extends Database<Anime> {
	
	private Connection conn;
	public String resultText = null;

	public AnimeDatabase () {
		
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
	protected void Insert(Anime a) {
		resultText = null;
		String title = a.getTitle();
		String genre = a.getGenre();
		String rating = a.getRating();
		
		String sql = "INSERT INTO Anime (Title,Genre,Rating) "
                + "VALUES(?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,title);
            stmt.setString(2, genre);
            stmt.setString(3, rating);
            
            stmt.executeUpdate();
            
            System.out.println("Entry added");
            resultText = "Anime successfully added.";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
		
	}

	@Override
	public ObservableList<Anime> Search (String title) {
        String sql = "SELECT AnimeID,Title,Release,Genre,Rating,Plot,ProductionStudio FROM Anime WHERE "
                + "Title LIKE '%" + title + "%'";
        resultText = null;
        ObservableList<Anime> result = FXCollections.observableArrayList();
        boolean added = false;
        
        try {
            Statement stmt = this.conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
            	Anime currAnime = new Anime(rs.getString("Title"), rs.getString("Genre"), rs.getString("Rating"), rs.getInt("AnimeID"));
            	
            	added = result.add(currAnime);
            	
            	if(!added){
            		System.out.println("Error, anime not added properly");
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
