
public class Movie extends Media {
	
	private String director;
	
	public Movie(String title, String genre, String rating, int releaseDate, String plot, String studio, String director){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.plot = plot;
		this.studio = studio;
		this.director = director;
		this.id = -1;
		
	}
	
	public Movie(String title, String genre, String rating, int releaseDate, String plot, int id, String studio, String director){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
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
