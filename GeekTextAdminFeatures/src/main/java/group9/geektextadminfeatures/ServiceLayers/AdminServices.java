package group9.geektextadminfeatures.ServiceLayers;

import group9.geektextadminfeatures.Entities.User;
import group9.geektextadminfeatures.Entities.Wishlist;
import group9.geektextadminfeatures.Repositories.AuthorRepo;
import group9.geektextadminfeatures.Repositories.BookRepo;
import group9.geektextadminfeatures.Entities.Author;
import group9.geektextadminfeatures.Entities.Book;
import group9.geektextadminfeatures.Repositories.UserRepo;
import group9.geektextadminfeatures.Repositories.WishlistRepo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Service
public class AdminServices {

    private final BookRepo bookRepo;

    private final AuthorRepo authorRepo;

    private final WishlistRepo wishlistRepo;

    private final  UserRepo userRepo;

    public AdminServices(BookRepo bookRepo, AuthorRepo authorRepo, WishlistRepo wishlistRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.wishlistRepo = wishlistRepo;
        this.userRepo = userRepo;
    }

    //Book services/////////////////////////////////////////////////////////////////////////////////////////////

    public void addBooks(Book book){

        bookRepo.save(book);
    }

    public List<Book> showAllBooks(){
        return bookRepo.findAll();
    }

    public Book searchBookByIsbn(String isbn){
        return bookRepo.searchBookByisbnRepo(isbn);
    }

    public List<Book> searchBookByAuthor(String authorName){
        return bookRepo.searchBookByAuthorRepo(authorName);
    }
/*
    public Book searchBookByTitle(String title){
        return bookRepo.
    }
*/
    //Author Services

    public void addAuthor(Author author){
        authorRepo.save(author);
    }

    public List<Author> showAllAuthors(){
        return authorRepo.findAll();
    }

    //Book Browsing and Sorting Services/////////////////////////////////////////////////////////////////

    public List<Book> booksByGenre(String genre){
        return bookRepo.searchBookByGenre(genre);
    }

    public ArrayList<Book> topTenBestSellers(){

        List<Book> books = showAllBooks();

        List<Book> booksInOrder = bubbleSortBooksSold(books);

        System.out.println(booksInOrder.get(4));

        ArrayList<Book> topTenBooks = new ArrayList<>();

        if(booksInOrder.size() < 10){
            for (int i = 0; booksInOrder.size() > i; i++){
                topTenBooks.add(booksInOrder.get(i));

            }
        }
        else {
            for (int i = 0; 10 > i; i++) {
                topTenBooks.add(booksInOrder.get(i));

            }
        }

        return topTenBooks;
    }

    public ArrayList<Book> searchBooksByXAmount(int xAmount){

            List<Book> databaseCopy = showAllBooks();

            ArrayList<Book> xAmountOfBooks = new ArrayList<>();

            for (int i = 0; xAmount > i; i++){

                xAmountOfBooks.add(databaseCopy.get(i));
            }

            return xAmountOfBooks;
    }

    //Wishlist services/////////////////////////////////////////////////////////////////////////////
    public void addWishlist(Wishlist newwishlist,String name,String username){

        User currentUser = getUserWithUnAdPw(username);
        System.out.println(currentUser.getUsername());
    }



    //get only the current user's wishlist
    public ArrayList<Wishlist> showAllUserWishList(String username){

      List<Wishlist> allWishList = wishlistRepo.findAll();
      ArrayList<Wishlist> userWishlists = new ArrayList<>();

      for (int i = 0; allWishList.size() > i; i++){
          if(allWishList.get(i).getUser().getUsername().equals(username)){
              userWishlists.add(allWishList.get(i));
          }
      }
      return userWishlists;
    }

    public void getWishlist(String wishlistName , List<Wishlist> userWishlists,String title){

        Wishlist singleWishlist;

        for (int i = 0; i > userWishlists.size(); i++){

            if (userWishlists.get(i).getName().equals(wishlistName)){

               singleWishlist = userWishlists.get(i);


            }
        }

    }


    //User creation services

public void creatUser( User userProfile, String firstName, String lastName, String username , String password){


        ArrayList<Wishlist> startingWishlist = new ArrayList<>();

        userProfile.setWishlist(startingWishlist);
        userProfile.setFirstName(firstName);
        userProfile.setLastName(lastName);
        userProfile.setPassword(password);
        userProfile.setUsername(username);
        userRepo.insert(userProfile);
}

public User getUserWithUnAdPw(String username){

        return userRepo.getUserByUNAndPW(username);
    }


    //tools for services////////////////////////////////////////////////////////////////////////////////////////////////

//orders the list of book from most sold to least then returns the book list
    public List<Book> bubbleSortBooksSold(List<Book> a) {
        boolean sorted = false;
        Book temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < a.size() - 1; i++) {
                if (a.get(i).getBooksSold() < a.get(i + 1).getBooksSold()) {
                    temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return a;
    }



}
