import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimeTest {

	Anime biganimetiddies = new Anime("Jojo's Bizarre Adventure", "Shonen", "10", 2011, "Big boy jojo does jojo things ora ora ora", "David Production");
	
	@Test
	void testAnimeCreate() {
		
		assertEquals(biganimetiddies.getTitle(), "Jojo's Bizarre Adventure");
		assertEquals(biganimetiddies.getGenre(), "Shonen");
		assertEquals(biganimetiddies.getRating(), "10");
		assertEquals(biganimetiddies.getReleaseDate(), 2011);
		assertEquals(biganimetiddies.getPlot(), "Big boy jojo does jojo things ora ora ora");
		assertEquals(biganimetiddies.getID(), -1);
		assertEquals(biganimetiddies.getStudio(), "David Production");
	}

	@Test
	void testGetTitle() {
		assertEquals(biganimetiddies.getTitle(), "Jojo's Bizarre Adventure");
	}

	@Test
	void testGetGenre() {
		assertEquals(biganimetiddies.getGenre(), "Shonen");
	}

	@Test
	void testGetRating() {
		assertEquals(biganimetiddies.getRating(), "10");
	}

	@Test
	void testGetReleaseDate() {
		assertEquals(biganimetiddies.getReleaseDate(), 2011);
	}

	@Test
	void testGetPlot() {
		assertEquals(biganimetiddies.getPlot(), "Big boy jojo does jojo things ora ora ora");
	}

	@Test
	void testGetID() {
		assertEquals(biganimetiddies.getID(), -1);
	}

	@Test
	void testGetStudio() {
		assertEquals(biganimetiddies.getStudio(), "David Production");
	}

}
