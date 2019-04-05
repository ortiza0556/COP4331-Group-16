# Program Organization

Populate each section with information as it applies to your project. If a section does not apply, explain why. Include diagrams (or links to diagrams) in each section, as appropriate. For example, sketches of the user interfaces along with an explanation of how the interface components will work; ERD diagrams of the database; rough class diagrams; context diagrams showing the system boundary; etc.
# Architecture Diagram
![mainpage](https://i.imgur.com/sjq0oRE.jpg)

**Description**
    Get your Shit Together pulls data from three major data centers using thier rest apis. Movie and TV Show data is fetched from IMDB, Videgame data from IGDB, and Anime data from MyAnimeList. This information is stored in a SQLite databse. Users will construct backlogs of shows to watch using the UI, which will be stored in a relational table within the database. Using the JDBC library, java code will be able to insert, delete, update, and fetch these relational backlog items so that the user can easily view media they have watched or wish to watch in the future. GYST will also use data gathered through the rest API to create recommendations for the user based on media they have watched/played in the past.
    
**User Stories**
	The ability for a user to quickly update and view backlogs through the UI is related to user stories 6,7,8,9,15,16,17,18,19,30, and 31.
	Recommendations are made using the data that we gather through the rest API from various data centers. This relates to user stories 11,12,13, and 14.
	SQLite was chosen as the databse since the program only has to support one user at a time. SQLite is generally faster at performing queries since it is all file transactions rather than socket transactions. This relates to user story 36.
	Using JDBC driver for Java allows the user to easily interact with the database, which allows for things like recommendations to be found for the user. This relates to user stories 20,21, and 22.

# Major Classes

* **Media Class (ABC)**
    
    Data Fields: genre (String), title (String), rating (String), id (int), releaseDate (int)
    
    Methods: String getTitle(), String getGenre(), String getRating(), int getReleaseDate(), int getID()
    
    Description: Media class is an abstract base class with data fields shared by the 4 media types for this project, and has all of the associated get functions for each field.
   
* **Movie Class extends Media Class**
    
    Data Fields: directors(String), all data fields inherited from Media
    
    Methods: Movie(title, genre, rating, releaseDate, String directors), Movie(title, genre, rating, releaseDate, id,String directors), String getDirectors(), and all the get methods inherited from Media
    
    Description: Movie class extends the Media class, but adds a data field for directors and releaseDate.
    
* **TVShow Class extends Media Class**
    
    Data Fields: directors(String), all data fields inherited from Media
    
    Methods: TVShow(title, genre, rating, releaseDate, directors), TVShow(title, genre, rating, releaseDate, id, directors), String getDirectors(), and all the get methods inherited from Media
    
    Description: TVShow class extends the Media class, but adds a data field for directors and releaseDate.
    
* **Anime Class extends Media Class**
    
    Data Fields: all data fields inherited from Media
    
    Methods: Anime(title, genre, rating), Anime(title, genre, rating, id), and all the get methods inherited from Media
    
    Description: Anime class extends the Media class.
    
* **VideoGame Class extends Media Class**
    
    Data Fields: platforms (String), all data fields inherited from Media
    
    Methods: VideoGame(title, genre, rating, releaseDate, plot, studio, String platforms), VideoGame(title, genre, rating, releaseDate, plot, id, studio, String platforms), String[] getPlatforms(), and all the get methods inherited from Media
    
    Description: VideoGame class extends the Media class, but adds a data field for platforms. This will be used to create VideoGame objects to add to the database, when we pull from the rest APIs.
   

* **Database Class < M extends Media > (ABC)**
    
    Data Fields: Filepath fp, String filePath = fp.getFilePath()
    
    Methods: abstract void connect(), abstract void close(), abstract void Insert(M m)
    
    Description: An abstract base class with filepath data fields, and 4 methods for each of the database classes to implement/override.
    
* **MovieDatabase Class extends Database< Movie >**
    
    Data Fields: Connection conn, String resultText, also filepath from the Database Class
    
    Methods: MovieDatabase(), connect, close, Insert(Movie m)
    
    Description: MovieDatabase extends Database and offers it's own implementations of its abstract methods. Will be used to add Movie objects to the SQLite database.
        
* **TVShowDatabase Class extends Database< TVShow >**
    
    Data Fields: Connection conn, String resultText, also filepath from the Database Class
    
    Methods: TVShowDatabase(), connect, close, Insert(TVShow t)
    
    Description: TVShowDatabase extends Database and offers it's own implementations of its abstract methods. Will be used to add TVShow objects to the SQLite database.
    
* **AnimeDatabase Class extends Database< Anime >**
    
    Data Fields: Connection conn, String resultText, also filepath from the Database Class
    
    Methods: AnimeDatabase(), connect, close, Insert(Anime t)
    
    Description: AnimeDatabase extends Database and offers it's own implementations of its abstract methods. Will be used to add Anime objects to the SQLite database.
    
* **VideoGameDatabase Class extends Database< Video Game >**
    
    Data Fields: Connection conn, String resultText, also filepath from the Database Class
    
    Methods: VideoGameDatabase(), connect, close, Insert(VideoGame t)
    
    Description: VideoGameDatabase extends Database and offers it's own implementations of its abstract methods. Will be used to add VideoGame objects to the SQLite database.
 
* **MovieBacklogItem Class**
    
    Data Fields: int id, SimpleStringProperty title, SimpleStringProperty genre, SimpleStringProperty status, SimpleStringProperty rating, SimpleStringProperty priority 
    
    Methods: MovieBacklogItem(int id, String title, String genre, String status, String rating, int priority), String getTitle, String getGenre(), String getStatus(), String getRating(), int getPriority(), int getID() 
    
    Description: Used to store information from the Movies_Backlog table in the database so they can be easily displayed on the GUI.

* **TVShowBacklogItem Class**
    
    Data Fields: int id, SimpleStringProperty title, SimpleStringProperty genre, SimpleStringProperty status, SimpleStringProperty rating, SimpleStringProperty priority 
    
    Methods: TVShowBacklogItem(int id, String title, String genre, String status, String rating, int priority), String getTitle, String getGenre(), String getStatus(), String getRating(), int getPriority(), int getID()
    
    Description: Used to store information from the TVShows_Backlog table in the database so they can be easily displayed on the GUI.

* **AnimeBacklogItem Class**
    
    Data Fields: int id, SimpleStringProperty title, SimpleStringProperty genre, SimpleStringProperty status, SimpleStringProperty rating, SimpleStringProperty priority 
    
    Methods: AnimeBacklogItem(int id, String title, String genre, String status, String rating, int priority), String getTitle, String getGenre(), String getStatus(), String getRating(), int getPriority(), int getID()
    
    Description: Used to store information from the Anime_Backlog table in the database so they can be easily displayed on the GUI.

* **VideoGameBacklogItem Class**
    
    Data Fields: int id, SimpleStringProperty title, SimpleStringProperty genre, SimpleStringProperty status, SimpleStringProperty rating, SimpleStringProperty priority 
    
    Methods: VideoGameBacklogItem(int id, String title, String genre, String status, String rating, int priority), String getTitle, String getGenre(), String getStatus(), String getRating(), int getPriority(), int getID()
    
    Description: Used to store information from the VideoGames_Backlog table in the database so they can be easily displayed on the GUI.

* **MovieBacklog Class**
    
    Data Fields: Connection conn, Filepath fp, String filepath
    
    Methods: MovieBacklog(), connect(), close(), Insert(MovieBacklogItem m, WatchableMediaStatus s, String userRating, int priority), Delete(MovieBacklogItem a), Update(MovieBacklogItem m), ObservableList< MovieBacklogItem > fetchAll()
    
    Description: Used to interact with the Movies_Backlog table in the database (insertion, deletion, updates, fetching).

* **TVShowBacklog Class**
    
    Data Fields: Connection conn, Filepath fp, String filepath
    
    Methods: TVShowBacklog(), connect(), close(), Insert(TVShowBacklogItem t, WatchableMediaStatus s, String userRating, int priority), Delete(TVShowBacklogItem t), Update(TVShowBacklogItem t), ObservableList< TVShowBacklogItem > fetchAll()
    
    Description: Used to interact with the TVShows_Backlog table in the database (insertion, deletion, updates, fetching).

* **AnimeBacklog Class**
    
    Data Fields: Connection conn, Filepath fp, String filepath
    
    Methods: AnimeBacklog(), connect(), close(), Insert(AnimeBacklogItem a, WatchableMediaStatus s, String userRating, int priority), Delete(AnimeBacklogItem a), Update(AnimeBacklogItem a), ObservableList< AnimeBacklogItem > fetchAll()
    
    Description: Used to interact with the Anime_Backlog table in the database (insertion, deletion, updates, fetching).

* **VideoGameBacklog Class**
    
    Data Fields: Connection conn, Filepath fp, String filepath
    
    Methods: VideoGameBacklog(), connect(), close(), Insert(VideoGameBacklogItem v, VideoGameStatus s, String userRating, int priority), Delete(VideoGameBacklogItem v), Update(VideoGameBacklogItem v), ObservableList< VideoGameBacklogItem > fetchAll()
    
    Description: Used to interact with the VideoGames_Backlog table in the database (insertion, deletion, updates, fetching).
    
* **GetYourShitTogether Class**
    
    Data Fields: String mediaTypeDisplayed, AnimeBacklog animeBacklog, TVShowBacklog tvBacklog, VideoGameBacklog vgBacklog, MovieBacklog movieBacklog, VBox vbox
    
    Methods: start(Stage primaryStage), addUIControls(VBox vbox, String mediaType), InitializeButtonPane(VBox vbox), TableView< TVShowBacklogItem > loadTVTable(), TableView< MovieBacklogItem > loadMovieTable(), TableView< AnimeBacklogItem > loadAnimeTable(), TableView< VideoGameBacklogItem > loadVideoGameTable(), InitializeBottomButtons(VBox vbox)
    
    Description: The main class of the program, defines the GUI and uses the other classes to interact with the database and display relevant information.
    
* **AnimeRecommendations**
    
    Data Fields: animeBacklogSize(int), numCompletedWithHighRating (int), numRecommendations (int), conn (Connection) fp (FilePath), filePath (String)
    
    Methods: AnimeRecommendations(), ObservableList< Anime > getRecommendations(), connect(), close()
    
    Description: Used to return recommendations for anime based on the user's anime backlog.
    
* **MovieRecommendations**
    
    Data Fields: movieBacklogSize(int), numCompletedWithHighRating (int), numRecommendations (int), conn (Connection) fp (FilePath), filePath (String)
    
    Methods: MovieRecommendations(), ObservableList< Movie > getRecommendations(), connect(), close()
    
    Description: Used to return recommendations for movies based on the user's movie backlog.

* **TVShowRecommendations**
    
    Data Fields: tvShowBacklogSize(int), numCompletedWithHighRating (int), numRecommendations (int), conn (Connection) fp (FilePath), filePath (String)
    
    Methods: TVShowRecommendations(), ObservableList< TVShow > getRecommendations(), connect(), close()
    
    Description: Used to return recommendations for TV shows based on the user's TVShow backlog.

* **VideoGameRecommendations**
    
    Data Fields: videoGameBacklogSize(int), numCompletedWithHighRating (int), numRecommendations (int), conn (Connection) fp (FilePath), filePath (String)
    
    Methods: VideoGameRecommendations(), ObservableList< VideoGame > getRecommendations(), connect(), close()
    
    Description: Used to return recommendations for video games based on the user's video games backlog.

* **AnimeSearch**

    Data Fields: conn (Connection) fp (FilePath), filePath (String)
    
    Methods: AnimeSearch(), ObservableList< Anime > search(String title), connect(), close()
    
    Description: Used to search the anime table in the database, and return the search results set as an observable list to display to the user.
    
* **MovieSearch**

    Data Fields: conn (Connection) fp (FilePath), filePath (String)
    
    Methods: MovieSearch(), ObservableList< Movie > search(String title), connect(), close()
    
    Description: Used to search the movie table in the database, and return the search results set as an observable list to display to the user.
    
* **TVShowSearch**

    Data Fields: conn (Connection) fp (FilePath), filePath (String)
    
    Methods: TVShowSearch(), ObservableList< TVShow > search(String title), connect(), close()
    
    Description: Used to search the TV show table in the database, and return the search results set as an observable list to display to the user.
    
* **VideoGameSearch**

    Data Fields: conn (Connection) fp (FilePath), filePath (String)
    
    Methods: VideoGameSearch(), ObservableList< VideoGame > search(String title), connect(), close()
    
    Description: Used to search the video game table in the database, and return the search results set as an observable list to display to the user.

# Media Classes Diagram
![mainpage](https://i.imgur.com/H3FIgB3.png)

# Database Classes Diagram
![mainpage](https://i.imgur.com/Bf1vKxB.png)

# Backlog Classes Diagram
![mainpage](https://i.imgur.com/bqzDTy0.png)

# Backlog Item Classes Diagram
![mainpage](https://i.imgur.com/3Wux1BE.png)

# Class Diagram
![mainpage](https://i.imgur.com/okLCWHh.png)

# Data Design
Database ERD: ![mainpage](https://i.imgur.com/wFDEXKv.jpg)

# Business Rules
Covered in "Requirements" document.

# User Interface Design
* Backlog View:

![mainpage](https://i.imgur.com/ogjqQ0s.png)

* Recommendation View:

![mainpage](https://i.imgur.com/AQMipDW.png)

* Badge View

![mainpage](https://i.imgur.com/WL3nzk9.png)

# Description of User Interface
  The very top of the application will have the title displayed to the left (“Get Your Shit Together”) and a minimize, full screen, 	and exit button to the right. The top far-left tabs have buttons for Badges, Recommendations, and Backlogs. Clicking on the Badges button will show the interface containing badges. Clicking on the Recommendations button will show a table of recommendations (with Title, Genre, Release, and Rating column headers) for the currently selected media type. Clicking on the Backlogs button will show a table of backlog entries (with Title, Genre, Status, Rating, and Priority column headers) for the currently selected media type. 
    The search media bar has a search label next to a text field. Pressing enter with the search media text field active will filter media results in the current table to those matching the text.
    The top far-right series of tabs for Anime, Movies, TV Shows, and video games. Clicking on any of the tabs will change the currently selected media type to that type.
    In the center is a table of media entries that when clicked on will become selected (to edit or drop). Clicking on any of the column headers will sort entries in the table by that type.
    When Backlog view is selected, the bottom tabs will have buttons for Add Media, Drop Media, and Edit Media. Clicking Add Media will allow the user to add media to the backlog. Clicking Delete Media will delete the entry for the currently selected media in the backlog. Clicking Edit Media will allow the user to edit the currently selected media in the backlog.


   The user stories formed the basis of the UI design process. The use of a card based view to switch between the categories satisfies the need to access the individual data bases with the press of a button(030). The ability to sort the data by any of a number of different criteria is also accounted for(025). The Recommend page provides the framework for user stories(11,12,13,14). The backlog page was designed to show the list of items that have been finished, and those that need to be watched, depending on the active card(15,16,17,18). 
# Resource Management

**Time**
  
  * Meetings will occur mostly on discord, unless otherwise needed. These meetings will ideally take place two to three times a week.
  * Project members are expect to complete work in a timely manner. Any roadblocks or issues will be addressed during meetings.

**Computer Resources**

  * Github will be used for source control.
  * Coding will be done on personal computers.
  
**Money**

  * We will be using open-source software, so no software licenses will be needed.
  * No additional hardware needed.

# Security
"Get Your Shit Together" will test for SQL injections on each user input.

# Performance
 Information pulls from the database, as well as edits and updates should be optimized in order to minimize the amount of waiting a user experiences while using the application. Ideally no databse interaction should take longer than 500ms. Sorting of data will be done using the built in Java sorting algoritms, which offer O(nlogn) performance on most datasets. (Arrays.sort is a tuned Quick Sort and Collections.sort is Merge Sort)

# Scalability
As the backlog gets more massive, because of the information inputted, the program itself shouldn't crash. Also additional new features for the backlog can be added. New types of backlog classes should be easy to add.

# Interoperability
"Get Your Shit Together" will directly interact with our database, which will store all of the media we pull from different sources using APIs, and the user's personal backlogs.

# Internationalization/Localization
Unnecessary for the scope of this project.

# Input/Output
Input would be taken from the user when they search for a piece of media to add to their backlog. Input is also taken from the user when they add or edit an entry. Output is everything we display on the screen, including the backlogs, recommendations, media, and the UI.   

# Error Processing
If an object searched by the user is not found in the database the user will be given an option to add a custom entry, which allows us to avoid any "entry not found" errors.

# Fault Tolerance
The backlog is robust in nature unless a major crash occurs the program will not shutdown, however the program will shutdown on certain timeout conditions.

# Architectural Feasibility
The API setup will be difficult, as there are a few API we will need to use to gather entries.

# Overengineering
Unnecessary features will be trimmed off and the user interface will be maintained as clean as possible.   

# Build-vs-Buy Decisions
We will build Get Your Shit Together without buying any additional pieces of software or hardware.

# Reuse
Most of the set up for each backlog will be the same, so code has the potential to be reused between them. Recommendations will also follow the same algorithm, so this code will be reused for each media type.

# Change Strategy
Since the classes of the program are not tightly coupled it should be easy to add new features if necessary.
