package di2.repository;

import di2.model.Product;
import di2.model.Store;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class StoreRepositoryImpl implements StoreRepository{

    private List<Store> data = Arrays.asList(new Store("Magnit"),
            new Store("Pyaterochka"));

    @Override
    public List<Store> findAll() {
        return data;
    }

    @Override
    public List<Store> findByName(String name) {
        return data.stream().filter( p -> Objects.equals(p.getName(), name)).collect(Collectors.toList());
    }

    @Override
    public Store findByUid(UUID uid) {
        return data.stream().filter( p -> Objects.equals(p.getUid(), uid)).findFirst().orElse(null);
    }
}
