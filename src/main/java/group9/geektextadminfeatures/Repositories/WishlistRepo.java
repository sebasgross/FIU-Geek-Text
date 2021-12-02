package group9.geektextadminfeatures.Repositories;

import group9.geektextadminfeatures.Entities.Wishlist;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface WishlistRepo extends MongoRepository<Wishlist, Integer> {
	
	//search for wihslist with user
    @Query("{'user' : ?0}")
    List<Wishlist> searchUserWishlist(String user);
    
    @Query("{'name' : ?0}")
    Wishlist searchUserWishlistOne(String name);

	
}
