
public class Anime extends Media{
	
	public Anime(String title, String genre, String rating){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.id = -1;
		
	}
	
	public Anime(String title, String genre, String rating, int id){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.id = id;
		
	}
	
}
