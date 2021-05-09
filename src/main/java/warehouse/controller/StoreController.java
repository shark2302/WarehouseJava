package warehouse.controller;

import warehouse.dto.DeliveryOrderDto;
import warehouse.dto.SalePackageDto;
import warehouse.dto.StoreDto;
import warehouse.service.DeliveryOrderService;
import warehouse.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class StoreController {
/*
    @Autowired
    private StoreService storeService;

    @Autowired
    private DeliveryOrderService deliveryOrderService;

    public void runController() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chose action:\n" +
                "1. Show all\n" +
                "2. Add new\n" +
                "3. Get\n" +
                "4. Delete");
        int select = sc.nextInt();
        if (select == 1) {
            for (var store : storeService.listAll()) {
                System.out.println(store);
            }
        }
        else if (select == 2) {
            System.out.println("Enter name of store :");
            String name = sc.next();
            storeService.save(new StoreDto(name));
        }
        else if (select == 3) {
            System.out.println("Choose store to get : ");
            var stores = storeService.listAll();
            for (int i = 0; i < stores.size(); i++) {
                System.out.println(i + ". " + stores.get(i));
            }
            var choice = sc.nextInt();
            var currentStore = stores.get(choice);
            System.out.println("Choice action for " + currentStore.getName() + " store\n" +
                    "1. Show delivered orders\n" +
                    "2. Show orders in progress\n" +
                    "3. Create new order");
            var num = sc.nextInt();
            if (num == 1) {
                for (var order:deliveryOrderService.getDeliveredForStore(currentStore)) {
                    System.out.println(order);
                }
            }
            else if (num == 2) {
                for (var order:deliveryOrderService.getNotDeliveredForStore(currentStore)) {
                    System.out.println(order);
                }
            }
            else if (num == 3) {
                if(currentStore.getWarehouse() == null) {
                    System.out.println("No warehouse for this store");
                }
                else {
                    System.out.println("Select package to make order: ");
                    var packs = currentStore.getWarehouse().getPackages();
                    for (int i = 0; i < packs.size(); i++) {
                        System.out.println(i + ". " + packs.get(i));
                    }
                    var packChoice = sc.nextInt();
                    List<SalePackageDto> packsToDeliver = new ArrayList<>();
                    packsToDeliver.add(packs.get(packChoice));
                    deliveryOrderService.save(new DeliveryOrderDto(currentStore, currentStore.getWarehouse(), packsToDeliver));
                }
            }
        }
    }*/
}
