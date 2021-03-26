package di2.service;

import di2.model.Product;
import di2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product get(UUID id) {
        return productRepository.findByUid(id);
    }

    public List<Product> get(String name) {
        return productRepository.findByName(name);
    }

    public void delete(UUID id) {
        productRepository.delete(id);
    }

}
