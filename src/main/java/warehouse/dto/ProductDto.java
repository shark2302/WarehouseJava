package warehouse.dto;

import warehouse.model.Product;

import java.util.Objects;
import java.util.UUID;

public class ProductDto {

    private UUID uid = UUID.randomUUID();

    private String name;

    private Double price;

    private Integer shelfLife;

    public ProductDto(String name, Double price, Integer shelfLife) {
        this.name = name;
        this.price = price;
        this.shelfLife = shelfLife;
    }

    public ProductDto(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.shelfLife = product.getShelfLife();
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
        ProductDto productDto = (ProductDto) o;
        return Objects.equals(uid, productDto.uid);
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
