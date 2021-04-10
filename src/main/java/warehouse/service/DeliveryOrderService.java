package warehouse.service;

import warehouse.model.DeliveryOrder;
import warehouse.model.Store;
import warehouse.model.Warehouse;
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

    public void save(DeliveryOrder deliveryOrder) {
        deliveryOrderRepository.save(deliveryOrder);
    }

    public List<DeliveryOrder> listAll() {
        return deliveryOrderRepository.findAll();
    }

    public DeliveryOrder get(UUID id) {
        return deliveryOrderRepository.findById(id);
    }

    public void delete(UUID id) {
        deliveryOrderRepository.delete(id);
    }

    public List<DeliveryOrder> getAllForStore(Store store) {
        return deliveryOrderRepository.findByStoreId(store.getUid());
    }

    public List<DeliveryOrder> getDeliveredForStore(Store store) {
        return deliveryOrderRepository.findDelivered().stream().filter(p -> Objects.equals(store.getUid(), p.getStore().getUid())).collect(Collectors.toList());
    }

    public List<DeliveryOrder> getNotDeliveredForStore(Store store) {
        return deliveryOrderRepository.findNotDelivered().stream().filter(p -> Objects.equals(store.getUid(), p.getStore().getUid())).collect(Collectors.toList());
    }

    public List<DeliveryOrder> getAllForWarehouse(Warehouse warehouse) {
        return deliveryOrderRepository.findByStoreId(warehouse.getUid());
    }

    public List<DeliveryOrder> getDeliveredForWarehouse(Warehouse warehouse) {
        return deliveryOrderRepository.findDelivered().stream().filter(p -> Objects.equals(warehouse.getUid(), p.getWarehouse().getUid())).collect(Collectors.toList());
    }

    public List<DeliveryOrder> getNotDeliveredForWarehouse(Warehouse warehouse) {
        return deliveryOrderRepository.findNotDelivered().stream().filter(p -> Objects.equals(warehouse.getUid(), p.getWarehouse().getUid())).collect(Collectors.toList());
    }

}
