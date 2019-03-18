
public class Movie extends Media {
	
	private String[] directors;
	
	public Movie(String title, String genre, String rating, int releaseDate, String plot, String studio, String directors){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.plot = plot;
		this.studio = studio;
		this.directors = directors.split(",");
		this.id = -1;
		
	}
	
	public Movie(String title, String genre, String rating, int releaseDate, String plot, int id, String studio, String directors){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.plot = plot;
		this.studio = studio;
		this.id = id;
		this.directors = directors.split(",");
	}
	
	public String[] getDirectors()
	{
		return this.directors;
	}
	
}
