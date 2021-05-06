package warehouse.repository;

import warehouse.dto.DeliveryOrderDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class DeliveryOrderRepositoryImpl implements DeliveryOrderRepository{

    private List<DeliveryOrderDto> data = new ArrayList<>();

    @Override
    public List<DeliveryOrderDto> findAll() {
        return data;
    }

    @Override
    public List<DeliveryOrderDto> findByWarehouseId(UUID id) {
        return data.stream().filter( p -> Objects.equals(p.getWarehouse().getUid(), id)).collect(Collectors.toList());
    }

    @Override
    public List<DeliveryOrderDto> findByStoreId(UUID id) {
        return data.stream().filter( p -> Objects.equals(p.getStore().getUid(), id)).collect(Collectors.toList());
    }

    @Override
    public List<DeliveryOrderDto> findDelivered() {
        return data.stream().filter(DeliveryOrderDto::isDelivered).collect(Collectors.toList());
    }

    @Override
    public List<DeliveryOrderDto> findNotDelivered() {
        return data.stream().filter(p -> !p.isDelivered()).collect(Collectors.toList());
    }

    @Override
    public DeliveryOrderDto findById(UUID id) {
        return data.stream().filter( p -> Objects.equals(p.getUid(), id)).findFirst().orElse(null);
    }

    @Override
    public void save(DeliveryOrderDto deliveryOrderDto) {
        data.add(deliveryOrderDto);
    }

    @Override
    public void delete(UUID id) {
        data.remove(findById(id));
    }
}
