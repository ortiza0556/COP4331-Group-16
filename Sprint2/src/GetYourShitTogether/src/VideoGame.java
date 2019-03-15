
public class VideoGame extends Media{

	private String platform;
	
	public VideoGame(Database db) {
		
	}
	
	public VideoGame(String title, String genre, String rating, int release, String plot, String studio, String platform){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = release;
		this.plot = plot;
		this.studio = studio;
		this.platform = platform;
		this.id = -1;
		
	}
	
	private VideoGame(String title, String genre, String rating, int release, String plot, int id, String studio, String platform){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = release;
		this.plot = plot;
		this.studio = studio;
		this.id = id;
		this.platform = platform;
		
	}
	
	public String getPlatform() {
		return this.platform;
	}
}
