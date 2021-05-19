package warehouse.service.springJPA;

import org.springframework.stereotype.Service;
import warehouse.dto.DeliveryOrderDto;
import warehouse.dto.SalePackageDto;
import warehouse.dto.StoreDto;
import warehouse.dto.WarehouseDto;
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
public class WarehouseServiceJPA {

    @PersistenceContext
    private EntityManager em;

    public void save(WarehouseDto warehouseDto) {

        em.persist(new Warehouse(warehouseDto.getName(), warehouseDto.getCapacity()));
    }

    public List<WarehouseDto> listAll()
    {
        List<WarehouseDto> res = new ArrayList<>();
        TypedQuery<Warehouse> query = em.createQuery("select warehouse from Warehouse warehouse", Warehouse.class);
        for (var wh: query.getResultList()) {
            res.add(new WarehouseDto(wh));
        }
        return res;
    }

    public WarehouseDto get(Integer id) {
        Warehouse warehouse = em.find(Warehouse.class, id);
        return warehouse != null ? new WarehouseDto(warehouse) : null;
    }

    public void deleteWarehouse(Integer id) {
        Warehouse warehouse = em.find(Warehouse.class, id);
        if(warehouse != null)
            em.remove(warehouse);
    }

    public void addSalePackageToWarehouse(Integer id, SalePackageDto salePackageDto) {

        Warehouse warehouse = em.find(Warehouse.class, id);
        if(warehouse != null && warehouse.getCapacity() > warehouse.getSalePackages().size()) {

            TypedQuery<Product> productsQuery = em.createQuery(
                    "select product from Product product where product.name = :name and product.price = :price", Product.class).
                    setParameter("name", salePackageDto.getProductDto().getName()).setParameter("price", salePackageDto.getProductDto().getPrice());
            Product p = productsQuery.getSingleResult();

            if(p != null) {
                em.persist(new SalePackage(
                        salePackageDto.getCreateDate(), salePackageDto.getCount(), p, warehouse));
            }
        }
    }

    public List<SalePackageDto> listAllSalePackages() {
        List<SalePackageDto> res = new ArrayList<>();
        TypedQuery<SalePackage> query = em.createQuery("select pack from SalePackage pack", SalePackage.class);
        for (var sp: query.getResultList()) {
            res.add(new SalePackageDto(sp));
        }
        return res;
    }

    public SalePackageDto getSalePackage(Integer id) {

        SalePackage salePackage = em.find(SalePackage.class, id);
        return salePackage != null ? new SalePackageDto(salePackage) : null;
    }

    public void deleteSalePackage(Integer id) {
        SalePackage salePackage = em.find(SalePackage.class, id);
        if(salePackage != null)
            em.remove(salePackage);
    }


    public void deliverOrder(Integer orderId) {
        DeliveryOrder order = em.find(DeliveryOrder.class, orderId);

        if(order != null) {
            order.setDelivered(true);
            em.persist(order);
        }
    }

    public List<DeliveryOrderDto> getAllDeliveryOrdersForWarehouse(String warehouseName, boolean delivered) {

        TypedQuery<Warehouse> warehouseTypedQuery = em.createQuery(
                "select warehouse from Warehouse warehouse where warehouse.name = :name", Warehouse.class).
                setParameter("name", warehouseName);
        Warehouse warehouse = warehouseTypedQuery.getSingleResult();
        List<DeliveryOrderDto> res = new ArrayList<>();
        if (warehouse != null) {
            for (var store: warehouse.getServedStores()) {
                TypedQuery<DeliveryOrder> orderQuery = em.createQuery("select o from DeliveryOrder o where o.store.id = :storeId", DeliveryOrder.class)
                        .setParameter("storeId", store.getId());
                for (var order : orderQuery.getResultList()){
                    if (order.isDelivered() == delivered)
                        res.add(new DeliveryOrderDto(order));
                }
            }

        }
        return res;
    }
}
