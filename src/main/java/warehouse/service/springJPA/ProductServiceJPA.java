package warehouse.service.springJPA;

import org.springframework.stereotype.Service;
import warehouse.dto.ProductDto;
import warehouse.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceJPA{

    @PersistenceContext
    private EntityManager em;

    public void save(ProductDto productDto) {
        em.persist(new Product(productDto.getName(), productDto.getPrice(), productDto.getShelfLife()));
    }

    public List<ProductDto> listAll() {
        List<ProductDto> result = new ArrayList<>();
        TypedQuery<Product> products = em.createQuery("select product from Product product", Product.class);
        for (var p: products.getResultList()){
            result.add(new ProductDto(p.getName(), p.getPrice(), p.getShelfLife()));
        }
        return result;

    }


    public ProductDto get(Integer id) {
        Product product = em.find(Product.class, id);
        return product != null ? new ProductDto(product.getName(), product.getPrice(), product.getShelfLife()) : null;
    }

    public List<ProductDto> get(String name) {
        List<ProductDto> result = new ArrayList<>();
        TypedQuery<Product> products = em.createQuery("select product from Product product where product.name = :name", Product.class).setParameter("name", name);
        for (var p: products.getResultList()){
            result.add(new ProductDto(p.getName(), p.getPrice(), p.getShelfLife()));
        }
        return result;

    }


    public ProductDto get(String name, Double price) {
        TypedQuery<Product> products = em.createQuery(
                "select product from Product product where product.name = :name and product.price = :price", Product.class).
                setParameter("name", name).setParameter("price", price);
        Product p = products.getSingleResult();
        return p != null ? new ProductDto(p.getName(), p.getPrice(), p.getShelfLife()) : null;
    }


    public void delete(Integer id) {
        Product product = em.find(Product.class, id);
        if(product != null)
            em.remove(product);
    }
}
