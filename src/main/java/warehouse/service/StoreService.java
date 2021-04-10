package warehouse.service;

import warehouse.model.Store;
import warehouse.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public void save(Store store) {
        storeRepository.save(store);
    }

    public List<Store> listAll() {
        return storeRepository.findAll();
    }

    public Store get(UUID id) {
        return storeRepository.findByUid(id);
    }

    public void delete(UUID id) {
        storeRepository.delete(id);
    }

    public List<Store> getStoresWithoutWarehouse() {
        return storeRepository.findAll().stream().filter(p -> p.getWarehouse() == null).collect(Collectors.toList());
    }
}
