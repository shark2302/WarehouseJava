package warehouse.repository;

import warehouse.model.Store;

import java.util.List;
import java.util.UUID;

public interface StoreRepository {

    List<Store> findAll();

    List<Store> findByName(String name);

    Store findByUid(UUID uid);

    void save(Store store);

    void delete(UUID uid);
}