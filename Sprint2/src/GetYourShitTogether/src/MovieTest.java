import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovieTest {

	Movie bestfilmeverdontatmebruh = new Movie("Detective Pikachu", "Mystery", "8", 2019, "Danny Devito plays the titular character Detective Pikachu in the most emotional film of the year",
												"Legendary Entertainment", "Rob Letterman");
	
	@Test
	void testMovieCreate() {
		assertEquals(bestfilmeverdontatmebruh.getTitle(), "Detective Pikachu");
		assertEquals(bestfilmeverdontatmebruh.getGenre(), "Mystery");
		assertEquals(bestfilmeverdontatmebruh.getRating(), "8");
		assertEquals(bestfilmeverdontatmebruh.getReleaseDate(), 2019);
		assertEquals(bestfilmeverdontatmebruh.getPlot(), "Danny Devito plays the titular character Detective Pikachu in the most emotional film of the year");
		assertEquals(bestfilmeverdontatmebruh.getID(), -1);
		assertEquals(bestfilmeverdontatmebruh.getStudio(),"Legendary Entertainment");
		
	}

	@Test
	void testGetDirector() {
		assertEquals(bestfilmeverdontatmebruh.getDirector(), "Rob Letterman");
	}

	@Test
	void testGetTitle() {
		assertEquals(bestfilmeverdontatmebruh.getTitle(), "Detective Pikachu");
	}

	@Test
	void testGetGenre() {
		assertEquals(bestfilmeverdontatmebruh.getGenre(), "Mystery");
	}

	@Test
	void testGetRating() {
		assertEquals(bestfilmeverdontatmebruh.getRating(), "8");
	}

	@Test
	void testGetReleaseDate() {
		assertEquals(bestfilmeverdontatmebruh.getReleaseDate(), 2019);
	}

	@Test
	void testGetPlot() {
		assertEquals(bestfilmeverdontatmebruh.getPlot(), "Danny Devito plays the titular character Detective Pikachu in the most emotional film of the year");
	}

	@Test
	void testGetID() {
		assertEquals(bestfilmeverdontatmebruh.getID(), -1);
	}

	@Test
	void testGetStudio() {
		assertEquals(bestfilmeverdontatmebruh.getStudio(),"Legendary Entertainment");
	}

}
