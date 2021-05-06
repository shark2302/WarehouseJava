package warehouse.repository;

import warehouse.dto.WarehouseDto;

import java.util.List;
import java.util.UUID;

public interface WarehouseRepository {

    List<WarehouseDto> findAll();

    WarehouseDto findByUid(UUID uid);

    void save(WarehouseDto warehouseDto);

    void delete(UUID uid);
}
