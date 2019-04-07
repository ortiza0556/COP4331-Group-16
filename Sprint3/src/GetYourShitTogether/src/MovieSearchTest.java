import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

class MovieSearchTest {

	private MovieSearch movieTestSearch;

	@Test
	void testMovieSearch() {
		movieTestSearch = new MovieSearch();
	}

	@Test
	void testSearch() {
		ObservableList<Movie> testList = movieTestSearch.search("Snatch");
		System.out.println(testList.size());
		// check if testList is legit
	}
}
