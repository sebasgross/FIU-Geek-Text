package group9.geektextadminfeatures.Entities;

import java.util.ArrayList;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "wishlists")
public class Wishlist {
	
    @Id
    Integer id;
	private String user;
    private String name;
    private ArrayList<Book> bookList = new ArrayList<Book>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
    
    public void addToWishlist(Book book) {
    	bookList.add(book); 
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public void removeFromWishlist(Book book){
        for(int count = 0; count < bookList.size(); count++){
            if(bookList.get(count).getIsbn().equals(book.getIsbn())){
            	bookList.remove(count);
            }
        }
    }

}