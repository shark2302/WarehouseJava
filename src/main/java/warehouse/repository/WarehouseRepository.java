package warehouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import warehouse.model.Warehouse;

import java.util.Optional;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {
    Optional<Warehouse> findByName(String name);
}
