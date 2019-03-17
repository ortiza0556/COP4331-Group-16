
public class Anime extends Media{
	
	public Anime(Database db){
		
	}
	
	public Anime(String title, String genre, String rating, int releaseDate, String plot, String studio){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.plot = plot;
		this.studio = studio;
		this.id = -1;
		
	}
	
	private Anime(String title, String genre, String rating, int releaseDate, String plot, int id, String studio){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.plot = plot;
		this.studio = studio;
		this.id = id;
		
	}
	
}
