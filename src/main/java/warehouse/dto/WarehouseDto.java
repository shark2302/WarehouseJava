package warehouse.dto;

import java.util.List;
import java.util.UUID;

public class WarehouseDto {

    private UUID uid = UUID.randomUUID();

    private List<SalePackageDto> packages;

    private List<StoreDto> servedStoreDtos;

    private int capacity;

    public WarehouseDto(List<SalePackageDto> packages, List<StoreDto> servedStoreDtos, int capacity) {
        this.packages = packages;
        this.servedStoreDtos = servedStoreDtos;
        this.capacity = capacity;
        for (var store: servedStoreDtos) {
            store.setWarehouse(this);
        }
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public List<SalePackageDto> getPackages() {
        return packages;
    }

    public void setPackages(List<SalePackageDto> packages) {
        this.packages = packages;
    }

    public List<StoreDto> getServedStores() {
        return servedStoreDtos;
    }

    public void setServedStores(List<StoreDto> servedStoreDtos) {
        this.servedStoreDtos = servedStoreDtos;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addServedStore(StoreDto storeDto) {
        servedStoreDtos.add(storeDto);
        storeDto.setWarehouse(this);
    }

    public void completeOrder(DeliveryOrderDto deliveryOrderDto) {
        packages.removeAll(deliveryOrderDto.getSalePackages());
        deliveryOrderDto.setDelivered(true);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "uid=" + uid +
                ", packages=" + packages +
                ", servedStores=" + servedStoreDtos +
                ", capacity=" + capacity +
                '}';
    }
}
