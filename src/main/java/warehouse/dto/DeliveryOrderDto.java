package warehouse.dto;

import java.util.List;
import java.util.UUID;

public class DeliveryOrderDto {

    private UUID uid = UUID.randomUUID();

    private StoreDto storeDto;

    private WarehouseDto warehouseDto;

    private List<SalePackageDto> salePackageDtos;

    private boolean delivered;


    public DeliveryOrderDto(StoreDto storeDto, WarehouseDto warehouseDto, List<SalePackageDto> salePackageDtos) {
        this.storeDto = storeDto;
        this.warehouseDto = warehouseDto;
        this.salePackageDtos = salePackageDtos;
        delivered = false;
    }

    public StoreDto getStore() {
        return storeDto;
    }

    public void setStore(StoreDto storeDto) {
        this.storeDto = storeDto;
    }

    public WarehouseDto getWarehouse() {
        return warehouseDto;
    }

    public void setWarehouse(WarehouseDto warehouseDto) {
        this.warehouseDto = warehouseDto;
    }

    public List<SalePackageDto> getSalePackages() {
        return salePackageDtos;
    }

    public void setSalePackages(List<SalePackageDto> salePackageDtos) {
        this.salePackageDtos = salePackageDtos;
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
                "store=" + storeDto.getName() +
                ", warehouse=" + warehouseDto.getUid() +
                ", salePackages=" + salePackageDtos +
                '}';
    }
}
