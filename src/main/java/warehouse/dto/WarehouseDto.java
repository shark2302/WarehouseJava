package warehouse.dto;

import warehouse.model.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WarehouseDto {

    private String name;

    private List<SalePackageDto> packages;

    private List<StoreDto> servedStoreDtos;

    private int capacity;

    public WarehouseDto(String name, List<SalePackageDto> packages, List<StoreDto> servedStoreDtos, int capacity) {
        this.name = name;
        this.packages = packages;
        this.servedStoreDtos = servedStoreDtos;
        this.capacity = capacity;
        for (var store: servedStoreDtos) {
            store.setWarehouse(this);
        }
    }

    public WarehouseDto(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public WarehouseDto(Warehouse warehouse) {
        this.name = warehouse.getName();
        this.capacity = warehouse.getCapacity();
        List<SalePackageDto> salePackageDtos = new ArrayList<>();

        for (var sp: warehouse.getSalePackages()) {
            salePackageDtos.add(new SalePackageDto(sp));
        }
        this.packages = salePackageDtos;

        List<StoreDto> storesDtos = new ArrayList<>();
        for (var sp: warehouse.getServedStores()) {
            storesDtos.add(new StoreDto(sp.getName(), this));
        }
        this.servedStoreDtos = storesDtos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "WarehouseDto{" +
                "name='" + name + '\'' +
                ", packages=" + packages +
                ", servedStoreDtos=" + servedStoreDtos +
                ", capacity=" + capacity +
                '}';
    }
}
