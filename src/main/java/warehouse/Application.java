package warehouse;

import warehouse.config.AppConfig;
import warehouse.dto.StoreDto;
import warehouse.service.DumbService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import warehouse.service.ProductService;
import warehouse.service.StoreService;
import warehouse.service.WarehouseService;

@Configuration
@ComponentScan(/*basePackages = "di2"*/ basePackageClasses = {DumbService.class, AppConfig.class})
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        //sp.save(new SalePackageDto(10, new ProductDto("Apple", 2d, 30), 30));
        WarehouseService ws = context.getBean(WarehouseService.class);
        StoreService ss = context.getBean(StoreService.class);
    }

}
