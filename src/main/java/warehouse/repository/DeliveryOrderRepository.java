package warehouse.repository;

import warehouse.dto.DeliveryOrderDto;

import java.util.List;
import java.util.UUID;


public interface DeliveryOrderRepository {

    List<DeliveryOrderDto> findAll();

    List<DeliveryOrderDto> findByWarehouseId(UUID id);

    List<DeliveryOrderDto> findByStoreId(UUID id);

    List<DeliveryOrderDto> findDelivered();

    List<DeliveryOrderDto> findNotDelivered();

    DeliveryOrderDto findById(UUID id);

    void save(DeliveryOrderDto deliveryOrderDto);

    void delete(UUID id);
}
