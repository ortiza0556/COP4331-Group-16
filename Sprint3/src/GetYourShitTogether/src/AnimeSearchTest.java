import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

class AnimeSearchTest {
	
	private AnimeSearch animeTestSearch;

	@Test
	void testAnimeSearch() {
		animeTestSearch = new AnimeSearch();
	}

	@Test
	void testSearch() {
		ObservableList<Anime> testList = animeTestSearch.search("Jojo's Bizarre Adventure");
		
		System.out.println(testList.size());
		// check if testList is legit
	}
}
