package di2.repository;

import di2.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {

    List<Product> findAll();

    List<Product> findByName(String name);

    Product findByUid(UUID uid);

    void save(Product product);

    void delete(UUID uid);

}
