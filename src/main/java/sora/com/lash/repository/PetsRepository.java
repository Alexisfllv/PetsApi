package sora.com.lash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sora.com.lash.model.Pets;


public interface PetsRepository extends MongoRepository<Pets, String> {
}
