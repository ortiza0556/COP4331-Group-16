import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimeRecommendationsTest {

	@Test
	void testAnimeRecommendations() {
		AnimeRecommendations yeeehawww= new AnimeRecommendations();
		//Used when testing sql statement on anime table
		assertEquals(yeeehawww.animeBacklogSize, 12294);
	}

}
