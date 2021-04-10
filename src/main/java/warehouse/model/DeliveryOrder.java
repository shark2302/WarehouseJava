package warehouse.model;

import java.util.List;
import java.util.UUID;

public class DeliveryOrder {

    private UUID uid = UUID.randomUUID();

    private Store store;

    private Warehouse warehouse;

    private List<SalePackage> salePackages;

    private boolean delivered;


    public DeliveryOrder(Store store, Warehouse warehouse, List<SalePackage> salePackages) {
        this.store = store;
        this.warehouse = warehouse;
        this.salePackages = salePackages;
        delivered = false;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<SalePackage> getSalePackages() {
        return salePackages;
    }

    public void setSalePackages(List<SalePackage> salePackages) {
        this.salePackages = salePackages;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "store=" + store.getName() +
                ", warehouse=" + warehouse.getUid() +
                ", salePackages=" + salePackages +
                '}';
    }
}
