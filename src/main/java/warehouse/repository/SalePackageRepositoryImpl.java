package warehouse.repository;

import warehouse.model.Product;
import warehouse.model.SalePackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class SalePackageRepositoryImpl implements SalePackageRepository{
    private List<SalePackage> salePackages = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    private void init() {
        Random r = new Random();
        int[] sizes = new int[]{16,32,64,128};
        List<Product> products = productRepository.findAll();
        for (int i = 0; i < products.size(); i++) {
            Product[] arr = new Product[sizes[r.nextInt(sizes.length)]];
            Arrays.fill(arr, products.get(i));
            salePackages.add(new SalePackage(0, Arrays.asList(arr)));
        }
    }

    @Override
    public List<SalePackage> findAll() {
        return salePackages;
    }

    @Override
    public SalePackage findByUid(UUID uid) {
        return salePackages.stream().filter( p -> Objects.equals(p.getUid(), uid)).findFirst().orElse(null);
    }

    @Override
    public void save(SalePackage salePackage) {
        salePackages.add(salePackage);
    }

    @Override
    public void delete(UUID id) {
        salePackages.remove(findByUid(id));
    }
}
