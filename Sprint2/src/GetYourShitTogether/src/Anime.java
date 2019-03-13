
public class Anime extends Media{
	
	public Anime(Database db){
		
	}
	
	public Anime(String title, String genre, String rating, int release, String plot, String studio){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = release;
		this.plot = plot;
		this.studio = studio;
		this.id = -1;
		
	}
	
	private Anime(String title, String genre, float String, int release, String plot, int id, String studio){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = release;
		this.plot = plot;
		this.studio = studio;
		this.id = id;
		
	}
	
}
