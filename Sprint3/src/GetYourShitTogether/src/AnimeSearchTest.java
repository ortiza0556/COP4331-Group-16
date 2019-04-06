import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

class AnimeSearchTest {
	
	private Connection conn;
	private FilePath fp = new FilePath();
	private String filePath = fp.getFilePath();
	private AnimeSearch animeTestSearch;

	@Test
	void testAnimeSearch() {
		animeTestSearch = new AnimeSearch();
	}

	@Test
	void testSearch() {
		ObservableList<Anime> testList = animeTestSearch.search("");
		// check if testList is legit
	}

	@Test
	void testConnect() {
		animeTestSearch.connect();
		animeTestSearch.close();
	}

	@Test
	void testClose() {
		animeTestSearch.connect();
		animeTestSearch.close();
	}

}
