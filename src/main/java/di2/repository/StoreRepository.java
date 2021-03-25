package di2.repository;

import di2.model.Product;
import di2.model.Store;

import java.util.List;
import java.util.UUID;

public interface StoreRepository {

    List<Store> findAll();

    List<Store> findByName(String name);

    Store findByUid(UUID uid);
}
