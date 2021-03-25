package di2.repository;

import di2.model.Product;
import di2.model.SalePackage;
import di2.model.Store;
import di2.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class WarehouseRepositoryImpl implements WarehouseRepository{

    private List<Warehouse> data = new ArrayList<>();

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private SalePackageRepository salePackageRepository;

    @PostConstruct
    private void init() {
        data.add(new Warehouse(salePackageRepository.findAll(), storeRepository.findAll(), 16));
    }


    @Override
    public List<Warehouse> findAll() {
        return data;
    }

    @Override
    public Warehouse findByUid(UUID uid) {
        return data.stream().filter( p -> Objects.equals(p.getUid(), uid)).findFirst().orElse(null);
    }
}
