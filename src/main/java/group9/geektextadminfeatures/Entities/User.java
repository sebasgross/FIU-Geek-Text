package group9.geektextadminfeatures.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "GeekTextUsers")
public class User {

    @Id
    private String username;
    private String firstName;
    private String lastName;
    //set the user amount of wishlist to the max of 3
    private List<Wishlist> wishlist;
    private String password;

    public User( String firstName, String lastName, List<Wishlist> wishlist, String username, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.wishlist = wishlist;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Wishlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Wishlist> wishlist) {
        this.wishlist = wishlist;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
