package warehouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import warehouse.model.SalePackage;

@Repository
public interface SalePackageRepository extends CrudRepository<SalePackage, Integer> {
}
