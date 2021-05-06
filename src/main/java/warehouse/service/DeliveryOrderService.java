package warehouse.service;

import warehouse.dto.DeliveryOrderDto;
import warehouse.dto.StoreDto;
import warehouse.dto.WarehouseDto;
import warehouse.repository.DeliveryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeliveryOrderService {

    @Autowired
    private DeliveryOrderRepository deliveryOrderRepository;

    public void save(DeliveryOrderDto deliveryOrderDto) {
        deliveryOrderRepository.save(deliveryOrderDto);
    }

    public List<DeliveryOrderDto> listAll() {
        return deliveryOrderRepository.findAll();
    }

    public DeliveryOrderDto get(UUID id) {
        return deliveryOrderRepository.findById(id);
    }

    public void delete(UUID id) {
        deliveryOrderRepository.delete(id);
    }

    public List<DeliveryOrderDto> getAllForStore(StoreDto storeDto) {
        return deliveryOrderRepository.findByStoreId(storeDto.getUid());
    }

    public List<DeliveryOrderDto> getDeliveredForStore(StoreDto storeDto) {
        return deliveryOrderRepository.findDelivered().stream().filter(p -> Objects.equals(storeDto.getUid(), p.getStore().getUid())).collect(Collectors.toList());
    }

    public List<DeliveryOrderDto> getNotDeliveredForStore(StoreDto storeDto) {
        return deliveryOrderRepository.findNotDelivered().stream().filter(p -> Objects.equals(storeDto.getUid(), p.getStore().getUid())).collect(Collectors.toList());
    }

    public List<DeliveryOrderDto> getAllForWarehouse(WarehouseDto warehouseDto) {
        return deliveryOrderRepository.findByStoreId(warehouseDto.getUid());
    }

    public List<DeliveryOrderDto> getDeliveredForWarehouse(WarehouseDto warehouseDto) {
        return deliveryOrderRepository.findDelivered().stream().filter(p -> Objects.equals(warehouseDto.getUid(), p.getWarehouse().getUid())).collect(Collectors.toList());
    }

    public List<DeliveryOrderDto> getNotDeliveredForWarehouse(WarehouseDto warehouseDto) {
        return deliveryOrderRepository.findNotDelivered().stream().filter(p -> Objects.equals(warehouseDto.getUid(), p.getWarehouse().getUid())).collect(Collectors.toList());
    }

}
