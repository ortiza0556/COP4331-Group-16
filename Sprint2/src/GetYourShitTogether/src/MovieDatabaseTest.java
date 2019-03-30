import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

class MovieDatabaseTest {

	@Test
	void testInsertMovie() {
		MovieDatabase db = new MovieDatabase();
		Movie Movie1 = new Movie("Detective Pikachu", "Mystery", "8", 2019, "Rob Letterman");
		db.Insert(Movie1);
		assertEquals(db.resultText, "Movie successfully added");		
	}

	@Test
	void testSearch() {
		
		MovieDatabase db = new MovieDatabase();
		Movie Movie2 = new Movie("Avengers: Endgame", "Action", "9.5", 2019, "Anthony Russo, Joe Russo");
		db.Insert(Movie2);
		assertEquals(db.resultText, "Movie successfully added");
		ObservableList<Movie> resultList = db.Search("Avengers: Endgame");
		assertEquals(db.resultText, "Results found");
		Movie resultingMovie = resultList.get(0);		
		assertEquals(resultingMovie.getTitle(), "Avengers: Endgame");		
	}

}
