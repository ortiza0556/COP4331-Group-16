import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TVShowBacklogItemTest {
	
	TVShowBacklogItem tvShow = new TVShowBacklogItem("Parks and Rec", "Porn", "ON HOLD", "9", 1);

	@Test
	void testAnimeBacklogItem() {
		TVShowBacklogItem tvShow2 = new TVShowBacklogItem("The Office", "Action", "WATCHING", "10", 1);

		assertEquals(tvShow2.getTitle(), "The Office");
		assertEquals(tvShow2.getGenre(), "Action");
		assertEquals(tvShow2.getStatus(), "WATCHING");
		assertEquals(tvShow2.getRating(), "10");
		assertEquals(tvShow2.getPriority(), 1);
	}

	@Test
	void testGetTitle() {
		assertEquals(tvShow.getTitle(), "Parks and Rec");
	}

	@Test
	void testGetGenre() {
		assertEquals(tvShow.getGenre(), "Porn");
	}

	@Test
	void testGetStatus() {
		assertEquals(tvShow.getStatus(), "ON HOLD");
	}

	@Test
	void testGetRating() {
		assertEquals(tvShow.getRating(), "9");
	}

	@Test
	void testGetPriority() {
		assertEquals(tvShow.getPriority(), 1);
	}

}
