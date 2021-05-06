package warehouse.service;

import warehouse.dto.SalePackageDto;
import warehouse.repository.SalePackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SalePackageService {

    @Autowired
    private SalePackageRepository salePackageRepository;

    public void save(SalePackageDto salePackageDto) {
        salePackageRepository.save(salePackageDto);
    }

    public List<SalePackageDto> listAll() {
        return salePackageRepository.findAll();
    }

    public SalePackageDto get(UUID id) {
        return salePackageRepository.findByUid(id);
    }

    public void delete(UUID id) {
        salePackageRepository.delete(id);
    }
}
