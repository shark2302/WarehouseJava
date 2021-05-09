package warehouse.dto;

import warehouse.model.SalePackage;

import java.util.List;
import java.util.UUID;

public class SalePackageDto {


    private Integer createDate;

    private ProductDto productDto;

    private Integer count;

    public SalePackageDto(Integer createDate, ProductDto productDto, Integer count) {
        this.createDate = createDate;
        this.productDto = productDto;
        this.count = count;
    }

    public SalePackageDto(SalePackage salePackage) {
        this.createDate = salePackage.getCreateDate();
        this.productDto = new ProductDto(salePackage.getProduct());
        this.count = salePackage.getCount();
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SalePackage{" +
                "createDate=" + createDate +
                ", product=" + productDto.getName() +
                ", productsCount=" + count +
                '}';
    }
}
