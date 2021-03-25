package di2.model;

import java.util.List;
import java.util.UUID;

public class Warehouse {

    private UUID uid = UUID.randomUUID();

    private List<SalePackage> packages;

    private List<Store> servedStores;

    private int capacity;

    public Warehouse(List<SalePackage> packages, List<Store> servedStores, int capacity) {
        this.packages = packages;
        this.servedStores = servedStores;
        this.capacity = capacity;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public List<SalePackage> getPackages() {
        return packages;
    }

    public void setPackages(List<SalePackage> packages) {
        this.packages = packages;
    }

    public List<Store> getServedStores() {
        return servedStores;
    }

    public void setServedStores(List<Store> servedStores) {
        this.servedStores = servedStores;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "uid=" + uid +
                ", packages=" + packages +
                ", servedStores=" + servedStores +
                ", capacity=" + capacity +
                '}';
    }
}
