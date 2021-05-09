package warehouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import warehouse.model.DeliveryOrder;
import warehouse.model.Store;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<DeliveryOrder, Integer> {
    List<DeliveryOrder> findByStore(Store store);
}
