package di2.repository;

import di2.model.Product;
import di2.model.Warehouse;

import java.util.List;
import java.util.UUID;

public interface WarehouseRepository {

    List<Warehouse> findAll();

    Warehouse findByUid(UUID uid);
}
