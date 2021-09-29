import java.util.ArrayList;

//This class defines a what a book detail must contain
public class BookDetails {

    //these variables make up a book detail
    private String title ,isbn ,bookDescription ,publisher;
    //made a arrayList of genre because some books can be categorised in more than one genre
    private ArrayList<String> genre ;
    //author is an ArrayList because there can be more than one author in the creation of a book
    private ArrayList<String> author ;
    private double price;
    //number sold is temporarily hard coded but must later be changed to automaticaly change when a book is sold
    private int numberSold;
    private int yearPublished;

    //setter
    public BookDetails(String title, String isbn, String bookDescription, ArrayList<String> author,
                       ArrayList<String> genre, String publisher,
                       double price, int numberSold, int yearPublished){

        this.title = title;
        this.isbn = isbn;
        this.bookDescription = bookDescription;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.price = price;
        this.numberSold = numberSold;
        this.yearPublished = yearPublished;
    }

    //getters
    public String getTitle(){
        return title;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getBookDescription(){
        return  bookDescription;
    }

    public ArrayList<String> getAuthor(){
        return  author;
    }

    public ArrayList<String> getGenre(){
        return  genre;
    }

    public String getPublisher(){
        return  publisher;
    }

    public double getPrice(){
        return  price;
    }

    public int getNumberSold(){
        return  numberSold;
    }

    public  int getYearPublished(){
        return  yearPublished;
    }


}
