package warehouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import warehouse.model.SalePackage;

import java.util.Optional;

@Repository
public interface SalePackageRepository extends CrudRepository<SalePackage, Integer> {
}
