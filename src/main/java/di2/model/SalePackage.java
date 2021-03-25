package di2.model;

import java.util.List;
import java.util.UUID;

public class SalePackage {

    private UUID uid = UUID.randomUUID();

    private Integer createDate;

    private List<Product> products;

    public SalePackage(Integer createDate, List<Product> products) {
        this.createDate = createDate;
        this.products = products;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "SalePackage{" +
                "uid=" + uid +
                ", createDate=" + createDate +
                ", product=" + products.get(0).getName() +
                ", productsCount=" + products.size() +
                '}';
    }
}
