package warehouse.repository;

import warehouse.dto.StoreDto;

import java.util.List;
import java.util.UUID;

public interface StoreRepository {

    List<StoreDto> findAll();

    List<StoreDto> findByName(String name);

    StoreDto findByUid(UUID uid);

    void save(StoreDto storeDto);

    void delete(UUID uid);
}
