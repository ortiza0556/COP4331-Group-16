import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Window;

public class GetYourShitTogether extends Application {
	
	private AnimeBacklog animeBacklog = new AnimeBacklog();
	private TVShowBacklog tvBacklog = new TVShowBacklog();
	private VideoGameBacklog vgBacklog = new VideoGameBacklog();
	private MovieBacklog movieBacklog = new MovieBacklog();
	private VBox vbox;
	

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Get Thine Shite Together, Cur");

        // Create the registration form grid pane
        this.vbox = new VBox();
        
        vbox.setSpacing(10);
        
        GridPane gridPane = new GridPane();
        vbox.getChildren().add(gridPane);
        // Add UI controls to the registration form grid pane
        addUIControls(vbox,"TVShows");
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(vbox, 1440, 760);
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    private void addUIControls(VBox vbox, String mediaType) {
    	
        this.InitializeButtonPane(vbox);
        
    	TableView<TVShowBacklogItem> tvTable = loadTVTable();
        vbox.getChildren().add(tvTable);
          
        
        this.InitializeButtomButtons(vbox);
        
    }
    
    private void InitializeButtonPane(VBox vbox) {
    	
// Add Header
    	
    	GridPane gridPane = (GridPane) vbox.getChildren().get(0);
    	
    	gridPane.setAlignment(Pos.CENTER);
    	
    	//columnOneConstraints will be applied to all the nodes placed in column one.
    	ColumnConstraints column1Constraints = new ColumnConstraints();
        ColumnConstraints column2Constraints = new ColumnConstraints();
        column2Constraints.setPercentWidth(11);
        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints column3Constraints = new ColumnConstraints();
        ColumnConstraints column4Constrains = new ColumnConstraints();
        ColumnConstraints column5Constraints = new ColumnConstraints();
        column5Constraints.setPercentWidth(11);

        gridPane.getColumnConstraints().addAll(column1Constraints,column2Constraints,column3Constraints,column4Constrains,column5Constraints);

    	HBox buttons = new HBox();
        // Add Name Label
        Button badgeButton = new Button("Badge");
        
        Button recommendButton = new Button("Recommendations");
        
        Button backlogButton = new Button("Backlogs");

        buttons.getChildren().addAll(badgeButton,recommendButton,backlogButton);
        gridPane.add(buttons,0,0);
        
        Label bufferLabel1 = new Label();
        gridPane.add(bufferLabel1, 1, 0);
        
        Label searchLabel = new Label("Search: ");
        gridPane.add(searchLabel, 2, 0);
        
        // Add Name Text Field
        TextField searchField = new TextField();
        searchField.setPrefHeight(40);
        searchField.setPrefWidth(550);
        gridPane.add(searchField, 3,0);

        HBox categories = new HBox();
        // Add Name Label
        Button tvButton = new Button("TV Shows");
        tvButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               vbox.getChildren().set(1, loadTVTable());
            }
        });
        
        Button movieButton = new Button("Movies"); 
        movieButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               vbox.getChildren().set(1, loadMovieTable());
            }
        });
        
        Button animeButton = new Button("Anime");
        animeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               vbox.getChildren().set(1, loadAnimeTable());
            }
        });
        
        Button vidyaButton = new Button("Videogames");
        vidyaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               vbox.getChildren().set(1, loadVideogameTable());
            }
        });
        
        
        categories.getChildren().addAll(tvButton,movieButton,animeButton,vidyaButton);
        
        gridPane.add(categories, 5, 0);
    	
    }
    
   
	@SuppressWarnings("unchecked")
	private TableView<TVShowBacklogItem> loadTVTable() {
    	
    	TableView<TVShowBacklogItem> table = new TableView<TVShowBacklogItem>();
    	ObservableList<TVShowBacklogItem> data = tvBacklog.fetchAll();
    	table.setItems(data);
 
        TableColumn<TVShowBacklogItem,String> titleCol = new TableColumn<TVShowBacklogItem,String>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<TVShowBacklogItem,String>("title"));
        TableColumn<TVShowBacklogItem,String> authorCol = new TableColumn<TVShowBacklogItem,String>("Genre");
        authorCol.setCellValueFactory(new PropertyValueFactory<TVShowBacklogItem,String>("genre"));
        TableColumn<TVShowBacklogItem,String> statusCol = new TableColumn<TVShowBacklogItem,String>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<TVShowBacklogItem,String>("status"));
        TableColumn<TVShowBacklogItem,String> ratingCol = new TableColumn<TVShowBacklogItem,String>("Rating");
        ratingCol.setCellValueFactory(new PropertyValueFactory<TVShowBacklogItem,String>("rating"));
        TableColumn<TVShowBacklogItem,Integer> priorityCol = new TableColumn<TVShowBacklogItem,Integer>("Priority");
        priorityCol.setCellValueFactory(new PropertyValueFactory<TVShowBacklogItem,Integer>("priority"));
 
        table.getColumns().setAll(titleCol, authorCol, statusCol, ratingCol, priorityCol);
        table.setPrefWidth(1430);
        table.setPrefHeight(635);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
 
    	return table;
    }
    
	@SuppressWarnings("unchecked")
	private TableView<MovieBacklogItem> loadMovieTable() {
    	
    	TableView<MovieBacklogItem> table = new TableView<MovieBacklogItem>();
    	ObservableList<MovieBacklogItem> data = movieBacklog.fetchAll();
    	table.setItems(data);
 
        TableColumn<MovieBacklogItem,String> titleCol = new TableColumn<MovieBacklogItem,String>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<MovieBacklogItem,String>("title"));
        TableColumn<MovieBacklogItem,String> authorCol = new TableColumn<MovieBacklogItem,String>("Genre");
        authorCol.setCellValueFactory(new PropertyValueFactory<MovieBacklogItem,String>("genre"));
        TableColumn<MovieBacklogItem,String> statusCol = new TableColumn<MovieBacklogItem,String>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<MovieBacklogItem,String>("status"));
        TableColumn<MovieBacklogItem,String> ratingCol = new TableColumn<MovieBacklogItem,String>("Rating");
        ratingCol.setCellValueFactory(new PropertyValueFactory<MovieBacklogItem,String>("rating"));
        TableColumn<MovieBacklogItem,Integer> priorityCol = new TableColumn<MovieBacklogItem,Integer>("Priority");
        priorityCol.setCellValueFactory(new PropertyValueFactory<MovieBacklogItem,Integer>("priority"));
 
        table.getColumns().setAll(titleCol, authorCol, statusCol, ratingCol, priorityCol);
        table.setPrefWidth(1430);
        table.setPrefHeight(635);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
 
    	return table;
    }
	
	@SuppressWarnings("unchecked")
	private TableView<AnimeBacklogItem> loadAnimeTable() {
    	
    	TableView<AnimeBacklogItem> table = new TableView<AnimeBacklogItem>();
    	ObservableList<AnimeBacklogItem> data = animeBacklog.fetchAll();
    	table.setItems(data);
 
        TableColumn<AnimeBacklogItem,String> titleCol = new TableColumn<AnimeBacklogItem,String>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<AnimeBacklogItem,String>("title"));
        TableColumn<AnimeBacklogItem,String> authorCol = new TableColumn<AnimeBacklogItem,String>("Genre");
        authorCol.setCellValueFactory(new PropertyValueFactory<AnimeBacklogItem,String>("genre"));
        TableColumn<AnimeBacklogItem,String> statusCol = new TableColumn<AnimeBacklogItem,String>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<AnimeBacklogItem,String>("status"));
        TableColumn<AnimeBacklogItem,String> ratingCol = new TableColumn<AnimeBacklogItem,String>("Rating");
        ratingCol.setCellValueFactory(new PropertyValueFactory<AnimeBacklogItem,String>("rating"));
        TableColumn<AnimeBacklogItem,Integer> priorityCol = new TableColumn<AnimeBacklogItem,Integer>("Priority");
        priorityCol.setCellValueFactory(new PropertyValueFactory<AnimeBacklogItem,Integer>("priority"));
 
        table.getColumns().setAll(titleCol, authorCol, statusCol, ratingCol, priorityCol);
        table.setPrefWidth(1430);
        table.setPrefHeight(635);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
 
    	return table;
    }
	
	@SuppressWarnings("unchecked")
	private TableView<VideogameBacklogItem> loadVideogameTable() {
    	
    	TableView<VideogameBacklogItem> table = new TableView<VideogameBacklogItem>();
    	ObservableList<VideogameBacklogItem> data = vgBacklog.fetchAll();
    	table.setItems(data);
 
        TableColumn<VideogameBacklogItem,String> titleCol = new TableColumn<VideogameBacklogItem,String>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<VideogameBacklogItem,String>("title"));
        TableColumn<VideogameBacklogItem,String> authorCol = new TableColumn<VideogameBacklogItem,String>("Genre");
        authorCol.setCellValueFactory(new PropertyValueFactory<VideogameBacklogItem,String>("genre"));
        TableColumn<VideogameBacklogItem,String> statusCol = new TableColumn<VideogameBacklogItem,String>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<VideogameBacklogItem,String>("status"));
        TableColumn<VideogameBacklogItem,String> ratingCol = new TableColumn<VideogameBacklogItem,String>("Rating");
        ratingCol.setCellValueFactory(new PropertyValueFactory<VideogameBacklogItem,String>("rating"));
        TableColumn<VideogameBacklogItem,Integer> priorityCol = new TableColumn<VideogameBacklogItem,Integer>("Priority");
        priorityCol.setCellValueFactory(new PropertyValueFactory<VideogameBacklogItem,Integer>("priority"));
 
        table.getColumns().setAll(titleCol, authorCol, statusCol, ratingCol, priorityCol);
        table.setPrefWidth(1430);
        table.setPrefHeight(635);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
 
    	return table;
    }

    private void InitializeButtomButtons(VBox vbox) {
    	HBox bottomRow = new HBox();
    	
    	Button deleteButton = new Button("Delete");
        
    		deleteButton.setPrefWidth(100);
    		deleteButton.setPrefHeight(50);
    	
        Button addButton = new Button("Add");
        
        	addButton.setPrefWidth(100);
        	addButton.setPrefHeight(50);
	        
        Button editButton = new Button("Edit");
        	
        	editButton.setPrefWidth(100);
        	editButton.setPrefHeight(50);
        
        
        bottomRow.setAlignment(Pos.CENTER);
        bottomRow.setSpacing(20);
        
        bottomRow.getChildren().addAll(addButton,deleteButton,editButton);
        
        vbox.getChildren().addAll(bottomRow);
    	
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}