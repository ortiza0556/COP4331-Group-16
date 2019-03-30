import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

class VideoGameDatabaseTest {

	@Test
	void testInsertVideoGame() {
		VideoGameDatabase db = new VideoGameDatabase();
		VideoGame VideoGame1 = new VideoGame("Resident Evil 2", "Horror", "9.2", 2019, "PS4, Xbox One, PC");
		db.Insert(VideoGame1);
		assertEquals(db.resultText, "Video game successfully added");		
	}

	@Test
	void testSearch() {
		
		VideoGameDatabase db = new VideoGameDatabase();
		VideoGame VideoGame2 = new VideoGame("Devil May Cry 5", "Action", "9.7", 2019, "PS4, Xbox One, PC");
		db.Insert(VideoGame2);
		assertEquals(db.resultText, "Video game successfully added");
		ObservableList<VideoGame> resultList = db.Search("Devil May Cry 5");
		assertEquals(db.resultText, "Results found");
		VideoGame resultingVideoGame = resultList.get(0);		
		assertEquals(resultingVideoGame.getTitle(), "Devil May Cry 5");		
	}

}
