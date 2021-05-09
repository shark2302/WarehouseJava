package warehouse.controller;

import warehouse.dto.WarehouseDto;
import warehouse.service.DeliveryOrderService;
import warehouse.service.SalePackageService;
import warehouse.service.StoreService;
import warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class WarehouseController {
/*
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private DeliveryOrderService deliveryOrderService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private SalePackageService salePackageService;
    
    public void runController() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chose action for warehouse:\n" +
                "1. Show all\n" +
                "2. Add new\n" +
                "3. Get\n" +
                "4. Delete");
        int select = sc.nextInt();
        if (select == 1) {
            for (var warehouse : warehouseService.listAll()) {
                System.out.println(warehouse);
            }
        }
        else if (select == 2) {
            System.out.println("Enter capacity of warehouse :");
            int capacity = sc.nextInt();
            warehouseService.save(new WarehouseDto("", salePackageService.listAll(), storeService.listAll(), capacity));
        }
        else if (select == 3) {
            System.out.println("Choose warehouse to get : ");
            var warehouses = warehouseService.listAll();
            for (int i = 0; i < warehouses.size(); i++) {
                System.out.println(i + ". " + warehouses.get(i));
            }
            var choice = sc.nextInt();
            var currentWarehouse = warehouses.get(choice);
            System.out.println("Choice action for warehouse\n" +
                    "1. Show delivered orders\n" +
                    "2. Show orders in progress\n" +
                    "3. Complete order\n" +
                    "4. Add served store\n" +
                    "5. Add package");
            var num = sc.nextInt();
            if (num == 1) {
                for (var order:deliveryOrderService.getDeliveredForWarehouse(currentWarehouse)) {
                    System.out.println(order);
                }
            }
            else if (num == 2) {
                for (var order:deliveryOrderService.getNotDeliveredForWarehouse(currentWarehouse)) {
                    System.out.println(order);
                }
            }
            else if (num == 3) {
                System.out.println("Select order to complete: ");
                var orders = deliveryOrderService.getNotDeliveredForWarehouse(currentWarehouse);
                for (int i = 0; i < orders.size(); i++) {
                    System.out.println(i + ". " + orders.get(i));
                }
                var orderChoice = sc.nextInt();
                currentWarehouse.completeOrder(orders.get(orderChoice));
            }
            else if (num == 4) {
                System.out.println("Select store to serve: ");
                var availibleStore = storeService.getStoresWithoutWarehouse();
                for (int i = 0; i < availibleStore.size(); i++) {
                    System.out.println(i + ". " + availibleStore.get(i));
                }
                var storeSelect = sc.nextInt();
                currentWarehouse.addServedStore(availibleStore.get(storeSelect));
            }
            else if (num == 5) {
                System.out.println("Select package to add: ");
                var packages = salePackageService.listAll();
                for (int i = 0; i < packages.size(); i++) {
                    System.out.println(i + ". " + packages.get(i));
                }
                var packSelect = sc.nextInt();
                currentWarehouse.getPackages().add(packages.get(packSelect));
            }
        }
    }*/
}
