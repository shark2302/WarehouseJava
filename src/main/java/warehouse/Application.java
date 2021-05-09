package warehouse;

import warehouse.component.DumbComponent;
import warehouse.config.AppConfig;
import warehouse.controller.*;
import warehouse.repository.ProductRepository;
import warehouse.service.DumbService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import warehouse.service.ProductService;
import warehouse.service.SalePackageService;

@Configuration
@ComponentScan(/*basePackages = "di2"*/ basePackageClasses = {DumbService.class, AppConfig.class,
        DumbComponent.class, ProductRepository.class, DumbController.class})
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
       /* ProductController productController = context.getBean(ProductController.class);
        SalePackageController salePackageController = context.getBean(SalePackageController.class);
        StoreController storeController = context.getBean(StoreController.class);
        WarehouseController warehouseController = context.getBean(WarehouseController.class);
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Select controller to run :\n" +
                    "1. Products\n" +
                    "2. Packages\n" +
                    "3. Stores\n" +
                    "4. Warehouses\n" +
                    "5. Stop app");
            int select = scan.nextInt();
            if(select == 1) {
                 productController.runController();
            } else if(select == 2) {
                salePackageController.runController();
            }else if (select == 3) {
                storeController.runController();
            }else if (select ==4) {
                warehouseController.runController();
            }else break;
        }*/
        ProductService s = context.getBean(ProductService.class);
        SalePackageService sp = context.getBean(SalePackageService.class);
        //sp.save(new SalePackageDto(10, new ProductDto("Apple", 2d, 30), 30));
        var pack = sp.get(1);
        System.out.println(pack.getProductDto());
    }

}
