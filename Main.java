// Team F - Inventory and Billing System
// Main.java: console application with Scanner menu

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager mgr = new InventoryManager();

        // adding some starter products so user doesn't start with empty shop
        mgr.addItem(new GroceryItem(1, "Rice Packet 5kg", 350.0, 15, "12/2027"));
        mgr.addItem(new GroceryItem(2, "Milk 1L", 60.0, 4, "25/11/2026")); // low stock sample
        mgr.addItem(new ElectronicItem(3, "USB Mouse", 450.0, 8, 12));
        mgr.addItem(new ElectronicItem(4, "Keyboard RGB", 1200.0, 3, 24)); // low stock sample
        mgr.addItem(new GroceryItem(5, "Wheat Flour 10kg", 420.0, 20, "05/2027"));

        System.out.println("==================================================");
        System.out.println("   WELCOME TO TEAM F INVENTORY & BILLING SYSTEM   ");
        System.out.println("==================================================");

        int choise = 0;

        while (choise != 8) {
            System.out.println("\n----------------- MAIN MENU -----------------");
            System.out.println("1. View Current Stock");
            System.out.println("2. Add New Item (Grocery / Electronic)");
            System.out.println("3. Restock Existing Item");
            System.out.println("4. Check Low Stock Alerts");
            System.out.println("5. Create Invoice / Billing (Customer Checkout)");
            System.out.println("6. View All Past Invoices");
            System.out.println("7. View Sales Report (with Bubble Sort DSA)");
            System.out.println("8. Exit Application");
            System.out.print("Enter your choise (1-8): ");

            try {
                choise = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid number! Please enter between 1 to 8.");
                continue;
            }

            switch (choise) {
                case 1:
                    mgr.viewAllStock();
                    break;

                case 2:
                    System.out.println("\nSelect Category:");
                    System.out.println("1. Grocery Item");
                    System.out.println("2. Electronic Item");
                    System.out.print("Enter choise: ");
                    int ctype = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Item ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double prc = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter Initial Stock Quantity: ");
                    int qty = Integer.parseInt(sc.nextLine());

                    if (ctype == 1) {
                        System.out.print("Enter Expiry Date (MM/YYYY): ");
                        String exp = sc.nextLine();
                        mgr.addItem(new GroceryItem(id, name, prc, qty, exp));
                    } else if (ctype == 2) {
                        System.out.print("Enter Warranty in Months: ");
                        int war = Integer.parseInt(sc.nextLine());
                        mgr.addItem(new ElectronicItem(id, name, prc, qty, war));
                    } else {
                        System.out.println("Invalid category selected!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Item ID to restock: ");
                    int rId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter quantity to add: ");
                    int addQty = Integer.parseInt(sc.nextLine());

                    try {
                        mgr.updateItemStock(rId, addQty);
                    } catch (ItemNotFoundExcep e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter low-stock threshold limit (e.g. 5): ");
                    int lmt = Integer.parseInt(sc.nextLine());
                    mgr.checkLowStock(lmt);
                    break;

                case 5:
                    // Billing feature with custom exceptions
                    System.out.println("\n--- NEW INVOICE BILLING ---");
                    System.out.print("Enter Customer Name: ");
                    String custName = sc.nextLine();
                    System.out.print("Enter Date (DD/MM/YYYY): ");
                    String bDate = sc.nextLine();

                    ArrayList<BillItem> cart = new ArrayList<BillItem>();
                    String addMore = "y";

                    while (addMore.equalsIgnoreCase("y")) {
                        mgr.viewAllStock();
                        System.out.print("Enter Item ID to buy: ");
                        int buyId = Integer.parseInt(sc.nextLine());

                        try {
                            // custom exception check 1: finding item
                            Item itm = mgr.findItemById(buyId);

                            System.out.print("Enter Quantity to buy: ");
                            int buyQty = Integer.parseInt(sc.nextLine());

                            // custom exception check 2: stock availability
                            if (buyQty > itm.getQunatity()) {
                                throw new OutOfStokException("Not enough stock! Available stock is only: " + itm.getQunatity());
                            }
                            if (buyQty <= 0) {
                                System.out.println("Quantity must be greater than 0!");
                                continue;
                            }

                            // calculate polymorphic price
                            double itemTotall = itm.calclatePrice(buyQty);
                            itm.reduceStock(buyQty); // deduct stock

                            cart.add(new BillItem(itm, buyQty, itemTotall));
                            System.out.println("Added to cart! Subtotal for this item: Rs." + itemTotall);

                        } catch (ItemNotFoundExcep e) {
                            System.out.println("BILLING ERROR: " + e.getMessage());
                        } catch (OutOfStokException e) {
                            System.out.println("BILLING ERROR: " + e.getMessage());
                        }

                        System.out.print("Do you want to add more items? (y/n): ");
                        addMore = sc.nextLine();
                    }

                    if (!cart.isEmpty()) {
                        Invoice newInv = mgr.createInvoice(custName, cart, bDate);
                        System.out.println("Invoice successfully created!");
                        newInv.printInvoce();
                    } else {
                        System.out.println("Cart was empty, no invoice created.");
                    }
                    break;

                case 6:
                    mgr.viewAllInvoices();
                    break;

                case 7:
                    mgr.generateSalesReport();
                    break;

                case 8:
                    System.out.println("\nThank you for using Team F Inventory and Billing System. Goodbye!");
                    break;

                default:
                    System.out.println("Please enter a valid option from 1 to 8.");
            }
        }

        sc.close();
    }
}
