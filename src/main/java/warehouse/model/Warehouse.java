package warehouse.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private Integer capacity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse")
    private List<SalePackage> salePackages;

    public Warehouse() {
    }

    public Warehouse(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<SalePackage> getSalePackages() {
        return salePackages;
    }

    public void setSalePackages(List<SalePackage> salePackages) {
        this.salePackages = salePackages;
    }
}
