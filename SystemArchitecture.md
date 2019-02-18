# Program Organization

Populate each section with information as it applies to your project. If a section does not apply, explain why. Include diagrams (or links to diagrams) in each section, as appropriate. For example, sketches of the user interfaces along with an explanation of how the interface components will work; ERD diagrams of the database; rough class diagrams; context diagrams showing the system boundary; etc.

# Major Classes

* **Media Class**
    
    Data Fields: genre (String), title (String), rating (float), releaseDate (int), synopsis (String), id (int), studio (String)
    
    Methods: Media(DatabaseInterface database), String getTitle(), String getGenre(), float getRating(), int getReleaseDate(), String       getSynopsis(), int getID(), String getStudio()
   
* **Movie Class extends Media Class**
    
    Data Fields: genre (String), title (String), rating (float), releaseDate(int), synopsis (String), id (int), studio (String),             director (String)
    
    Methods: Movie(DatabaseInterface database), getTitle(), getGenre(), getRating(), getReleaseDate(), getSynopsis(), getID(),               getStudio(),  getStudio(), getDirector()
    
* **TVShow Class extends Media Class**
    
    Data Fields: genre (String), title (String), rating (float), releaseDate(int), synopsis (String), id (int), studio (String),             directors (array of Strings)
    
    Methods: TVShow(DatabaseInterface database), getTitle(), getGenre(), getRating(), getReleaseDate(), getSynopsis(), getID(),             getStudio(), String getStudio(), String[] getDirectors()
    
* **Anime Class extends Media Class**
    
    Data Fields:  genre (String), title(String), rating (float), releaseDate (int), synopsis (String), id (int), studio (String)
    
    Methods: Anime (DatabaseInterface database), String getTitle(), String getGenre(), float getRating(), int getReleaseDate(), String       getSynopsis(), int getID(), String getStudio()
    
* **VideoGame Class extends Media Class**
    
    Data Fields: genre (String), title(String), rating (float), releaseDate (int), synopsis (String), id (int), studio (String),             platform (String)
    
    Methods: VideoGame(DatabaseInterface database), String getTitle(), String getGenre(), float getRating(), int getReleaseDate(),           String getSynopsis(), int getID(), String getStudio(), String getPlatform()
   

* **DatabaseInterface Class extends Media Class**
    
    Data Fields: String dbPath
    
    Methods: DatabaseInterface(String dbPath)
    
* **BacklogItem Class extends Media Class**
    
    Data Fields: int databaseID
    
    Methods: BacklogItem(Media mediaItem)
    
* **Backlog Class extends Media Class**
    
    Data Fields: BacklogItem[] backlog, int size
    
    Methods: Backlog(), editEntry(BacklogItem), void store(BacklogItem), BacklogItem 
    retrieve(), void display()


![mainpage](https://i.imgur.com/0UnzRLR.png)

# Data Design
Database ERD: ![mainpage](https://i.imgur.com/wFDEXKv.jpg)
# Business Rules
Develop an fully operacional program using the agile methodology.

# User Interface Design
Backlog View:

![mainpage](https://i.imgur.com/Wko9SKa.png)


# Resource Management
Aubrey is playing the consumer role so must of design decisions pass through him. Lucas and Austin are working with the documentation. Andrew and Caleb are doing code. 

# Security
"Get Your Shit Together" will test for SQL injections on each user input.

# Performance
Every page of the backlog is assessible within 6 clicks from every order page. Sorting and organization algorithms are on the order of n^2. The suggestions algorithms are performed within 10 seconds delay. 

# Scalability
  As the backlog gets more massive, because of the information inputted, the program itself shouldn't crash. Also additional new features for the backlog can be added. New types of backlog classes should be easy to add.        
# Interoperability
  The backlog will interact directly with the database. If a new feature can successfully interact with both database an the backlog it should be able to be implemented.


# Internationalization/Localization
Unnecessary for the scope of this project.

# Input/Output
The user should input the name of the video game/anime/movies/ and received specifications from the database as well as an organized list the classifies the current status of the game/anime/movies.   

# Error Processing
If an object searched by the user is not found in the database the user will be given an option to add a custom entry. If the item was suppose to be there the program will return an error message. Every major bug in the program will be handled by an error message since robustness is more important than correctness in this program.   
# Fault Tolerance
The backlog is robust in nature unless a major crash occur the program will not shutdown. But the program will shutdown on certain timeout conditions.

# Architectural Feasibility
The project is very feasible. The only part that might be more difficult than expected is the database, the API setup and the incentive. Since the incentive might include animation.

# Overengineering
Unnecessary features will be trimmed off. The user interface will be maintained clean as much as possible.   

# Build-vs-Buy Decisions
We will build Get Your Shit Together without buying any additional pieces of software or hardware.

# Reuse
Most of the reuse code will be accomplished by using abstract classes and oder refractoring techniques. 

# Change Strategy
Since the classes of the program are not tightly coupled it should be easy to add new features. Even starting everything from scratch if necessary.    

