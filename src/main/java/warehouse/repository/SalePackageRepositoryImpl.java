package warehouse.repository;

import warehouse.dto.ProductDto;
import warehouse.dto.SalePackageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class SalePackageRepositoryImpl implements SalePackageRepository{
    private List<SalePackageDto> salePackageDtos = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    private void init() {
        Random r = new Random();
        int[] sizes = new int[]{16,32,64,128};
        //List<ProductDto> productDtos = productRepository.findAll();
        /*for (int i = 0; i < productDtos.size(); i++) {
            ProductDto[] arr = new ProductDto[sizes[r.nextInt(sizes.length)]];
            Arrays.fill(arr, productDtos.get(i));
            salePackageDtos.add(new SalePackageDto(0, Arrays.asList(arr)));
        }*/
    }

    @Override
    public List<SalePackageDto> findAll() {
        return salePackageDtos;
    }

    @Override
    public SalePackageDto findByUid(UUID uid) {
        return salePackageDtos.stream().filter(p -> Objects.equals(p.getUid(), uid)).findFirst().orElse(null);
    }

    @Override
    public void save(SalePackageDto salePackageDto) {
        salePackageDtos.add(salePackageDto);
    }

    @Override
    public void delete(UUID id) {
        salePackageDtos.remove(findByUid(id));
    }
}
