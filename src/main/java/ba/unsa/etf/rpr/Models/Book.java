package ba.unsa.etf.rpr.Models;

import ba.unsa.etf.rpr.Date;

/**
 * Book class represents an entity that exists in the database
 */

public class Book {
    private int bookID;
    private String bookName;
    private Date published;
    private String bookAuthor;
    private String bookDescription;
    private User user;
    private Genre genre;

    public Book(
            int bookID, String bookName, Date published, String bookAuthor, String bookDescription, User user,
            Genre genre
    ) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.published = published;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.user = user;
        this.genre = genre;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", published=" + published +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", user=" + user +
                ", genre=" + genre +
                '}';
    }
}
