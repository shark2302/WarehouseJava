package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import warehouse.config.AppConfig;
import warehouse.dto.ProductDto;
import warehouse.dto.StoreDto;
import warehouse.service.DumbService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import warehouse.service.springData.ProductService;
import warehouse.service.springData.StoreService;
import warehouse.service.springData.WarehouseService;
import warehouse.service.springJPA.ProductServiceJPA;
import warehouse.service.springJPA.StoreServiceJPA;

@Configuration
@ComponentScan(/*basePackages = "di2"*/ basePackageClasses = {DumbService.class, AppConfig.class, ProductServiceJPA.class})
public class Application {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        ProductService ps1 = context.getBean(ProductService.class);
        //sp.save(new SalePackageDto(10, new ProductDto("Apple", 2d, 30), 30));
        ProductServiceJPA ps = context.getBean(ProductServiceJPA.class);
        StoreServiceJPA s = context.getBean(StoreServiceJPA.class);
        WarehouseService ws = context.getBean(WarehouseService.class);
        StoreService ss = context.getBean(StoreService.class);
    }

}
