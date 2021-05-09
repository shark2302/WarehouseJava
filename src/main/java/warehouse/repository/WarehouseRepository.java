package warehouse.repository;

import org.springframework.data.repository.CrudRepository;
import warehouse.model.Warehouse;

import java.util.Optional;

public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {
    Optional<Warehouse> findByName(String name);
}
