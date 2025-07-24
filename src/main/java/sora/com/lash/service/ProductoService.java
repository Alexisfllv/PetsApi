package sora.com.lash.service;

import sora.com.lash.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    //list
    List<Product> listarTodos();
    // findby
    Product buscarId(String id);
    // save
    Product save(Product product);
    // modificar
    Product update(String id, Product product);
    // eliminar
    void delete(String id);
}
