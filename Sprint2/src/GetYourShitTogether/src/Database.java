
import java.sql.ResultSet;

abstract class Database<M extends Media> {
	
		protected String filePath;
		
		protected abstract void connect();
		
		protected abstract void close();
		
		protected abstract void Insert (M m);
		
		protected abstract ResultSet Search (String title);

}
