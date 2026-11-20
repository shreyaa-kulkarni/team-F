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

    // add product to inventory
    public void addItem(Item itm) {
        itmList.add(itm);
        System.out.println("Success: Item added to inventory!");
    }

    // view all products in stock
    public void viewAllStock() {
        if (itmList.isEmpty()) {
            System.out.println("Inventory is empty right now.");
            return;
        }
        System.out.println("\n----------------- CURRENT INVENTORY STOCK -----------------");
        for (int i = 0; i < itmList.size(); i++) {
            itmList.get(i).showDetail();
        }
        System.out.println("-----------------------------------------------------------");
    }

    // find item by id, throws custom exception if not found
    public Item findItemById(int id) throws ItemNotFoundExcep {
        for (int i = 0; i < itmList.size(); i++) {
            if (itmList.get(i).getItmId() == id) {
                return itmList.get(i);
            }
        }
        // if loop ends without finding
        throw new ItemNotFoundExcep("Item with ID " + id + " was not found in stock!");
    }

    // add more stock quantity to existing item
    public void updateItemStock(int id, int addedQty) throws ItemNotFoundExcep {
        Item itm = findItemById(id);
        itm.addStock(addedQty);
        System.out.println("Updated stock for " + itm.getItmName() + ". New quantity: " + itm.getQunatity());
    }

    // DSA IMPLEMENTATION: custom bubble sort algorithm written manually
    // sorts items based on quantity in ascending order (lowest stock first)
    public void customSortByStock() {
        // copy list to not disturb original order
        ArrayList<Item> sortedList = new ArrayList<Item>(itmList);
        int n = sortedList.size();

        // standard bubble sort nested loop
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedList.get(j).getQunatity() > sortedList.get(j + 1).getQunatity()) {
                    // swap items
                    Item temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }

        System.out.println("\n--- INVENTORY SORTED BY STOCK LEVEL (BUBBLE SORT DSA) ---");
        for (int k = 0; k < sortedList.size(); k++) {
            Item itm = sortedList.get(k);
            System.out.println("Stock: " + itm.getQunatity() + " | " + itm.getItmName() + " (ID: " + itm.getItmId() + ")");
        }
        System.out.println("---------------------------------------------------------");
    }
}
