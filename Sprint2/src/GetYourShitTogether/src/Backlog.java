
import java.util.ArrayList;

public class Backlog {

	private ArrayList<Media> backlogArray;
	private int size;
	
	public Backlog() {
		this.size = 0;
	}

	public void editEntry(Media BacklogItem) {
		
	}
	
	public void store(Media BacklogItem) {
		this.backlogArray.add(BacklogItem);
		this.size++;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Media retrieve() {
		return null;
	}
	
	public void display() {
		
	}
}
