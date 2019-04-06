import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

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

	/*
	@Test
	void testConnect() {
		animeTestSearch.connect();
	}

	@Test
	void testClose() {
		animeTestSearch.close();
	}*/

}
