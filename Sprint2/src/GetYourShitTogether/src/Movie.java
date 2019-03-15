
public class Movie extends Media {
	
	private String director;
	
	public Movie(Database db)
	{
		
	}
	
	public Movie(String title, String genre, String rating, int release, String plot, String studio, String director){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = release;
		this.plot = plot;
		this.studio = studio;
		this.director = director;
		this.id = -1;
		
	}
	
	private Movie(String title, String genre, String rating, int release, String plot, int id, String studio, String director){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = release;
		this.plot = plot;
		this.studio = studio;
		this.id = id;
		this.director = director;
	}
	
	public String getDirector()
	{
		return this.director;
	}
	
}
