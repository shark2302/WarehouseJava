package warehouse.repository;

import warehouse.dto.SalePackageDto;

import java.util.List;
import java.util.UUID;

public interface SalePackageRepository {

    List<SalePackageDto> findAll();

    SalePackageDto findByUid(UUID uid);

    void save(SalePackageDto salePackageDto);

    void delete(UUID id);
}
