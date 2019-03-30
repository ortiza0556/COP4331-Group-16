
public class Movie extends Media {
	
	private String[] directors;
	
	public Movie(String title, String genre, String rating, int releaseDate, String directors){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.directors = directors.split(",");
		this.id = -1;
		
	}
	
	public Movie(String title, String genre, String rating, int releaseDate, int id, String directors){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.id = id;
		this.directors = directors.split(",");
	}
	
	public String[] getDirectors()
	{
		return this.directors;
	}
	
}
