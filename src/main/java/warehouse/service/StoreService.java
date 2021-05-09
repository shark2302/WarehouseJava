package warehouse.service;

import warehouse.dto.DeliveryOrderDto;
import warehouse.dto.StoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.dto.WarehouseDto;
import warehouse.model.DeliveryOrder;
import warehouse.model.Store;
import warehouse.model.Warehouse;
import warehouse.repository.OrdersRepository;
import warehouse.repository.SalePackageRepository;
import warehouse.repository.StoreRepository;
import warehouse.repository.WarehouseRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private SalePackageRepository salePackageRepository;


    public void save(StoreDto storeDto) {
        var wsOptional = warehouseRepository.findByName(storeDto.getWarehouse().getName());
        wsOptional.ifPresent(warehouse -> storeRepository.save(new Store(storeDto.getName(), warehouse)));
    }

    public List<StoreDto> listAll() {
        List<StoreDto> res = new ArrayList<>();

        for (var store: storeRepository.findAll()) {
            res.add(new StoreDto(store));
        }
        return res;
    }

    public StoreDto get(Integer id) {
        Optional<Store> storeOptional = storeRepository.findById(id);

        return storeOptional.map(StoreDto::new).orElse(null);
    }

    public void delete(Integer id) {
        storeRepository.deleteById(id);
    }

    public void createDeliveryOrder(String storeName, Integer salePackageId) {
        var storeOptional = storeRepository.findByName(storeName);
        var packOptional = salePackageRepository.findById(salePackageId);

        if(storeOptional.isPresent() && packOptional.isPresent()) {
            var store = storeOptional.get();
            var pack = packOptional.get();
            if(!store.getWarehouse().getSalePackages().contains(pack))
                return;
            ordersRepository.save(new DeliveryOrder(store, pack));
        }
    }

    public List<DeliveryOrderDto> getAllDeliveryOrdersForStore(String storeName, boolean delivered) {
        var storeOp = storeRepository.findByName(storeName);
        List<DeliveryOrderDto> res = new ArrayList<>();
        if(storeOp.isPresent()) {
            for (var order: ordersRepository.findByStore(storeOp.get())) {
                if(order.isDelivered() == delivered)
                    res.add(new DeliveryOrderDto(order));
            }
        }
        return res;
    }

}
