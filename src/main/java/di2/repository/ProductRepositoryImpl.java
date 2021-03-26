package di2.repository;

import di2.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> data = new ArrayList<>();


    @PostConstruct
    private void init() {
        data.add(new Product("Milk", 10d, 10));
        data.add(new Product("Apple", 30d, 50));
        data.add(new Product("Bread", 15d, 5));
        data.add(new Product("Cheese", 40d, 20));
    }


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

