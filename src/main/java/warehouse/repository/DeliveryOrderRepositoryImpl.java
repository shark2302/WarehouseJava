package warehouse.repository;

import warehouse.model.DeliveryOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class DeliveryOrderRepositoryImpl implements DeliveryOrderRepository{

    private List<DeliveryOrder> data = new ArrayList<>();

    @Override
    public List<DeliveryOrder> findAll() {
        return data;
    }

    @Override
    public List<DeliveryOrder> findByWarehouseId(UUID id) {
        return data.stream().filter( p -> Objects.equals(p.getWarehouse().getUid(), id)).collect(Collectors.toList());
    }

    @Override
    public List<DeliveryOrder> findByStoreId(UUID id) {
        return data.stream().filter( p -> Objects.equals(p.getStore().getUid(), id)).collect(Collectors.toList());
    }

    @Override
    public List<DeliveryOrder> findDelivered() {
        return data.stream().filter(DeliveryOrder::isDelivered).collect(Collectors.toList());
    }

    @Override
    public List<DeliveryOrder> findNotDelivered() {
        return data.stream().filter(p -> !p.isDelivered()).collect(Collectors.toList());
    }

    @Override
    public DeliveryOrder findById(UUID id) {
        return data.stream().filter( p -> Objects.equals(p.getUid(), id)).findFirst().orElse(null);
    }

    @Override
    public void save(DeliveryOrder deliveryOrder) {
        data.add(deliveryOrder);
    }

    @Override
    public void delete(UUID id) {
        data.remove(findById(id));
    }
}
