import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AnimeRecommendations {

	public int animeBacklogSize;
	public int numCompleted;
	private Connection conn;
	protected FilePath fp = new FilePath();
	protected String filePath = fp.getFilePath();
	
	
	public AnimeRecommendations(){
		connect();
		
		//get size of the anime backlog
		String sql = "SELECT count(Title) FROM Anime_Backlog";
		try {
			Statement stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			this.animeBacklogSize = rs.getInt(1);
		} catch (SQLException e) {
          System.out.println(e.getMessage());
		}
		
		//get the number of completed anime
		sql = "SELECT count(Status) WHERE Status = 'Completed' FROM Anime_Backlog";
		try {
			Statement stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			this.numCompleted = rs.getInt(1);
		} catch (SQLException e) {
          System.out.println(e.getMessage());
		}
		
		close();
	}
	
	public ObservableList<Anime> getRecommendations() {
		
		connect();
		ObservableList<Anime> results = FXCollections.observableArrayList();
		boolean added = false;
		
		//Empty backlog
		if(animeBacklogSize == 0) {
			//grab entries from anime table rated 8 or higher
			String sql = "SELECT * FROM Anime WHERE Rating > 8.0 AND Rating is not NULL AND Genre NOT LIKE \"%Hentai%\" ORDER BY RANDOM() LIMIT 25";
			
			try {
				Statement stmt = this.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Anime currAnime = new Anime(rs.getString("title"), rs.getString("genre"), rs.getString("rating"), rs.getInt("id"));
					
					added = results.add(currAnime);
					
					if(!added) {
						System.out.println("Error, anime not added properly");
					} else {
						added = false;
					}
									
				}
				
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} else if(numCompleted == 0) {
			
			if(animeBacklogSize < 5) {
				String sql = "SELECT * FROM Anime_Backlog ORDER BY RANDOM() LIMIT " + Integer.toString(animeBacklogSize);
			} else {
				String sql = "SELECT * FROM Anime_Backlog ORDER BY RANDOM() LIMIT 5";
			}
			
			
		} else if(numCompleted > 0) {
			
			if(numCompleted < 5) {
				String sql = "SELECT * FROM Anime_Backlog WHERE Status = 'Completed' ORDER BY RANDOM() LIMIT " + Integer.toString(numCompleted);
			} else {
				String sql = "SELECT * FROM Anime_Backlog WHERE Status = 'Completed' ORDER BY RANDOM() LIMIT 5";
			}
		} 
		
		
		close();
		return results;
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
	
}