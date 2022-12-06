package ba.unsa.etf.rpr.Models;

/**
 * Genre class represents an entity that exists in the database
 * This class represents a specific type or way how to write a book
 */

public class Genre {
    private int genreID;
    private String genreName;
    private String genreDescription;

    public Genre(int genreID, String genreName, String genreDescription) {
        this.genreID = genreID;
        this.genreName = genreName;
        this.genreDescription = genreDescription;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreDescription() {
        return genreDescription;
    }

    public void setGenreDescription(String genreDescription) {
        this.genreDescription = genreDescription;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreID=" + genreID +
                ", genreName='" + genreName + '\'' +
                ", genreDescription='" + genreDescription + '\'' +
                '}';
    }
}
