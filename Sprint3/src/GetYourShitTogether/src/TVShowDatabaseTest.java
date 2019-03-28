import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

class TVShowDatabaseTest {

	@Test
	void testInsertTVShow() {
		TVShowDatabase db = new TVShowDatabase();
		TVShow TVShow1 = new TVShow("The Office", "Comedy", "10", 2005, "A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium.",
				"NBC", "Greg Daniels, Ricky Gervais, Stephen Merchant");
		db.Insert(TVShow1);
		assertEquals(db.resultText, "TV show successfully added");		
	}

	@Test
	void testSearch() {
		
		TVShowDatabase db = new TVShowDatabase();
		TVShow TVShow2 = new TVShow("Game of Thrones", "Fantasy", "10", 2011, "Nine noble families fight for control over the mythical lands of Westeros, while an ancient enemy returns after being dormant for thousands of years.",
				"HBO", "David Benioff, D.B. Weiss");
		db.Insert(TVShow2);
		assertEquals(db.resultText, "TV show successfully added");
		ObservableList<TVShow> resultList = db.Search("Game of Thrones");
		assertEquals(db.resultText, "Results found");
		TVShow resultingTVShow = resultList.get(0);		
		assertEquals(resultingTVShow.getTitle(), "Game of Thrones");		
	}

}
