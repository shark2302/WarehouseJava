package warehouse.dto;

import warehouse.model.DeliveryOrder;

import java.util.List;
import java.util.UUID;

public class DeliveryOrderDto {

    private StoreDto storeDto;

    public WarehouseDto warehouseDto;
    private SalePackageDto salePackageDto;

    private boolean delivered;


    public DeliveryOrderDto(StoreDto storeDto, SalePackageDto salePackageDto) {
        this.storeDto = storeDto;
        this.salePackageDto = salePackageDto;
        this.warehouseDto = storeDto.getWarehouse();
        delivered = false;
    }

    public DeliveryOrderDto(DeliveryOrder order) {
        this.storeDto = new StoreDto(order.getStore());
        this.salePackageDto = new SalePackageDto(order.getSalePackage());
        this.warehouseDto = storeDto.getWarehouse();
        delivered = false;
    }

    public StoreDto getStore() {
        return storeDto;
    }

    public void setStore(StoreDto storeDto) {
        this.storeDto = storeDto;
    }

    public void setWarehouse(WarehouseDto warehouseDto) {
        this.warehouseDto = warehouseDto;
    }

    public SalePackageDto getSalePackageDto() {
        return salePackageDto;
    }

    public void setSalePackageDto(SalePackageDto salePackageDto) {
        this.salePackageDto = salePackageDto;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "store=" + storeDto.getName() +
                ", salePackage=" + salePackageDto +
                '}';
    }
}
