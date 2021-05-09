package warehouse.model;

import javax.persistence.*;

@Entity
@Table(name = "sale_packages")
public class SalePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_date")
    private Integer createDate;

    @Column(name = "count")
    private Integer count;

    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    public SalePackage() {
    }

    public SalePackage(Integer createDate, Integer count, Product product, Warehouse warehouse) {
        this.createDate = createDate;
        this.count = count;
        this.product = product;
        this.warehouse = warehouse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "SalePackage{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", count=" + count +
                ", product=" + product +
                '}';
    }
}
