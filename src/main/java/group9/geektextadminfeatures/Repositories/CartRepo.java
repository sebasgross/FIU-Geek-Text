package group9.geektextadminfeatures.Repositories;

import group9.geektextadminfeatures.Entities.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepo extends MongoRepository<ShoppingCart, Integer> {

}
