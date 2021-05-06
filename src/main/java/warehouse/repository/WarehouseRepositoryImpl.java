package warehouse.repository;

import warehouse.dto.WarehouseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class WarehouseRepositoryImpl implements WarehouseRepository{

    private List<WarehouseDto> data = new ArrayList<>();

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private SalePackageRepository salePackageRepository;

    @PostConstruct
    private void init() {
        data.add(new WarehouseDto(salePackageRepository.findAll(), storeRepository.findAll(), 16));
    }


    @Override
    public List<WarehouseDto> findAll() {
        return data;
    }

    @Override
    public WarehouseDto findByUid(UUID uid) {
        return data.stream().filter( p -> Objects.equals(p.getUid(), uid)).findFirst().orElse(null);
    }

    @Override
    public void save(WarehouseDto warehouseDto) {
        data.add(warehouseDto);
    }

    @Override
    public void delete(UUID uid) {
        data.remove(findByUid(uid));
    }
}
