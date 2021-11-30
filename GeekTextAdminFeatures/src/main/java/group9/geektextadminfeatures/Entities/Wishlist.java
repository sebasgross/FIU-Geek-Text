package group9.geektextadminfeatures.Entities;

import java.util.List;

public class Wishlist {

    private User user;
    private String name;
    private List<Book> bookList;

    public Wishlist( User user, String name,  List<Book> bookList) {

        this.user = user;
        this.name = name;
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}