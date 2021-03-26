package di2.service;

import di2.model.SalePackage;
import di2.model.Store;
import di2.repository.StoreRepository;
import di2.repository.StoreRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

}
