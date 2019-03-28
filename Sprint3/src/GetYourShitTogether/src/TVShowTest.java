import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TVShowTest {
	
	String creators = "Greg Daniels, Ricky Gervais, Stephen Merchant";
	String creators2 = "David Benioff, D.B. Weiss";

	TVShow show = new TVShow("The Office", "Comedy", "10", 2005, "A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium.",
							"NBC", creators);
	
	@Test
	void testTVShow() {
		TVShow show2 = new TVShow("Game of Thrones", "Fantasy", "10", 2011, "Nine noble families fight for control over the mythical lands of Westeros, while an ancient enemy returns after being dormant for thousands of years.",
									"HBO", creators2);
		assertEquals(show2.getTitle(), "Game of Thrones");
		assertEquals(show2.getGenre(), "Fantasy");
		assertEquals(show2.getRating(), "10");
		assertEquals(show2.getReleaseDate(), 2011);
		assertEquals(show2.getPlot(), "Nine noble families fight for control over the mythical lands of Westeros, while an ancient enemy returns after being dormant for thousands of years.");
		assertEquals(show2.getStudio(), "HBO");
		assertArrayEquals(show2.getCreators(), creators2.split(","));
		assertEquals(show2.getID(), -1);
		
	}

	@Test
	void testGetCreators() {
		assertArrayEquals(show.getCreators(),creators.split(","));
	}

	@Test
	void testGetTitle() {
		assertEquals(show.getTitle(), "The Office");
	}

	@Test
	void testGetGenre() {
		assertEquals(show.getGenre(), "Comedy");
	}

	@Test
	void testGetRating() {
		assertEquals(show.getRating(), "10");
	}

	@Test
	void testGetReleaseDate() {
		assertEquals(show.getReleaseDate(), 2005);
	}

	@Test
	void testGetPlot() {
		assertEquals(show.getPlot(), "A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium.");
	}

	@Test
	void testGetID() {
		assertEquals(show.getID(), -1);
	}

	@Test
	void testGetStudio() {
		assertEquals(show.getStudio(), "NBC");
	}

}
