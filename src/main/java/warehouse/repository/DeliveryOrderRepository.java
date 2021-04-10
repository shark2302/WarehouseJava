package warehouse.repository;

import warehouse.model.DeliveryOrder;

import java.util.List;
import java.util.UUID;


public interface DeliveryOrderRepository {

    List<DeliveryOrder> findAll();

    List<DeliveryOrder> findByWarehouseId(UUID id);

    List<DeliveryOrder> findByStoreId(UUID id);

    List<DeliveryOrder> findDelivered();

    List<DeliveryOrder> findNotDelivered();

    DeliveryOrder findById(UUID id);

    void save(DeliveryOrder deliveryOrder);

    void delete(UUID id);
}
