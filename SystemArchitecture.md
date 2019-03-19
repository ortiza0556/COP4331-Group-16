# Program Organization

Populate each section with information as it applies to your project. If a section does not apply, explain why. Include diagrams (or links to diagrams) in each section, as appropriate. For example, sketches of the user interfaces along with an explanation of how the interface components will work; ERD diagrams of the database; rough class diagrams; context diagrams showing the system boundary; etc.

# Major Classes

* **Media Class (ABC)**
    
    Data Fields: genre (String), title (String), rating (float), releaseDate (int), plot (String), id (int), studio (String)
    
    Methods: String getTitle(), String getGenre(), String getRating(), int getReleaseDate(), String getPlot(), int getID(), String      getStudio()
   
* **Movie Class extends Media Class**
    
    Data Fields: directors(String[]), all data fields inherited from Media
    
    Methods: Movie(title, genre, rating, releaseDate, plot, studio, String directors), Movie(title, genre, rating, releaseDate, plot, id, studio, String directors), String[] getDirectors(), and all the get methods inherited from Media
    
* **TVShow Class extends Media Class**
    
    Data Fields: creators(String[]), all data fields inherited from Media
    
    Methods: TVShow(title, genre, rating, releaseDate, plot, studio, String creators), TVShow(title, genre, rating, releaseDate, plot, id, studio, String creators), String[] getCreators(), and all the get methods inherited from Media
    
* **Anime Class extends Media Class**
    
    Data Fields: all data fields inherited from Media
    
    Methods: Anime(title, genre, rating, releaseDate, plot, studio), Anime(title, genre, rating, releaseDate, plot, id, studio), and all the get methods inherited from Media
    
* **VideoGame Class extends Media Class**
    
    Data Fields: platforms (String[])
    
    Methods: VideoGame(title, genre, rating, releaseDate, plot, studio, String platforms), VideoGame(title, genre, rating, releaseDate, plot, id, studio, String platforms), String[] getPlatform(), and all the get methods inherited from Media
   

* **Database Class < M extends Media > (ABC)**
    
    Data Fields: Filepath fp, String filePath = fp.getFilePath()
    
    Methods: abstract void connect(), abstract void close(), abstract void Insert(M m), abstract void ObservableList<M> Search(String title)
    
* **MovieDatabase Class extends Database< Movie >**
    
    Data Fields: Connection conn, String resultText
    
    Methods: MovieDatabase(), connect, close, Insert(Movie m), Search(Stri 
    
* **Backlog Class**
    
    Data Fields: BacklogItem[] backlog, int size
    
    Methods: Backlog(), editEntry(BacklogItem), void store(BacklogItem), BacklogItem 
    retrieve(), void display()


![mainpage](https://i.imgur.com/0UnzRLR.png)

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
