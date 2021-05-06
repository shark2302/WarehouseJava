package warehouse.dto;

import java.util.UUID;

public class StoreDto {

    private UUID uid = UUID.randomUUID();

    private String name;

    private WarehouseDto warehouseDto;

    public StoreDto(String name) {
        this.name = name;
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

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Store{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                '}';
    }
}
