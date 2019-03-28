import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimeTest {

	Anime anime1 = new Anime("Jojo's Bizarre Adventure", "Shonen", "10", 2011, "Big boy jojo does jojo things ora ora ora", "David Production");
	
	
	
	@Test
	void testAnime() {
		
		Anime anime2 = new Anime("Tengen Toppa Gurren Lagann", "Sci-fi", "10", 2007, "My drill is the drill that will pierce the heavens.", "Gainax");
		assertEquals(anime2.getTitle(), "Tengen Toppa Gurren Lagann");
		assertEquals(anime2.getGenre(), "Sci-fi");
		assertEquals(anime2.getRating(), "10");
		assertEquals(anime2.getReleaseDate(), 2007);
		assertEquals(anime2.getPlot(), "My drill is the drill that will pierce the heavens.");
		assertEquals(anime2.getID(), -1);
		assertEquals(anime2.getStudio(), "Gainax");
	}

	@Test
	void testGetTitle() {
		assertEquals(anime1.getTitle(), "Jojo's Bizarre Adventure");
	}

	@Test
	void testGetGenre() {
		assertEquals(anime1.getGenre(), "Shonen");
	}

	@Test
	void testGetRating() {
		assertEquals(anime1.getRating(), "10");
	}

	@Test
	void testGetReleaseDate() {
		assertEquals(anime1.getReleaseDate(), 2011);
	}

	@Test
	void testGetPlot() {
		assertEquals(anime1.getPlot(), "Big boy jojo does jojo things ora ora ora");
	}

	@Test
	void testGetID() {
		assertEquals(anime1.getID(), -1);
	}

	@Test
	void testGetStudio() {
		assertEquals(anime1.getStudio(), "David Production");
	}

}
