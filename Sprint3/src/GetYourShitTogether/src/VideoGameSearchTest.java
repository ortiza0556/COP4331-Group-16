import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

class VideoGameSearchTest {
	
	private VideoGameSearch vidyaTestSearch;

	@Test
	void testAnimeSearch() {
		vidyaTestSearch = new VideoGameSearch();
	}

	@Test
	void testSearch() {
		ObservableList<VideoGame> testList = vidyaTestSearch.search("Apex");
		System.out.println(testList.size());
		// check if testList is legit
	}
}
