package group9.geektextadminfeatures.Repositories;

import group9.geektextadminfeatures.Entities.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepo extends MongoRepository<Author, String> {



}
