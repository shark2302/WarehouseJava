package warehouse.service;

import warehouse.dto.DeliveryOrderDto;
import warehouse.dto.SalePackageDto;
import warehouse.dto.WarehouseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.model.SalePackage;
import warehouse.model.Warehouse;
import warehouse.repository.OrdersRepository;
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

    @Autowired
    private OrdersRepository ordersRepository;

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

    public void deleteWarehouse(Integer id) {
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

    public List<SalePackageDto> listAllSalePackages() {
        List<SalePackageDto> res = new ArrayList<>();

        for (var sp: salePackageRepository.findAll()) {
            res.add(new SalePackageDto(sp));
        }
        return res;
    }

    public SalePackageDto getSalePackage(Integer id) {

        Optional<SalePackage> spOptional = salePackageRepository.findById(id);

        return spOptional.map(SalePackageDto::new).orElse(null);
    }

    public void deleteSalePackage(Integer id) {
        salePackageRepository.deleteById(id);
    }


    public void deliverOrder(Integer orderId) {
        var orderOp = ordersRepository.findById(orderId);

        if(orderOp.isPresent()) {
            var order = orderOp.get();
            order.setDelivered(true);
            ordersRepository.save(order);
        }
    }

    public List<DeliveryOrderDto> getAllDeliveryOrdersForWarehouse(String warehouseName, boolean delivered) {
        var wsOp = warehouseRepository.findByName(warehouseName);
        List<DeliveryOrderDto> res = new ArrayList<>();
        if (wsOp.isPresent()) {
            var warehouse= wsOp.get();
            for (var store: warehouse.getServedStores()) {
                for (var order : ordersRepository.findByStore(store)){
                    if (order.isDelivered() == delivered)
                        res.add(new DeliveryOrderDto(order));
                }
            }

        }
        return res;
    }

}
