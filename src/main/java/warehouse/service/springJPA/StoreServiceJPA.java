package warehouse.service.springJPA;

import org.springframework.stereotype.Service;
import warehouse.dto.DeliveryOrderDto;
import warehouse.dto.ProductDto;
import warehouse.dto.StoreDto;
import warehouse.model.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StoreServiceJPA {

    @PersistenceContext
    private EntityManager em;

    public void save(StoreDto storeDto) {
        TypedQuery<Warehouse> warehouseTypedQuery = em.createQuery(
                "select warehouse from Warehouse warehouse where warehouse.name = :name", Warehouse.class).
                setParameter("name", storeDto.getWarehouse().getName());
        Warehouse warehouse = warehouseTypedQuery.getSingleResult();
        em.persist(new Store(storeDto.getName(), warehouse));
    }

    public List<StoreDto> listAll() {
        List<StoreDto> res = new ArrayList<>();
        TypedQuery<Store> stores = em.createQuery("select store from Store store", Store.class);
        for (var store: stores.getResultList()) {
            res.add(new StoreDto(store));
        }
        return res;
    }

    public StoreDto get(Integer id) {
        Store store = em.find(Store.class, id);
        return new StoreDto(store);
    }

    public void delete(Integer id) {
        Store store = em.find(Store.class, id);
        em.remove(store);
    }

    public void createDeliveryOrder(String storeName, Integer salePackageId) {
        TypedQuery<Store> storeQuery = em.createQuery(
                "select store from Store store where store.name = :name", Store.class)
                .setParameter("name", storeName);
        SalePackage pack = em.find(SalePackage.class, salePackageId);
        Store store = storeQuery.getSingleResult();
        if(store != null && pack != null) {
            if(!store.getWarehouse().getSalePackages().contains(pack))
                return;
            em.persist(new DeliveryOrder(store, pack));
        }
    }

    public List<DeliveryOrderDto> getAllDeliveryOrdersForStore(String storeName, boolean delivered) {
        TypedQuery<Store> storeQuery = em.createQuery(
                "select store from Store store where store.name = :name", Store.class)
                .setParameter("name", storeName);
        Store store = storeQuery.getSingleResult();
        List<DeliveryOrderDto> res = new ArrayList<>();

        if(store != null) {
            TypedQuery<DeliveryOrder> orderQuery = em.createQuery("select o from DeliveryOrder o where o.store.id = :storeId", DeliveryOrder.class)
                    .setParameter("storeId", store.getId());
            for (var order: orderQuery.getResultList()) {
                if(order.isDelivered() == delivered)
                    res.add(new DeliveryOrderDto(order));
            }
        }
        return res;
    }

}
