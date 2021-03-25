package di2.model;

import java.util.UUID;

public class Store {

    private UUID uid = UUID.randomUUID();

    private String name;

    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
