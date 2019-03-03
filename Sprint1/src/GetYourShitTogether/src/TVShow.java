
public class TVShow extends Media{
	
	private String[] directors;
	
	public TVShow(DatabaseInterface db){
		
	}
	
	public String[] getDirectors(){
		return this.directors;
	}
	
	public int numDirectors(){
		return this.directors.length;
	}
}
