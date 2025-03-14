package src.genericscollectionlab;

import java.util.HashMap;
import java.util.Map;

public class Client {

    public static void main(String[] args) {
        Electronics electronics1 = new Electronics("e1", "radio", 100, 10, 2);
        Electronics electronics2 = new Electronics("e2", "tv", 100000, 5, 1);
        Clothing clothing1 = new Clothing("c1", "shirt", 999, 50, 1);

        InventoryManagement<Item> mgmt = new InventoryManagement<>();
        try {
            mgmt.add(electronics2);
            mgmt.add(electronics1);
            mgmt.add(clothing1);
        } catch(InvalidQuantityException iqe) {
            System.out.println(iqe.getErrorCode() + iqe.getMessage());
        }

        System.out.println(mgmt.list());

        mgmt.remove(electronics2);
        System.out.println("after removing e2: " + mgmt.list());

        System.out.println("Retrieving e1: " + mgmt.retrieve("e1"));
        System.out.println(mgmt.list());
    }
}
