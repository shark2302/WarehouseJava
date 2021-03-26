package di2.service;

import di2.model.Warehouse;
import di2.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public void save(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    public List<Warehouse> listAll() {
        return warehouseRepository.findAll();
    }

    public Warehouse get(UUID id) {
        return warehouseRepository.findByUid(id);
    }

    public void delete(UUID id) {
        warehouseRepository.delete(id);
    }
}
