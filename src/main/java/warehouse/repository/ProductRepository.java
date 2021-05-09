package warehouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import warehouse.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByName(String name);

    Optional<Product> findByNameAndPrice(String name, Double price);
}
