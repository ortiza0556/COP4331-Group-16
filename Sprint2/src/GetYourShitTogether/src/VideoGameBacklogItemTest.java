import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class VideoGameBacklogItemTest {

	VideoGameBacklogItem game2 = new VideoGameBacklogItem("Warhammer 2: Vermintide", "Action", "ON HOLD", "9", 1);
	@Test
	public void testVideoGameBacklogItem(){
		VideoGameBacklogItem game2 = new VideoGameBacklogItem("Devil May Cry 5", "Action", "PLAYING", "10", 1);

		assertEquals(game2.getTitle(), "Devil May Cry 5");
		assertEquals(game2.getGenre(), "Action");
		assertEquals(game2.getStatus(), "PLAYING");
		assertEquals(game2.getRating(), "10");
		assertEquals(game2.getPriority(), 1);
	}

	@Test
	void testGetTitle() {
		assertEquals(game2.getTitle(), "Warhammer 2: Vermintide");
	}

	@Test
	void testGetGenre() {
		assertEquals(game2.getGenre(), "Action");
	}

	@Test
	void testGetStatus() {
		assertEquals(game2.getStatus(), "ON HOLD");
	}

	@Test
	void testGetRating() {
		assertEquals(game2.getRating(), "9");
	}

	@Test
	void testGetPriority() {
		assertEquals(game2.getPriority(), 1);
	}

}
