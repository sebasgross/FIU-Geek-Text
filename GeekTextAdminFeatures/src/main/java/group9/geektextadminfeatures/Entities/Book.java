package group9.geektextadminfeatures.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "bookcatalog")
public class Book {

    @Id
    Integer bookID;

    private String bookTitle;

    private String authorName;

    private String bookDescription;

    private String genre;

    private int yearPublished;

    @Indexed(unique = true)
    private String isbn;

    private String publisher;

    private double price;

    private int booksSold;

    public Book(Integer bookID, String bookTitle, String authorName, String bookDescription, String genre, int yearPublished, String isbn, String publisher, double price, int booksSold) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.bookDescription = bookDescription;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.publisher = publisher;
        this.price = price;
        this.booksSold = booksSold;
    }


    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBooksSold() {
        return booksSold;
    }

    public void setBooksSold(int booksSold) {
        this.booksSold = booksSold;
    }
}
