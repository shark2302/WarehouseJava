package warehouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import warehouse.model.Store;

import java.util.Optional;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {
    Optional<Store> findByName(String name);
}
