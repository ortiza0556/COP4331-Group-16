//import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestClass {

	@Test
	public void AnimeTest() {
		// TODO Auto-generated method stub

		DatabaseInterface dbi = new DatabaseInterface("C:\\Users\\aubre\\Documents\\GitHub\\COP4331-Group-16\\Sprint1\\src\\getYourShitTogether.sqlite");
		
		dbi.InsertIntoAnimeTable("Anohana", 2011, "Drama,Slice-of-Life", "8.53", "Boy meets ghost girl", "A-1 pictures");
		dbi.SearchAnimeTable("Anohana");
		dbi.close();
	}
}
