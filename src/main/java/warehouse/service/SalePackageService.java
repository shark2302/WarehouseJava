package warehouse.service;

import warehouse.model.SalePackage;
import warehouse.repository.SalePackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SalePackageService {

    @Autowired
    private SalePackageRepository salePackageRepository;

    public void save(SalePackage salePackage) {
        salePackageRepository.save(salePackage);
    }

    public List<SalePackage> listAll() {
        return salePackageRepository.findAll();
    }

    public SalePackage get(UUID id) {
        return salePackageRepository.findByUid(id);
    }

    public void delete(UUID id) {
        salePackageRepository.delete(id);
    }
}
