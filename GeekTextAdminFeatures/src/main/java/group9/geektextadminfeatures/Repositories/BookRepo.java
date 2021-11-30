package group9.geektextadminfeatures.Repositories;

import group9.geektextadminfeatures.Entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepo extends MongoRepository<Book,String> {

    //custom repository methods

    //search book database
    @Query("{'isbn' : ?0}")
    Book searchBookByisbnRepo(String i);

    //search all books a author has made
    @Query("{'authorName' : ?0}")
    List<Book> searchBookByAuthorRepo(String a);

   // @Query("{'title' : ?0}")

    //=================================Book Browsing and Sorting========================================================
    //Book Browsing and Sorting custom methods

    @Query("{'genre' : ?0}")
    List<Book> searchBookByGenre(String g);

}

