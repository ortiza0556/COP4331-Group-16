
public class TVShow extends Media{
	
	private String[] creators;
	
	public TVShow(Database db){
		
	}
	
	public TVShow(String title, String genre, String rating, int releaseDate, String plot, String studio, String[] creators){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.plot = plot;
		this.studio = studio;
		this.id = -1;
		this.creators = new String[creators.length];
		System.arraycopy(creators, 0, this.creators, 0, creators.length);
		
	}
	
	private TVShow(String title, String genre, String rating, int releaseDate, String plot, int id, String studio, String[] creators){
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.plot = plot;
		this.studio = studio;
		this.id = id;
		this.creators = new String[creators.length];
		System.arraycopy(creators, 0, this.creators, 0, creators.length);
		
	}
	
	public String[] getCreators(){
		return this.creators;
	}
}
