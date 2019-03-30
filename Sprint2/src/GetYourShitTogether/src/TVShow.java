
public class TVShow extends Media{
	
	private String[] directors;
	
	public TVShow(String title, String genre, String rating, int releaseDate, String directors){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.id = -1;
		this.directors = directors.split(",");
		
		
		
	}
	
	public TVShow(String title, String genre, String rating, int releaseDate, int id, String directors){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.id = id;
		this.directors = directors.split(",");
		
	}
	
	public String[] getCreators(){
		return this.directors;
	}
}
