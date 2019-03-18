import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VideoGameTest {
	
	VideoGame game = new VideoGame("Devil May Cry 5", "Action", "9.7", 2019, "The ultimate Devil Hunter is back in style, in the game action fans have been waiting for.",
									"Capcom", "PS4, Xbox One, PC");
	String platforms = "PS4, Xbox One, PC";

	@Test
	void testVideoGame() {
		VideoGame game2 = new VideoGame("Resident Evil 2", "Horror", "9.2", 2019, "A deadly virus engulfs the residents of Raccoon City in September of 1998, plunging the "
	    + "city into chaos as flesh eating zombies roam the streets for survivors. An unparalleled adrenaline rush, gripping storyline, and unimaginable horrors await you. "
	    + "Witness the return of Resident Evil 2.", "Capcom", "PS4, Xbox One, PC");
		
		assertEquals(game2.getTitle(), "Resident Evil 2");
		assertEquals(game2.getGenre(), "Horror");
		assertEquals(game2.getRating(), "9.2");
		assertEquals(game2.getReleaseDate(), 2019);
		assertEquals(game2.getPlot(), "A deadly virus engulfs the residents of Raccoon City in September of 1998, plunging the "
	    + "city into chaos as flesh eating zombies roam the streets for survivors. An unparalleled adrenaline rush, gripping storyline, and unimaginable horrors await you. "
	    + "Witness the return of Resident Evil 2.");
		assertEquals(game2.getStudio(), "Capcom");
		assertArrayEquals(game2.getPlatform(), platforms.split(","));
	}

	@Test
	void testGetPlatform() {
		assertArrayEquals(game.getPlatform(), platforms.split(","));
	}

	@Test
	void testGetTitle() {
		assertEquals(game.getTitle(), "Devil May Cry 5");
	}

	@Test
	void testGetGenre() {
		assertEquals(game.getGenre(), "Action");
	}

	@Test
	void testGetRating() {
		assertEquals(game.getRating(), "9.7");
	}

	@Test
	void testGetReleaseDate() {
		assertEquals(game.getReleaseDate(), 2019);
	}

	@Test
	void testGetPlot() {
		assertEquals(game.getPlot(), "The ultimate Devil Hunter is back in style, in the game action fans have been waiting for.");
	}

	@Test
	void testGetID() {
		assertEquals(game.getID(), -1);
	}

	@Test
	void testGetStudio() {
		assertEquals(game.getStudio(), "Capcom");
	}

}
