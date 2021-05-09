package warehouse.dto;

import java.util.UUID;

public class StoreDto {

    private String name;

    private WarehouseDto warehouseDto;

    public StoreDto(String name, WarehouseDto warehouseDto) {
        this.name = name;
        this.warehouseDto = warehouseDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WarehouseDto getWarehouse() {
        return warehouseDto;
    }

    public void setWarehouse(WarehouseDto warehouseDto) {
        this.warehouseDto = warehouseDto;
    }


    @Override
    public String toString() {
        return "Store{" +
                ", name='" + name + '\'' +
                ", warehouse=" + warehouseDto.getName() +
                '}';
    }
}
