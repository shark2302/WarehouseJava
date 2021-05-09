package warehouse.controller;

import warehouse.dto.ProductDto;
import warehouse.dto.SalePackageDto;
import warehouse.service.ProductService;
import warehouse.service.SalePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

@Controller
public class SalePackageController {

    @Autowired
    private SalePackageService salePackageService;

    @Autowired
    private ProductService productService;

    public void runController() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chose action:\n" +
                "1. Show all\n" +
                "2. Add new\n" +
                "3. Delete");
        int select = sc.nextInt();
        if (select == 1) {
            for (var salePackage : salePackageService.listAll()) {
                System.out.println(salePackage);
            }
        }
        if (select == 2) {
            System.out.println("Enter product name: ");
            var name = sc.next();
            var product = productService.get(name).get(0);
            System.out.println("Enter count: ");
            int count = sc.nextInt();
            ProductDto[] productDtoArr = new ProductDto[count];
            Arrays.fill(productDtoArr, product);
            //salePackageService.save(new SalePackageDto((new Date()).getDay(), Arrays.asList(productDtoArr)));
        }
        if (select == 3) {
            var salePackages = salePackageService.listAll();
            System.out.println("Enter number of sale package to delete : ");
            for (int i = 0; i < salePackages.size(); i++) {
                System.out.println(i + ". " + salePackages.get(i));
            }
            int choice = sc.nextInt();
            //salePackageService.delete(salePackages.get(choice).getUid());
        }
    }
}
