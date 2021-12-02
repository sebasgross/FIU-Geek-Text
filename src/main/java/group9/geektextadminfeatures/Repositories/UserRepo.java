package group9.geektextadminfeatures.Repositories;

import group9.geektextadminfeatures.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepo extends MongoRepository<User,String> {

    @Query("{'_id' : ?0 }")
    User getUserByUNAndPW(String u);

}
