import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

class AnimeDatabaseTest {
	
	@Test
	void testInsertAnime() {
		AnimeDatabase db = new AnimeDatabase();
		Anime anime1 = new Anime("Jojo's Bizarre Adventure", "Shonen", "10");
		db.Insert(anime1);
		assertEquals(db.resultText, "Anime successfully added.");		
	}

	@Test
	void testSearch() {
		
		AnimeDatabase db = new AnimeDatabase();
		Anime anime2 = new Anime("Tengen Toppa Gurren Lagann", "Sci-fi", "10");
		db.Insert(anime2);
		assertEquals(db.resultText, "Anime successfully added.");
		ObservableList<Anime> resultList = db.Search("Tengen Toppa Gurren Lagann");
		assertEquals(db.resultText, "Results found");
		Anime resultingAnime = resultList.get(0);		
		assertEquals(resultingAnime.getTitle(), "Tengen Toppa Gurren Lagann");		
	}

}
