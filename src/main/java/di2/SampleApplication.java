package di2;

import di2.component.DumbComponent;
import di2.config.ApplicationConfig;
import di2.controller.DumbController;
import di2.controller.ProductController;
import di2.controller.SalePackageController;
import di2.controller.StoreController;
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

@Configuration
@ComponentScan(/*basePackages = "di2"*/ basePackageClasses = {DumbService.class, ApplicationConfig.class,
        DumbComponent.class, ProductRepository.class, DumbController.class})
public class SampleApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SampleApplication.class);
        /*SampleService sampleService = context.getBean(SampleService.class);
        sampleService.printHello("John");
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        for (Product p: productRepository.findAll()) {
            System.out.println(p.toString());
        }
        SalePackageRepository salePackageRepository = context.getBean(SalePackageRepository.class);
        for (SalePackage sp: salePackageRepository.findAll()) {
            System.out.println(sp.toString());
        }

        StoreRepository storeRepository = context.getBean(StoreRepository.class);
        for (Store p: storeRepository.findAll()) {
            System.out.println(p.toString());
        }

        WarehouseRepository warehouseRepository = context.getBean(WarehouseRepository.class);
        for (Warehouse p: warehouseRepository.findAll()) {
            System.out.println(p.toString());
        }*/
        ProductController pc = context.getBean(ProductController.class);
        SalePackageController spc = context.getBean(SalePackageController.class);
        WarehouseRepository warehouseRepository = context.getBean(WarehouseRepository.class);
        StoreController sc = context.getBean(StoreController.class);
        while(true)
            sc.runController();

    }
}
