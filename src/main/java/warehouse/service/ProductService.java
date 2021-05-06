package warehouse.service;

import warehouse.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.model.Product;
import warehouse.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void save(ProductDto productDto) {

        productRepository.save(new Product(productDto.getName(), productDto.getPrice(), productDto.getShelfLife()));
    }

    public List<ProductDto> listAll() {
        List<ProductDto> result = new ArrayList<>();
        for (var p: productRepository.findAll()){
            result.add(new ProductDto(p.getName(), p.getPrice(), p.getShelfLife()));
        }
        return result;
    }

    public ProductDto get(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);

        return productOptional.map(ProductDto::new).orElse(null);
    }

    public List<ProductDto> get(String name) {
        List<ProductDto> result = new ArrayList<>();
        for (var p: productRepository.findByName(name)){
            result.add(new ProductDto(p.getName(), p.getPrice(), p.getShelfLife()));
        }
        return result;
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

}
