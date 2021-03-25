package di2.controller;

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

        }
    }
}
