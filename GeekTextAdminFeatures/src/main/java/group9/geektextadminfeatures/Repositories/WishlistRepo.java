package group9.geektextadminfeatures.Repositories;

import group9.geektextadminfeatures.Entities.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishlistRepo extends MongoRepository<Wishlist, Integer> {
}
