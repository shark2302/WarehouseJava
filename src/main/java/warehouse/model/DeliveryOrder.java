package warehouse.model;

import warehouse.dto.SalePackageDto;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "sale_package_id")
    private SalePackage salePackage;

    @Column(name = "delivered")
    private boolean isDelivered;

    public DeliveryOrder() {
    }

    public DeliveryOrder(Store store, SalePackage salePackage) {
        this.store = store;
        this.salePackage = salePackage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public SalePackage getSalePackage() {
        return salePackage;
    }

    public void setSalePackage(SalePackage salePackage) {
        this.salePackage = salePackage;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }
}
