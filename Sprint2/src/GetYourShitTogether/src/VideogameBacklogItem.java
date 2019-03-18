import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class VideogameBacklogItem {
	
	private SimpleStringProperty title;
    private SimpleStringProperty genre;
    private SimpleStringProperty status;
    private SimpleStringProperty rating;
    private SimpleIntegerProperty priority;
 
    public VideogameBacklogItem (String title, String genre, String status, String rating, int priority) {
 
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.status = new SimpleStringProperty(status);
        this.rating = new SimpleStringProperty(rating);
        this.priority = new SimpleIntegerProperty(priority);
    }
 
    public String getTitle() {
 
        return title.get();
    }
    
    public String getGenre() {
 
        return genre.get();
    }
    
    public String getStatus() {
    	
    	return status.get();
    }
    
    public String getRating() {
    	
    	return rating.get();
    }
    
    public int getPriority() {
    	
    	return priority.get();
    }
}
