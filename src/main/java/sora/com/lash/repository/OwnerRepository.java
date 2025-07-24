package sora.com.lash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sora.com.lash.model.Breed;
import sora.com.lash.model.Owner;


public interface OwnerRepository extends MongoRepository<Owner, String> {
}
