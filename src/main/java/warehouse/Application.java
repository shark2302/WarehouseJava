package warehouse;

import warehouse.component.DumbComponent;
import warehouse.config.ApplicationConfig;
import warehouse.controller.*;
import warehouse.repository.ProductRepository;
import warehouse.service.DumbService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import warehouse.service.ProductService;

import java.util.Scanner;

@Configuration
@ComponentScan(/*basePackages = "di2"*/ basePackageClasses = {DumbService.class, ApplicationConfig.class,
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
        var i = s.get("Milk");
        s.delete(1);
        for (var p: s.listAll()) {
            System.out.println(p);
        }
    }

}
