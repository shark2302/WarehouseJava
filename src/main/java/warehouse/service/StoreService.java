package warehouse.service;

import warehouse.dto.StoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.dto.WarehouseDto;
import warehouse.model.Store;
import warehouse.model.Warehouse;
import warehouse.repository.StoreRepository;
import warehouse.repository.WarehouseRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    public void save(StoreDto storeDto) {
        var wsOptional = warehouseRepository.findByName(storeDto.getWarehouse().getName());
        wsOptional.ifPresent(warehouse -> storeRepository.save(new Store(storeDto.getName(), warehouse)));
    }

    public List<StoreDto> listAll() {
        List<StoreDto> res = new ArrayList<>();

        for (var store: storeRepository.findAll()) {
            res.add(new StoreDto(store));
        }
        return res;
    }

    public StoreDto get(Integer id) {
        Optional<Store> storeOptional = storeRepository.findById(id);

        return storeOptional.map(StoreDto::new).orElse(null);
    }

    public void delete(Integer id) {
        storeRepository.deleteById(id);
    }
}
