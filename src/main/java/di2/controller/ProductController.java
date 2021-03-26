package di2.controller;

import di2.model.Product;
import di2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    public void runController() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chose action:\n" +
                "1. Show all\n" +
                "2. Add new\n" +
                "3. Delete");
        int select = sc.nextInt();
        if(select == 1) {
            for (var product:productService.listAll()) {
                System.out.println(product);
            }
        }
        if (select == 2) {
            System.out.println("Enter name of product: ");
            String name = sc.next();
            System.out.println("Enter price: ");
            double price = sc.nextDouble();
            System.out.println("Enter shelfLife: ");
            int shelfLife = sc.nextInt();
            productService.save(new Product(name, price, shelfLife));
        }
        if (select == 3) {
            var products = productService.listAll();
            System.out.println("Enter number of product to delete : ");
            for (int i = 0; i < products.size(); i++) {
                System.out.println(i + ". " + products.get(i));
            }
            int choice = sc.nextInt();
            productService.delete(products.get(choice).getUid());
        }
    }
}
