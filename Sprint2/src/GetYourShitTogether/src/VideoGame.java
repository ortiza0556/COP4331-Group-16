
public class VideoGame extends Media{

	private String[] platforms;
	
	public VideoGame(String title, String genre, String rating, int releaseDate, String platforms){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.platforms = platforms.split(",");
		this.id = -1;
		
	}
	
	public VideoGame(String title, String genre, String rating, int releaseDate, int id, String platforms){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.id = id;
		this.platforms = platforms.split(",");
		
	}
	
	public String[] getPlatform() {
		return this.platforms;
	}
}
