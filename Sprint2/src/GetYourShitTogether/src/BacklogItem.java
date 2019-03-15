
public class BacklogItem extends Media {

	private int databaseID;
	
	public BacklogItem(Media mediaItem) {
		this.databaseID = -1;
	}

	public int getDatabaseID() {
		return databaseID;
	}

	public void setDatabaseID(int databaseID) {
		this.databaseID = databaseID;
	}
}
