package group9.geektextadminfeatures.Entities;

import java.util.List;

public class ShoppingCart {

    private List<Book> checkInBooks;

    public ShoppingCart(List<Book> checkInBooks) {
        this.checkInBooks = checkInBooks;
    }

    public List<Book> getCheckInBooks() {
        return checkInBooks;
    }

    public void setCheckInBooks(List<Book> checkInBooks) {
        this.checkInBooks = checkInBooks;
    }
}
