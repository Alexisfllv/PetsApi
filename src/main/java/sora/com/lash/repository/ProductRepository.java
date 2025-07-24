package sora.com.lash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sora.com.lash.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    //
    // Product findbyNombre(String nombre);
}
