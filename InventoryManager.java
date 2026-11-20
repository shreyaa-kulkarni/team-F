// Team F - InventoryManager.java
// manages store stock and all customer bills

import java.util.ArrayList;

public class InventoryManager {
    // using Collections ArrayList to store items and invoices
    private ArrayList<Item> itmList;
    private ArrayList<Invoice> allInvoces;
    private int invCounter = 101;

    // constructor
    public InventoryManager() {
        itmList = new ArrayList<Item>();
        allInvoces = new ArrayList<Invoice>();
    }

    public ArrayList<Item> getItmList() {
        return itmList;
    }

    public ArrayList<Invoice> getAllInvoces() {
        return allInvoces;
    }
}
