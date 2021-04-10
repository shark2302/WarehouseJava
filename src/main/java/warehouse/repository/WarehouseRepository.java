package warehouse.repository;

import warehouse.model.Warehouse;

import java.util.List;
import java.util.UUID;

public interface WarehouseRepository {

    List<Warehouse> findAll();

    Warehouse findByUid(UUID uid);

    void save(Warehouse warehouse);

    void delete(UUID uid);
}
