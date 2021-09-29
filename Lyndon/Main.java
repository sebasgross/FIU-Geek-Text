import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //dummy code to test out the Bookdeatails ArrayList

        String tempString;
        double tempDouble;
        int tempInt;
        Scanner read = new Scanner(System.in);
        BookDataBase bookDataBase = new BookDataBase();
        GenreType genreList = new GenreType();
        Author authorList = new Author();
        BookDetails bd;

        String title ,isbn ,bookDescription ,publisher;
        double price;
        int numberSold, yearPublished;
        ArrayList<String> g = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();

        BookDataBase bookDataBase1 = new BookDataBase();

        System.out.print("Do you want to add a new book admin? (Y/N)");
        tempString = read.nextLine();

        while( "Y".equals(tempString)){
            System.out.print("GENRE: ");
            g = genreList.setGenre();

            System.out.print("TITLE: ");
            title = read.nextLine();

            System.out.print("AUTHOR: ");
            a = authorList.addAuthors();

            System.out.print("ISBN: ");
            isbn = read.nextLine();

            System.out.print("DESCRIPTION: ");
            bookDescription = read.nextLine();

            System.out.print("PUBLISHER: ");
            publisher = read.nextLine();

            System.out.print("PRICE: ");
            price = read.nextDouble();

            System.out.print("BOOKS SOLD: ");
            numberSold = read.nextInt();

            System.out.print("PUBLICATION YEAR: ");
            yearPublished = read.nextInt();

            bd = new BookDetails(title,isbn,bookDescription,a,g,publisher,price,numberSold,yearPublished);
            bookDataBase1.addBookDetails(bd);

        }
    }
}
