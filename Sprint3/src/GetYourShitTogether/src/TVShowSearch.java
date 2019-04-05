import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TVShowSearch {

	private Connection conn;
	protected FilePath fp = new FilePath();
	protected String filePath = fp.getFilePath();
	
	public TVShowSearch() {
		
	}
	
	public ObservableList<TVShow> search(String title){
		
		connect();
		ObservableList<TVShow> searchResults = FXCollections.observableArrayList();
		boolean added = false;
		
		String sql = "SELECT * FROM TVShows WHERE Title LIKE \"%" + title + "%\"";
		
		try {
			Statement stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				TVShow currTVShow = new TVShow(rs.getString("Title"), rs.getString("Genre"), rs.getString("Rating"), rs.getInt("Release"), rs.getInt("TVShowID"), rs.getString("Director"));
				
				added = searchResults.add(currTVShow);
				
				if(!added) {
					System.out.println("Error, TVShow not added properly to the search results");
				} else {
					added = false;
				}
			}
			
			close();
		} catch(SQLException e) {
			close();
			System.out.println(e.getMessage());
		}
		
		return searchResults;		
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
