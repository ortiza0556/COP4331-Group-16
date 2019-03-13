import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestClass {

	@Test
	public void AnimeTest() {
		// TODO Auto-generated method stub

		/*
		Database dbi = new Database("C:\\Users\\aubre\\Documents\\GitHub\\COP4331-Group-16\\Sprint1\\src\\getYourShitTogether.sqlite");
		
		dbi.InsertIntoAnimeTable("Anohana", 2011, "Drama,Slice-of-Life", "8.53", "Boy meets ghost girl", "A-1 pictures");
		dbi.SearchAnimeTable("Anohana");
		dbi.close();
		*/
	}
	
	@Test
	public void AnimeCreate() {
		Anime biganimetiddies = new Anime("Jojo's Bizarre Adventure", "Shonen", "10", 2011, "Big boy jojo does jojo things ora ora ora", "David Production");
		
		assertEquals(biganimetiddies.getTitle(), "Jojo's Bizarre Adventure");
		assertEquals(biganimetiddies.getGenre(), "Shonen");
		assertEquals(biganimetiddies.getRating(), "10");
		assertEquals(biganimetiddies.getReleaseDate(), 2011);
		assertEquals(biganimetiddies.getPlot(), "Big boy jojo does jojo things ora ora ora");
		assertEquals(biganimetiddies.getStudio(), "David Production");
		
	}
}
