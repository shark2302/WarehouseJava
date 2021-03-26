package di2;

import di2.component.DumbComponent;
import di2.config.ApplicationConfig;
import di2.controller.*;
import di2.model.Product;
import di2.model.SalePackage;
import di2.model.Store;
import di2.model.Warehouse;
import di2.repository.ProductRepository;
import di2.repository.SalePackageRepository;
import di2.repository.StoreRepository;
import di2.repository.WarehouseRepository;
import di2.service.DumbService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import di2.service.SampleService;

import java.util.Scanner;

@Configuration
@ComponentScan(/*basePackages = "di2"*/ basePackageClasses = {DumbService.class, ApplicationConfig.class,
        DumbComponent.class, ProductRepository.class, DumbController.class})
public class SampleApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SampleApplication.class);
        ProductController productController = context.getBean(ProductController.class);
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
        }
    }

}
