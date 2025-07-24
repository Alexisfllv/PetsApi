package sora.com.lash.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sora.com.lash.model.Product;
import sora.com.lash.repository.ProductRepository;
import sora.com.lash.service.ProductoService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> listarTodos() {
        return productRepository.findAll();
    }

    @Override
    public Product buscarId(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(String id, Product product) {
        Optional<Product> existing = productRepository.findById(id);

        if (existing.isEmpty()) {
            throw new RuntimeException("Product with id " + id + " not found");
        }

        product.setId(id); // aseguramos que se actualice el correcto
        return productRepository.save(product);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
