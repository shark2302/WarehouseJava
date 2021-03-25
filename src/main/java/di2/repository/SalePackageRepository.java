package di2.repository;

import di2.model.SalePackage;

import java.util.List;
import java.util.UUID;

public interface SalePackageRepository {

    List<SalePackage> findAll();

    SalePackage findByUid(UUID uid);
}
