package di2.controller;

import di2.model.Product;
import di2.model.SalePackage;
import di2.service.ProductService;
import di2.service.SalePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
            Product[] productArr = new Product[count];
            Arrays.fill(productArr, product);
            salePackageService.save(new SalePackage((new Date()).getDay(), Arrays.asList(productArr)));
        }
        if (select == 3) {
            var salePackages = salePackageService.listAll();
            System.out.println("Enter number of sale package to delete : ");
            for (int i = 0; i < salePackages.size(); i++) {
                System.out.println(i + ". " + salePackages.get(i));
            }
            int choice = sc.nextInt();
            salePackageService.delete(salePackages.get(choice).getUid());
        }
    }
}
