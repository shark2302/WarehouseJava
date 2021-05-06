package warehouse.service;

import warehouse.dto.WarehouseDto;
import warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public void save(WarehouseDto warehouseDto) {
        warehouseRepository.save(warehouseDto);
    }

    public List<WarehouseDto> listAll() {
        return warehouseRepository.findAll();
    }

    public WarehouseDto get(UUID id) {
        return warehouseRepository.findByUid(id);
    }

    public void delete(UUID id) {
        warehouseRepository.delete(id);
    }
}
