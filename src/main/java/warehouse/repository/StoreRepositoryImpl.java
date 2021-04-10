package warehouse.repository;

import warehouse.model.Store;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StoreRepositoryImpl implements StoreRepository{

    private List<Store> data = new ArrayList<>();

    @PostConstruct
    private void init() {
        data.add(new Store("Magnit"));
        data.add(new Store("Pyaterochka"));
    }

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

    @Override
    public void save(Store store) {
        data.add(store);
    }

    @Override
    public void delete(UUID uid) {
        data.remove(findByUid(uid));
    }
}
