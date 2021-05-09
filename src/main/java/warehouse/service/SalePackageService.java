package warehouse.service;

import warehouse.dto.ProductDto;
import warehouse.dto.SalePackageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.model.Product;
import warehouse.model.SalePackage;
import warehouse.repository.ProductRepository;
import warehouse.repository.SalePackageRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class SalePackageService {

    @Autowired
    private SalePackageRepository salePackageRepository;

    /*public void save(SalePackageDto salePackageDto) {
        var productFromDb = productRepository.findByNameAndPrice(salePackageDto.getProductDto().getName(), salePackageDto.getProductDto().getPrice());
        salePackageRepository.save(new SalePackage(
        salePackageDto.getCreateDate(), salePackageDto.getCount(), productFromDb.get()));
    }*/

    public List<SalePackageDto> listAll() {
        List<SalePackageDto> res = new ArrayList<>();

        for (var sp: salePackageRepository.findAll()) {
            res.add(new SalePackageDto(sp));
        }
        return res;
    }

    public SalePackageDto get(Integer id) {

        Optional<SalePackage> spOptional = salePackageRepository.findById(id);

        return spOptional.map(SalePackageDto::new).orElse(null);
    }

    public void delete(Integer id) {
        salePackageRepository.deleteById(id);
    }
}
