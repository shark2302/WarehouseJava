package warehouse.service;

import warehouse.dto.SalePackageDto;
import warehouse.dto.WarehouseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.model.SalePackage;
import warehouse.model.Warehouse;
import warehouse.repository.ProductRepository;
import warehouse.repository.SalePackageRepository;
import warehouse.repository.WarehouseRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private SalePackageRepository salePackageRepository;

    @Autowired
    private ProductRepository productRepository;

    public void save(WarehouseDto warehouseDto) {

        warehouseRepository.save(new Warehouse(warehouseDto.getName(), warehouseDto.getCapacity()));
    }

    public List<WarehouseDto> listAll()
    {
        List<WarehouseDto> res = new ArrayList<>();

        for (var wh: warehouseRepository.findAll()) {
            res.add(new WarehouseDto(wh));
        }
        return res;
    }

    public WarehouseDto get(Integer id) {

        Optional<Warehouse> whOptional = warehouseRepository.findById(id);

        return whOptional.map(WarehouseDto::new).orElse(null);
    }

    public void delete(Integer id) {
        warehouseRepository.deleteById(id);
    }

    public void addSalePackageToWarehouse(Integer id, SalePackageDto salePackageDto) {

        var warehouse = warehouseRepository.findById(id);
        if(warehouse.isPresent() && warehouse.get().getCapacity() > warehouse.get().getSalePackages().size()) {

            var productFromDb = productRepository.findByNameAndPrice(salePackageDto.getProductDto().getName(),
                    salePackageDto.getProductDto().getPrice());

            salePackageRepository.save(new SalePackage(
                    salePackageDto.getCreateDate(), salePackageDto.getCount(), productFromDb.get(), warehouse.get()));
        }
    }


}
