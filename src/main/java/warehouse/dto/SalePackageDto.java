package warehouse.dto;

import java.util.List;
import java.util.UUID;

public class SalePackageDto {

    private UUID uid = UUID.randomUUID();

    private Integer createDate;

    private List<ProductDto> productDtos;

    public SalePackageDto(Integer createDate, List<ProductDto> productDtos) {
        this.createDate = createDate;
        this.productDtos = productDtos;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public List<ProductDto> getProducts() {
        return productDtos;
    }

    public void setProducts(List<ProductDto> productDtos) {
        this.productDtos = productDtos;
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
                ", product=" + productDtos.get(0).getName() +
                ", productsCount=" + productDtos.size() +
                '}';
    }
}
