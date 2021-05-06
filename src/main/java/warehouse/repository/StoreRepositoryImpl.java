package warehouse.repository;

import warehouse.dto.StoreDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StoreRepositoryImpl implements StoreRepository{

    private List<StoreDto> data = new ArrayList<>();

    @PostConstruct
    private void init() {
        data.add(new StoreDto("Magnit"));
        data.add(new StoreDto("Pyaterochka"));
    }

    @Override
    public List<StoreDto> findAll() {
        return data;
    }

    @Override
    public List<StoreDto> findByName(String name) {
        return data.stream().filter( p -> Objects.equals(p.getName(), name)).collect(Collectors.toList());
    }

    @Override
    public StoreDto findByUid(UUID uid) {
        return data.stream().filter( p -> Objects.equals(p.getUid(), uid)).findFirst().orElse(null);
    }

    @Override
    public void save(StoreDto storeDto) {
        data.add(storeDto);
    }

    @Override
    public void delete(UUID uid) {
        data.remove(findByUid(uid));
    }
}
