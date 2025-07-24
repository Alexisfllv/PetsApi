package sora.com.lash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sora.com.lash.model.Breed;
import sora.com.lash.model.Pets;


public interface BreedRepository extends MongoRepository<Breed, String> {
}
