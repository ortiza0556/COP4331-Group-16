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

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Get Thine Shit Together, Cur");

        // Create the registration form grid pane
        VBox vbox = new VBox();
        
        vbox.setSpacing(10);
        
        GridPane gridPane = new GridPane();
        vbox.getChildren().add(gridPane);
        // Add UI controls to the registration form grid pane
        addUIControls(vbox);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(vbox, 1440, 760);
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    private void addUIControls(VBox vbox) {
        
        this.InitializeButtonPane(vbox);
        
        @SuppressWarnings("rawtypes")
		TableView table = initializeTable();
        vbox.getChildren().add(table);
        
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
        
        Button movieButton = new Button("Movies");
        
        Button animeButton = new Button("Anime");
        
        Button vidyaButton = new Button("Videogames");
        
        
        categories.getChildren().addAll(tvButton,movieButton,animeButton,vidyaButton);
        
        gridPane.add(categories, 5, 0);
    	
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private TableView initializeTable() {
    	
    	TableView table = new TableView();

 
        TableColumn titleCol = new TableColumn("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory("Title"));
        TableColumn authorCol = new TableColumn("Genre");
        authorCol.setCellValueFactory(new PropertyValueFactory("Genre"));
        TableColumn statusCol = new TableColumn("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory("Status"));
        TableColumn ratingCol = new TableColumn("Rating");
        ratingCol.setCellValueFactory(new PropertyValueFactory("Rating"));
        TableColumn priorityCol = new TableColumn("Priority");
        priorityCol.setCellValueFactory(new PropertyValueFactory("Priority"));
 
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