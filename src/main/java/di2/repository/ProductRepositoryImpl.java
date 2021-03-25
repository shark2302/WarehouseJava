package di2.repository;

import di2.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> data = Arrays.asList(new Product("Milk", 10d, 10),
            new Product("Apple", 30d, 50),
            new Product("Bread", 15d, 5),
            new Product("Cheese", 40d, 20));

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public List<Product> findByName(String name) {
        return data.stream().filter( p -> Objects.equals(p.getName(), name)).collect(Collectors.toList());
    }

    @Override
    public Product findByUid(UUID uid) {
        return data.stream().filter( p -> Objects.equals(p.getUid(), uid)).findFirst().orElse(null);
    }

    @Override
    public void save(Product product) {
        data.add(product);
    }

    @Override
    public void delete(UUID uid) {
        data.remove(findByUid(uid));
    }


}

