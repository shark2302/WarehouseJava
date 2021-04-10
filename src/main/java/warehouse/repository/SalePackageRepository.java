package warehouse.repository;

import warehouse.model.SalePackage;

import java.util.List;
import java.util.UUID;

public interface SalePackageRepository {

    List<SalePackage> findAll();

    SalePackage findByUid(UUID uid);

    void save(SalePackage salePackage);

    void delete(UUID id);
}
