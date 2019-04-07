import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

class TVShowSearchTest {
	
	private TVShowSearch tvShowTestSearch;

	@Test
	void testAnimeSearch() {
		tvShowTestSearch = new TVShowSearch();
	}

	@Test
	void testSearch() {
		ObservableList<TVShow> testList = tvShowTestSearch.search("The Office");
		System.out.println(testList.size());
		// check if testList is legit
	}
}
