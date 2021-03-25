package di2.model;

import java.util.Objects;
import java.util.UUID;

public class Product {

    private UUID uid = UUID.randomUUID();

    private String name;

    private Double price;

    private Integer shelfLife;

    public Product(String name, Double price, Integer shelfLife) {
        this.name = name;
        this.price = price;
        this.shelfLife = shelfLife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(uid, product.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }

    @Override
    public String toString() {
        return "Product{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", shelfLife=" + shelfLife +
                '}';
    }
}
