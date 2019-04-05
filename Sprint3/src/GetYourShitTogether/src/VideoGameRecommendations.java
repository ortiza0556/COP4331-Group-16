import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VideoGameRecommendations {

	private int videoGameBacklogSize;
	private int numCompletedWithHighRating;
	final private int numRecommendations = 25;
	private Connection conn;
	protected FilePath fp = new FilePath();
	protected String filePath = fp.getFilePath();
	
	public VideoGameRecommendations(){
		connect();
		
		//get size of the VideoGame backlog
		String sql = "SELECT count(VideoGameID) FROM VideoGames_Backlog";
		try {
			Statement stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			this.videoGameBacklogSize = rs.getInt(1);
		} catch (SQLException e) {
          System.out.println(e.getMessage());
		}
		
		//get the number of completed VideoGames with ratings above 7
		sql = "SELECT count(Status) FROM VideoGames_Backlog WHERE Status = 'Completed' AND UserRating > 7 AND UserRating IS NOT NULL";
		try {
			Statement stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			this.numCompletedWithHighRating = rs.getInt(1);
		} catch (SQLException e) {
          System.out.println(e.getMessage());
		}
		
		close();
	}
	
	public ObservableList<VideoGame> getRecommendations() {
		
		connect();
		ObservableList<VideoGame> results = FXCollections.observableArrayList();
		boolean added = false;
		
		//Empty backlog
		if(videoGameBacklogSize == 0) {
			//grab entries from VideoGame table rated 7 or higher
			String sql = "SELECT * FROM VideoGames WHERE Rating > 7 AND Rating IS NOT NULL ORDER BY RANDOM() LIMIT " + Integer.toString(numRecommendations);
			
			try {
				Statement stmt = this.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					VideoGame currVideoGame = new VideoGame(rs.getString("Title"), rs.getString("Genre"), rs.getString("Rating"), rs.getInt("Release"), rs.getInt("VideoGameID"), rs.getString("Platform"));
					
					added = results.add(currVideoGame);
					
					if(!added) {
						System.out.println("Error, VideoGame not added properly");
					} else {
						added = false;
					}									
				}
				close();
				
			} catch(SQLException e) {
				close();
				System.out.println(e.getMessage());
			}
		} else if(numCompletedWithHighRating == 0) {
			
			int numToGet = 5;
			if(videoGameBacklogSize < 5)
				numToGet = videoGameBacklogSize;
			
			String sql = "SELECT Genre FROM VideoGames_Backlog JOIN VideoGames ON VideoGames_Backlog.VideoGameID IS VideoGames.VideoGameID ORDER BY RANDOM() LIMIT " + Integer.toString(numToGet);
			try {
				Statement stmt = this.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				Set<String> genres = new HashSet<>();
				
				//get the genres from the selected VideoGame
				while(rs.next()) {
					
					List<String> currGenres = Arrays.asList(rs.getString("Genre").split(","));
					int i; 
					
					//add the genres to the set
					for(i = 0; i < currGenres.size(); i++) {
						genres.add(currGenres.get(i));							
					}						
				}
				
				//start new sql query to get recommendations based on the genres
				sql = "SELECT * FROM VideoGames WHERE Rating > 7 AND Rating IS NOT NULL AND (";
				
				int j = 0;
				//convert genres set to an array
				String [] genresArray = genres.toArray(new String[0]);
				for(j = 0; j < genres.size(); j++) {
					if(j < genres.size() - 1)
						sql = sql + "Genre LIKE \"%" + genresArray[j].trim() + "%\" OR ";
					else
						sql = sql + "Genre LIKE \"%" + genresArray[j].trim() + "%\"";
				}
				
				
				sql = sql + ") AND VideoGameID NOT IN (SELECT VideoGameID FROM VideoGames_Backlog) ORDER BY RANDOM() LIMIT " + Integer.toString(numRecommendations);
				
				//Execute the constructed sql statement
				rs = stmt.executeQuery(sql);
				
				//Add the recommendations to the observable list
				while(rs.next()) {
					VideoGame currVideoGame = new VideoGame(rs.getString("Title"), rs.getString("Genre"), rs.getString("Rating"), rs.getInt("Release"), rs.getInt("VideoGameID"), rs.getString("Platform"));
					
					added = results.add(currVideoGame);
					
					if(!added) {
						System.out.println("Error, VideoGame not added properly");
					} else {
						added = false;
					}									
				}
				close();

			} catch(SQLException e) {
				close();
				System.out.println(e.getMessage());
			}
			
			
		} else if(numCompletedWithHighRating > 0) {
			int numToGet = 5;
			if(numCompletedWithHighRating < 5)
				numToGet = numCompletedWithHighRating;
			String sql = "SELECT Genre FROM VideoGames_Backlog JOIN VideoGames ON VideoGames_Backlog.VideoGameID IS VideoGames.VideoGameID WHERE Status = 'Completed' AND UserRating > 7 ORDER BY RANDOM() LIMIT " + Integer.toString(numToGet);
			
			try {
				Statement stmt = this.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				Set<String> genres = new HashSet<>();
				
				//get the genres from the selected VideoGame
				while(rs.next()) {
					
					List<String> currGenres = Arrays.asList(rs.getString("Genre").split(","));
					int i; 
					
					//add the genres to the set
					for(i = 0; i < currGenres.size(); i++) {
						genres.add(currGenres.get(i));							
					}						
				}
				
				//start new sql query to get recommendations based on the genres
				sql = "SELECT * FROM VideoGames WHERE Rating > 7 AND Rating IS NOT NULL AND (";
				
				int j = 0;
				//convert genres set to an array
				String [] genresArray = genres.toArray(new String[0]);
				for(j = 0; j < genres.size(); j++) {
					if(j < genres.size() - 1)
						sql = sql + "Genre LIKE \"%" + genresArray[j].trim() + "%\" OR ";
					else
						sql = sql + "Genre LIKE \"%" + genresArray[j].trim() + "%\"";
				}
				
				
				sql = sql + ") AND VideoGameID NOT IN (SELECT VideoGameID FROM VideoGames_Backlog) ORDER BY RANDOM() LIMIT " + Integer.toString(numRecommendations);
				
				//Execute the constructed sql statement
				rs = stmt.executeQuery(sql);
				
				//Add the recommendations to the observable list
				while(rs.next()) {
					VideoGame currVideoGame = new VideoGame(rs.getString("Title"), rs.getString("Genre"), rs.getString("Rating"), rs.getInt("Release"), rs.getInt("VideoGameID"), rs.getString("Platform"));
					added = results.add(currVideoGame);
					
					if(!added) {
						System.out.println("Error, VideoGame not added properly");
					} else {
						added = false;
					}								
				}
				
				close();
				
			} catch(SQLException e) {
				close();
				System.out.println(e.getMessage());
			}
		} 
		
		
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
