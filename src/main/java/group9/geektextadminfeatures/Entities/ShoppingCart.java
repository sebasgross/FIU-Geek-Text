package group9.geektextadminfeatures.Entities;

import group9.geektextadminfeatures.Entities.Book;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;

@Data
@Document(collection = "shoppingcart")
public class ShoppingCart {
    @Id
    private Integer id = 45189741;
    private String userName = "Billy";
    private ArrayList<Book> cart = new ArrayList<Book>();

    public void addToCart(Book book){
        cart.add(book);
    }

    public void removeFromCart(Book book){
        for(int count = 0; count < cart.size(); count++){
            if(cart.get(count).getIsbn().equals(book.getIsbn())){
                cart.remove(count);
            }
        }
    }

	public String getUserName() {
		return userName;
	}

}