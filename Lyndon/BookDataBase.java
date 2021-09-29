import java.util.ArrayList;

public class BookDataBase {

   private ArrayList<BookDetails> DataBase = new ArrayList<>();
    private  BookDetails bookDets;
    static final String jdbcDriver = "com.mysql.BookDataBase.Driver";
    static final String DB_URL = "jdbc:mysql://localhost";
    public void addBookDetails(BookDetails bookDets) {

        DataBase.add(bookDets);

   }

   public void printOutBookDetails(){

   }


}
