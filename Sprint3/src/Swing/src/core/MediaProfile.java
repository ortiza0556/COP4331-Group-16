package core;

import com.google.gson.JsonArray;

public class MediaProfile {


    private String Title;

    private String Year;

    private String Rated;

    private String Released;

    private String Genre;

    private String Director;

    private String Writer;

    private String Actors;

    private String Plot;

    private String Language;

    private String Country;

    private String Awards;

    private String Poster;

    private JsonArray Ratings;

    private String Metascore;

    private String imdbRating;

    private String imdbVotes;

    private String imdbID;

    private String Type;

    private String DVD;

    private String BoxOffice;

    private String Production;


    public void setYear(String year) {
        Year = year;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public void setBoxOffice(String boxOffice) {
        BoxOffice = boxOffice;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public void setDVD(String DVD) {
        this.DVD = DVD;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public void setProduction(String production) {
        Production = production;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public void setRatings(JsonArray ratings) {
        Ratings = ratings;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }


    public String getTitle() {
        return Title;
    }

    public String getActors() {
        return Actors;
    }

    public String getAwards() {
        return Awards;
    }

    public String getBoxOffice() {
        return BoxOffice;
    }

    public String getCountry() {
        return Country;
    }

    public String getDirector() {
        return Director;
    }

    public String getDVD() {
        return DVD;
    }

    public String getGenre() {
        return Genre;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getLanguage() {
        return Language;
    }

    public String getMetascore() {
        return Metascore;
    }

    public String getPlot() {
        return Plot;
    }

    public String getPoster() {
        return Poster;
    }

    public String getProduction() {
        return Production;
    }

    public String getRated() {
        return Rated;
    }

    public String getReleased() {
        return Released;
    }

    public String getType() {
        return Type;
    }

    public String getWriter() {
        return Writer;
    }

    public String getYear() {
        return Year;
    }

    public JsonArray getRatings() {
        return Ratings;
    }
}
