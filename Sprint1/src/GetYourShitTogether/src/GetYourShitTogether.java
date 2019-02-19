
public class GetYourShitTogether {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DatabaseInterface dbi = new DatabaseInterface("C:\\Users\\Austin\\Documents\\GitHub\\COP4331-Group-16-mster\\Sprint1\\src\\GetYourShitTogether.sqlite");
		
		dbi.InsertIntoAnimeTable("Anohana", 2011, "Drama,Slice-of-Life", "8.53", "Boy meets ghost girl", "A-1 pictures");
		dbi.SearchAnimeTable("Anohana");
		dbi.close();
	}

}
