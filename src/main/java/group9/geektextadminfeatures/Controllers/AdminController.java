package group9.geektextadminfeatures.Controllers;

import group9.geektextadminfeatures.Entities.User;
import group9.geektextadminfeatures.Entities.Wishlist;
import group9.geektextadminfeatures.ServiceLayers.AdminServices;
import group9.geektextadminfeatures.Entities.Author;
import group9.geektextadminfeatures.Entities.Book;
import group9.geektextadminfeatures.Entities.ShoppingCart;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Geek_Text")
public class AdminController {

    private final AdminServices adminS;

    public AdminController(AdminServices adminS) {
        this.adminS = adminS;
    }

    //Book admin http request

    @PostMapping("/bookcatalog/add_books")
    public void abbBookToDB(@RequestBody final List<Book> bookList) {


        List<Book> idmaker;

      for (int i = 0; bookList.size() > i; i++){

          idmaker = showAllBooks();
          int size;
          int id;

          if(showAllBooks().isEmpty()){
              id = 1;
          }
          else {
               size = idmaker.size()-1;
               id = idmaker.get(size).getBookID()+1;
          }


          bookList.get(i).setBookID(id);

          adminS.addBooks(bookList.get(i));
      }

    }

    @GetMapping("/bookcatalog/show_all")
    public List<Book> showAllBooks(){
        return adminS.showAllBooks();
    }

    @GetMapping("/bookcatalog/isbn_search/{isbn}")
    public Book lookUpByIsbn(@PathVariable String isbn){
        return adminS.searchBookByIsbn(isbn);
    }

    @GetMapping("/bookcatalog/author_search/{authorName}")
    public List<Book> showAllAuthorBooks(@PathVariable String authorName){
        return adminS.searchBookByAuthor(authorName);
    }

    //Author http request

    @PostMapping("/authorcatalog/add_author")
    public void addAuthorToDB(@RequestBody List<Author> authorList){

        List<Author> idmaker;

        for (int i = 0; authorList.size() > i; i++){

            idmaker = showAllAuthors();
            int size;
            int id;

            if(showAllAuthors().isEmpty()){
                id = 1;
            }
            else {
                size = idmaker.size()-1;
                id = idmaker.get(size).getAutorID()+1;
            }


            authorList.get(i).setAutorID(id);

            adminS.addAuthor(authorList.get(i));
        }
    }

    @GetMapping("/authorcatalog/show_all")
    public List<Author> showAllAuthors(){
        return adminS.showAllAuthors();
    }

    //Book Browsing and Sorting http endpoints


    @GetMapping("/bookcatalog/BestSellers")
    public List<Book> showTopTenBooks(){
        return adminS.topTenBestSellers();
    }

    @GetMapping("/bookcatalog/genre_search/{genre}")
    public List<Book> showBooksByGenre(@PathVariable String genre){
        return adminS.booksByGenre(genre);
    }

    @GetMapping("/bookcatalog/show_x_ammount/{xAmmount}")
    public List<Book> showBooksByXAmmount(@PathVariable Integer xAmmount){
        return adminS.searchBooksByXAmount(xAmmount);
    }
    /*
    public List<Book> showBooksByRating(String stars){

    }
     */

    //Wish List Management

    //Create Wishlist
    @PostMapping("/wishlist/create_wishlist")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewWishList(@RequestBody final List<Wishlist> wishlistList){
    	
        List<Wishlist> idmaker;

        for (int i = 0; wishlistList.size() > i; i++){

            idmaker = showAllWishlist();
            int size;
            int id;

            if(showAllWishlist().isEmpty()){
                id = 1;
            }
            else {
                size = idmaker.size()-1;
                id = idmaker.get(size).getId()+1;
            }

            wishlistList.get(i).setId(id);

            adminS.addWishlist(wishlistList.get(i));
        }
        
    }
    
	//Get all wishlist
    @GetMapping("/wishlist/show_all")
    public List<Wishlist> showAllWishlist(){
        return adminS.showAllWishlists();
    }
    
    //get wishlist with username
    @GetMapping("/wishlist/{user}")
    public List<Wishlist> searchUserWishlist(@PathVariable String user) {
    	return adminS.findUserWishlist(user);
    }
    
    //Get wishlist with name
    @GetMapping("/wishlist/one/{name}")
    public Wishlist searchUserWishlistOne(@PathVariable String name) {
    	return adminS.findUserWishlistOne(name);
    }
    
    
    
    //Add book to wishlist
    //The easy way
	@PutMapping("/wishlist/update_wishlist")
	public void addBookToWishlist(@RequestBody Wishlist wishlist) {
		adminS.updateWishlist(wishlist);
	}
	
	//The better way
    @PostMapping("/wishlist/add/bookisbn=/{isbn}/name=/{name}/user=/{user}")
    public void addToWishlist(@PathVariable String isbn, @PathVariable String name, @PathVariable String user){
        List<Wishlist> allWishlists = adminS.showAllWishlists();
        for(int count = 0; count < allWishlists.size(); count++){
            if(allWishlists.get(count).getName().equals(name)){ //Checks for Wishlist Name
            	if (allWishlists.get(count).getUser().equals(user)) { //Checks for Username
            		adminS.addBookToWishlist(allWishlists.get(count), isbn);
            	}   
            }
        }

    }
    
    //Remove the book from wishlist
    @PostMapping("/wishlist/remove/bookisbn=/{isbn}/name=/{name}/user=/{user}")
    public void removeFromWishlist(@PathVariable String isbn, @PathVariable String name, @PathVariable String user){
        List<Wishlist> allWishlists = adminS.showAllWishlists();
        for(int count = 0; count < allWishlists.size(); count++){
            if(allWishlists.get(count).getName().equals(name)){ //Checks for Wishlist Name
            	if (allWishlists.get(count).getUser().equals(user)) { //Checks for Username
            		adminS.removeBookFromWishlist(allWishlists.get(count), isbn);
            	}   
            }
        }
    }

    //User Controller

    @PostMapping("/user/sign-up/firstname=/{firstname}/lastname=/{lastname}/username=/{username}/password=/{password}")
    public void makeUser(User user, @PathVariable String firstname, @PathVariable String lastname,
                         @PathVariable String username, @PathVariable String password){

        adminS.creatUser(user,firstname,lastname,username,password);
    }

    @GetMapping("/sign-in/username=/{_id}")
    public User getConfirmUser(@PathVariable String _id){
      return  adminS.getUserWithUN(_id);
    }

    //Shopping Cart Controller
    @PostMapping("/shoppingcart/createshoppingcart/")
    public void createShoppingCart(ShoppingCart shoppingCart){
        adminS.addShoppingCart(shoppingCart);
    }

    @PostMapping("/shoppingcart/addtoshoppingcart/bookisbn=/{isbn}/username=/{firstname}")
    public void addToShoppingCart(@PathVariable String isbn, @PathVariable String firstname){
        List<ShoppingCart> allCarts = adminS.findAllShoppingCarts();
        for(int count = 0; count < allCarts.size(); count++){
            if(allCarts.get(count).getUserName().equals(firstname)){
                adminS.addBookToCart(allCarts.get(count), isbn);
            }
        }

    }

    @PostMapping("/shoppingcart/removefromshoppingcart/bookisbn=/{isbn}/username=/{firstname}")
    public void removeFromShoppingCart(@PathVariable String isbn, @PathVariable String firstname){
        List<ShoppingCart> allCarts = adminS.findAllShoppingCarts();
        for(int count = 0; count < allCarts.size(); count++){
            if(allCarts.get(count).getUserName().equals(firstname)){
                adminS.removeBookFromCart(allCarts.get(count), isbn);
            }
        }
    }

    @GetMapping("/shoppingcart/viewshoppingcarts/username=/{firstname}")
    public ShoppingCart viewShoppingCarts(@PathVariable String firstname){
        List<ShoppingCart> allCarts = adminS.findAllShoppingCarts();
        for(int count = 0; count < allCarts.size(); count++){
            if(allCarts.get(count).getUserName().equals(firstname)){
                return adminS.findAllShoppingCarts().get(count);
            }
        }
        return null;
    }

}
