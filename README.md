# Team F - Inventory and Billing System

Console based Java project for store stock management, low-stock alerts, invoice generation and sales reports.

---

## What the Project Does
1. **Stock Management**: Add new items (Groceries or Electronics), view all products in inventory, and update stock numbers.
2. **Low-Stock Alerts**: Alerts when any item quantity falls below user defined threshold limit.
3. **Invoice Generation**: Generates formatted bill for customer purchases, checks stock before deducting, and applies discounts/tax.
4. **Sales Report**: Shows total invoices made, total earnings/revenue, and sorts stock levels using our own Bubble Sort DSA algorithm.

---

## Requirements Checklist from Project Guidelines

### 1. OOPs Pillars
- **Abstraction**: `Item` is an abstract base class containing abstract methods `calclatePrice(int buyQty)` and `showDetail()`.
- **Encapsulation**: All data fields (like `itmId`, `itmName`, `priice`, `qunatity`) are made `private` and accessed using public getters and setters.
- **Inheritance**: `GroceryItem` and `ElectronicItem` child classes extend the parent `Item` class.
- **Polymorphism**: `GroceryItem` and `ElectronicItem` override `calclatePrice()` and `showDetail()`. Grocery items give a 5% discount for bulk buying (5 or more items), while Electronics add 8% tax.

### 2. Custom Exceptions (2 used)
- `OutOfStokException`: Thrown when a customer tries to buy more quantity than available in stock.
- `ItemNotFoundExcep`: Thrown when a user enters an Item ID that does not exist in inventory.
- Both exceptions are handled using `try` and `catch` blocks in billing and stock update.

### 3. One DSA Implementation
- **Custom Bubble Sort Algorithm**: Written manually in `InventoryManager.java` inside `customSortByStock()` using nested loops and swap logic. It sorts all inventory items by their stock quantity in ascending order for the sales report.

### 4. Collections Framework
- `ArrayList<Item>`: Used to store and manage inventory items dynamically.
- `ArrayList<BillItem>`: Used to hold items added to the customer shopping cart.
- `ArrayList<Invoice>`: Used to store invoice history for sales reports.

---

## How to Run the Project

1. Open terminal or command prompt in this folder.
2. Compile all java files (works on all Java versions):
   ```bash
   javac --release 8 *.java
   ```
3. Run the program:
   ```bash
   java Main
   ```

---

## Team Explanation Quick Notes (For Viva)
- **Where is Encapsulation?** In `Item.java`, variables are `private` and accessed with `getItmName()`, `getPriice()`, etc.
- **Where is Inheritance?** In `GroceryItem.java` and `ElectronicItem.java` using `extends Item`.
- **Where is Polymorphism?** Method `calclatePrice()` behaves differently for grocery (discount) and electronic (tax).
- **Where is Abstraction?** `abstract class Item` with abstract method `calclatePrice()`.
- **Where is Custom Exception?** `OutOfStokException.java` and `ItemNotFoundExcep.java` used in `Main.java` line 125-145.
- **Where is DSA?** In `InventoryManager.java` under method `customSortByStock()` (Bubble Sort).
- **Where is Collection?** `ArrayList` used in `InventoryManager.java` and `Invoice.java`.
