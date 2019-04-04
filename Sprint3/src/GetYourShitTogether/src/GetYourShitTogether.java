import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Window;

public class GetYourShitTogether extends Application {
	
	private String mediaTypeDisplayed;
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
        mediaTypeDisplayed = mediaType;
    	TableView<TVShowBacklogItem> tvTable = loadTVTable();
        vbox.getChildren().add(tvTable);
          
        
        this.InitializeBottomButtons(vbox);
        
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

    	// initialize badge button
        Button badgeButton = new Button("Badge");
        badgeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	System.out.println("badge button pressed");
            }
        });
        
        // initialize recommend button
        Button recommendButton = new Button("Recommendations");
        recommendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	System.out.println("recommendations button pressed");
            }
        });
        
        // initialize backlog button
        Button backlogButton = new Button("Backlogs");
        backlogButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	System.out.println("backlogs button pressed");
            }
        });

        buttons.getChildren().addAll(badgeButton,recommendButton,backlogButton);
        gridPane.add(buttons, 0, 0);
        
        Label bufferLabel1 = new Label();
        gridPane.add(bufferLabel1, 1, 0);
        
        // initialize search label & text field
        Label searchLabel = new Label("Search: ");
        gridPane.add(searchLabel, 2, 0);
        
        TextField searchField = new TextField();
        searchField.setPrefHeight(40);
        searchField.setPrefWidth(550);
        gridPane.add(searchField, 3,0);

        HBox categories = new HBox();
        
        // initialize TV Shows button
        Button tvButton = new Button("TV Shows");
        tvButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	mediaTypeDisplayed = "TVShows";
            	vbox.getChildren().set(1, loadTVTable());
            }
        });

        // initialize Movies button
        Button movieButton = new Button("Movies"); 
        movieButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	mediaTypeDisplayed = "Movies";
            	vbox.getChildren().set(1, loadMovieTable());
            }
        });

        // initialize Anime button
        Button animeButton = new Button("Anime");
        animeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	mediaTypeDisplayed = "Anime";
            	vbox.getChildren().set(1, loadAnimeTable());
            }
        });

        // initialize Videogames button
        Button vidyaButton = new Button("Videogames");
        vidyaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	mediaTypeDisplayed = "VideoGames";
            	vbox.getChildren().set(1, loadVideoGameTable());
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
	private TableView<VideoGameBacklogItem> loadVideoGameTable() {
    	
    	TableView<VideoGameBacklogItem> table = new TableView<VideoGameBacklogItem>();
    	ObservableList<VideoGameBacklogItem> data = vgBacklog.fetchAll();
    	table.setItems(data);
 
        TableColumn<VideoGameBacklogItem,String> titleCol = new TableColumn<VideoGameBacklogItem,String>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<VideoGameBacklogItem,String>("title"));
        TableColumn<VideoGameBacklogItem,String> authorCol = new TableColumn<VideoGameBacklogItem,String>("Genre");
        authorCol.setCellValueFactory(new PropertyValueFactory<VideoGameBacklogItem,String>("genre"));
        TableColumn<VideoGameBacklogItem,String> statusCol = new TableColumn<VideoGameBacklogItem,String>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<VideoGameBacklogItem,String>("status"));
        TableColumn<VideoGameBacklogItem,String> ratingCol = new TableColumn<VideoGameBacklogItem,String>("Rating");
        ratingCol.setCellValueFactory(new PropertyValueFactory<VideoGameBacklogItem,String>("rating"));
        TableColumn<VideoGameBacklogItem,Integer> priorityCol = new TableColumn<VideoGameBacklogItem,Integer>("Priority");
        priorityCol.setCellValueFactory(new PropertyValueFactory<VideoGameBacklogItem,Integer>("priority"));
 
        table.getColumns().setAll(titleCol, authorCol, statusCol, ratingCol, priorityCol);
        table.setPrefWidth(1430);
        table.setPrefHeight(635);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
 
    	return table;
    }

	@SuppressWarnings("unchecked")
    private void InitializeBottomButtons(VBox vbox) {
    	HBox bottomRow = new HBox();
    	
    	// initialize delete button
    	Button deleteButton = new Button("Delete");
    	
    	deleteButton.setPrefWidth(100);
    	deleteButton.setPrefHeight(50);
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	try {
            		switch (mediaTypeDisplayed) {
            	
            	
            		case "TVShows":
            			TableView<TVShowBacklogItem> tvTable = (TableView<TVShowBacklogItem>) vbox.getChildren().get(1);
            			TVShowBacklogItem selectedShowForDeletion = tvTable.getSelectionModel().getSelectedItem();
            			tvBacklog.Delete(selectedShowForDeletion);
            			vbox.getChildren().set(1, loadTVTable());
            			break;
            		case "Movies":
            			TableView<MovieBacklogItem> movieTable = (TableView<MovieBacklogItem>) vbox.getChildren().get(1);
            			MovieBacklogItem selectedMovieForDeletion = movieTable.getSelectionModel().getSelectedItem();
            			movieBacklog.Delete(selectedMovieForDeletion);
            			vbox.getChildren().set(1, loadMovieTable());
            			break;
            		case "Anime":
            			TableView<AnimeBacklogItem> animeTable = (TableView<AnimeBacklogItem>) vbox.getChildren().get(1);
            			AnimeBacklogItem selectedAnimeForDeletion = animeTable.getSelectionModel().getSelectedItem();
            			animeBacklog.Delete(selectedAnimeForDeletion);
            			vbox.getChildren().set(1, loadAnimeTable());
            			break;
            		case "VideoGames":
            			TableView<VideoGameBacklogItem> vgTable = (TableView<VideoGameBacklogItem>) vbox.getChildren().get(1);
            			VideoGameBacklogItem selectedVGForDeletion = vgTable.getSelectionModel().getSelectedItem();
            			vgBacklog.Delete(selectedVGForDeletion);
            			vbox.getChildren().set(1, loadVideoGameTable());
            			break;
            		default:
            			System.out.println("Danger there be dragons in the Gap");
            		}
            	} catch (Exception exception) {
            		
            	}
            }
        });
    	
        // initialize add button
        Button addButton = new Button("Add");
        
        addButton.setPrefWidth(100);
        addButton.setPrefHeight(50);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	Stage addStage = new Stage();
            	createAddForm(addStage);
            }
        });
        
        //initialize edit button
        Button editButton = new Button("Edit");
        
        editButton.setPrefWidth(100);
        editButton.setPrefHeight(50);
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	System.out.println("edit button pressed");
            }
        });
        
        // set alignment & spacing
        bottomRow.setAlignment(Pos.CENTER);
        bottomRow.setSpacing(20);
        
        bottomRow.getChildren().addAll(addButton,deleteButton,editButton);
        
        vbox.getChildren().addAll(bottomRow);
    	
    }
	
	private void createAddForm(Stage addStage) {
		 addStage.setTitle("Add Media");
		 HBox addButtons = new HBox();
		 addButtons.setPadding(new Insets(20,20,20,20));
		 GridPane addPane = new GridPane();
		 addPane.setAlignment(Pos.CENTER);
		 addPane.setHgap(15);
		 addPane.setVgap(15);
		 addPane.setPadding(new Insets(0,40,40,40));
	
	    ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
	    columnOneConstraints.setHalignment(HPos.RIGHT);
	    ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
	    columnTwoConstrains.setHgrow(Priority.ALWAYS);
	    addPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

		 BorderPane addBox = new BorderPane();
		 
		 Scene addScene = new Scene(addBox,700,500);
	     
		 HBox labelBox = new HBox();
		 Label pageTitle = new Label("Add New Media");
		 pageTitle.setFont(new Font("Arial",30));
		 addBox.setTop(labelBox);
		 labelBox.getChildren().add(pageTitle);
		 labelBox.setPadding(new Insets(20,20,20,0));
		 labelBox.setAlignment(Pos.CENTER);
		 
		 
		Label titleLabel = new Label("Title: ");
		TextField titleInput = new TextField();
		
		Label releaseLabel = new Label("Release Year: ");
		TextField releaseInput = new TextField();
		
		Label genreLabel = new Label("Genre: ");
		TextField genreInput = new TextField();
		
		Label statusLabel = new Label("Status: ");
		ObservableList<String> statuses;
		if (mediaTypeDisplayed.contentEquals("VideoGames")) {
			statuses = FXCollections.observableArrayList(
						"TO_PLAY",
				        "PLAYING",
				        "ON_HOLD",
				        "DROPPED"    
					
				    );
			
		} else {
			statuses = FXCollections.observableArrayList(
						"TO_WATCH",
				        "WATCHING",
				        "ON_HOLD",
				        "DROPPED"
				    );
		}
		ComboBox<String> statusBox = new ComboBox<String>(statuses);
		
		Label ratingLabel = new Label("Rating(1-10): ");
		TextField ratingInput = new TextField();
		
		Label priorityLabel = new Label("Priority(Numeric): ");
		TextField priorityInput = new TextField();
		 switch (this.mediaTypeDisplayed) {
		 	
		 	case "Anime":
		 
		 		addPane.add(titleLabel,0,0);
		 		addPane.add(titleInput, 1, 0);
		 		addPane.add(genreLabel,0,1);
		 		addPane.add(genreInput, 1, 1);
		 		addPane.add(statusLabel, 0, 2);
		 		addPane.add(statusBox, 1, 2);
		 		addPane.add(ratingLabel, 0, 3);
		 		addPane.add(ratingInput, 1, 3);
		 		addPane.add(priorityLabel, 0, 4);
		 		addPane.add(priorityInput, 1, 4);
		 		
		 		
		 	break;
		 	default:
		 		
		 		addPane.add(titleLabel,0,0);
		 		addPane.add(titleInput, 1, 0);
		 		addPane.add(releaseLabel, 0, 1);
		 		addPane.add(releaseInput, 1, 1);
		 		addPane.add(genreLabel,0,2);
		 		addPane.add(genreInput, 1, 2);
		 		addPane.add(statusLabel, 0, 3);
		 		addPane.add(statusBox, 1, 3);
		 		addPane.add(ratingLabel, 0, 4);
		 		addPane.add(ratingInput, 1, 4);
		 		addPane.add(priorityLabel, 0, 5);
		 		addPane.add(priorityInput, 1, 5);
		 		
		 }
		 
		 
		addBox.setCenter(addPane);
		 
		 Button cancelButton = new Button("Cancel");
		 cancelButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	addStage.close();
	            }
	        });
		 cancelButton.setPrefWidth(100);
		 cancelButton.setPrefHeight(50);
		 Button addtoBacklogButton = new Button("Add");
		 addtoBacklogButton.setPrefWidth(100);
		 addtoBacklogButton.setPrefHeight(50);
		 addtoBacklogButton.setOnAction(e -> 
		 	{
		 		String title = titleInput.getText();
		 		String release = releaseInput.getText();
		 		String genre = genreInput.getText();
		 		String status = statusBox.getValue();
		 		String rating = ratingInput.getText();
		 		String priority = priorityInput.getText();
		 		VideoGameStatus vidEnum = null;
		 		WatchableMediaStatus watchEnum = null;
		 		try {
			 		if (mediaTypeDisplayed.equals("VideoGames")) {
			 			
			 			
			 			switch (status) {
				 		
				 		case "TO_PLAY":
				 			vidEnum = VideoGameStatus.TO_PLAY;
				 			break;
				 		case "PLAYING":
				 			vidEnum = VideoGameStatus.PLAYING;
				 			break;
				 		case "ON_HOLD":
				 			vidEnum = VideoGameStatus.ON_HOLD;
				 			break;
				 		case "DROPPED":
				 			vidEnum = VideoGameStatus.DROPPED;
				 			break;
				 		default :
				 			vidEnum = VideoGameStatus.COMPLETED;
				 		}
			 			
			 		} else {
			 			
				 		switch (status) {
				 		
				 		case "TO_WATCH":
				 			watchEnum = WatchableMediaStatus.TO_WATCH;
				 			break;
				 		case "WATCHING":
				 			watchEnum = WatchableMediaStatus.WATCHING;
				 			break;
				 		case "ON_HOLD":
				 			watchEnum = WatchableMediaStatus.ON_HOLD;
				 			break;
				 		case "DROPPED":
				 			watchEnum = WatchableMediaStatus.DROPPED;
				 			break;
				 		default :
				 			watchEnum = WatchableMediaStatus.COMPLETED;
				 		}
			 		}
		 	} catch (Exception exception) {
		 		Alert alert = new Alert(AlertType.INFORMATION, "Select a Status");
	 			alert.showAndWait();
	 			
	 			return;
		 	}
		 		if (!release.matches("\\d{4}") && !(release.equals(""))) {
		 			Alert alert = new Alert(AlertType.INFORMATION, "Please enter a valid year for the relase");
		 			alert.showAndWait();
		 			
		 			return;
		 			
		 		} else if (!(rating.equals("")) && !(rating.equals("10.0")) && !rating.matches("[0-9][.][0-9]{0,2}")) {

		 			Alert alert = new Alert(AlertType.INFORMATION, "Please enter a valid rating (0-10). 2 decimal places");
		 			alert.showAndWait();
		 			
		 			return;
		 		} else if (!priority.matches("-?[0-9]*")) {
		 			Alert alert = new Alert(AlertType.INFORMATION, "Please enter a valid integer for priority");
		 			alert.showAndWait();
		 			
		 			return;
		 			
		 		}
		 	
		 		int releaseInt;
		 		if (release.equals("")) {
		 			releaseInt = -1;
		 		} else {
		 			releaseInt = Integer.parseInt(release);
		 		}
		 		
		 		switch (mediaTypeDisplayed) {
		 		case "TVShows":
		 			TVShowDatabase tvdb = new TVShowDatabase();
		 			TVShowBacklog tvbdb = new TVShowBacklog();
		 			int tvid = tvdb.getMaxID() + 1;
		 			TVShow TVtoAdd = new TVShow(title,genre,rating,releaseInt,tvid," ");
		 			TVShowBacklogItem TVBackToAdd = new TVShowBacklogItem(tvid,title,genre,"",rating,Integer.parseInt(priority));
		 			tvdb.Insert(TVtoAdd);
		 			tvbdb.Insert(TVBackToAdd, watchEnum, rating,Integer.parseInt(priority));
		 			vbox.getChildren().set(1, loadTVTable());
		 			
        			break;
        		case "Movies":
        			MovieDatabase mvdb = new MovieDatabase();
		 			MovieBacklog mvbdb = new MovieBacklog();
		 			int mid = mvdb.getMaxID() + 1;
		 			Movie MovietoAdd = new Movie(title,genre,rating,releaseInt,mid," ");
		 			MovieBacklogItem MovieBackToAdd = new MovieBacklogItem(mid,title,genre,"",rating,Integer.parseInt(priority));
		 			mvdb.Insert(MovietoAdd);
		 			mvbdb.Insert(MovieBackToAdd, watchEnum, rating,Integer.parseInt(priority));
		 			vbox.getChildren().set(1, loadMovieTable());
        			break;
        		case "Anime":
	        		AnimeDatabase adb = new AnimeDatabase();
		 			AnimeBacklog abdb = new AnimeBacklog();
		 			int aid = adb.getMaxID() + 1;
		 			Anime AnimetoAdd = new Anime(title,genre,rating,aid);
		 			AnimeBacklogItem AnimeBackToAdd = new AnimeBacklogItem(aid,title,genre,"",rating,Integer.parseInt(priority));
		 			adb.Insert(AnimetoAdd);
		 			abdb.Insert(AnimeBackToAdd, watchEnum, rating,Integer.parseInt(priority));
		 			vbox.getChildren().set(1, loadAnimeTable());
        			break;
        		case "VideoGames":
        			VideoGameDatabase vgdb = new VideoGameDatabase();
		 			VideoGameBacklog vgbdb = new VideoGameBacklog();
		 			int vgid = vgdb.getMaxID() + 1;
		 			VideoGame VGtoAdd = new VideoGame(title,genre,rating,releaseInt,vgid," ");
		 			VideoGameBacklogItem VGBackToAdd = new VideoGameBacklogItem(vgid,title,genre,"",rating,Integer.parseInt(priority));
		 			vgdb.Insert(VGtoAdd);
		 			vgbdb.Insert(VGBackToAdd, vidEnum, rating,Integer.parseInt(priority));
		 			vbox.getChildren().set(1, loadTVTable());
        			break;
        		default:
        			System.out.println("Danger there be dragons in the Gap");
		 		
		 		}
		 			
			 
		 		addStage.close();
		    }
		 );
		 
		 addButtons.setAlignment(Pos.CENTER);
		 addButtons.setSpacing(20);
		 
		 addButtons.getChildren().addAll(addtoBacklogButton,cancelButton);
		 addBox.setBottom(addButtons);
		 
		 addStage.setScene(addScene);	
		 addStage.show();
		
	}
    
    public static void main(String[] args) {
        launch(args);
    }
}