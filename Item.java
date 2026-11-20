// Team F - Inventory and Billing System
// Item.java: base class for products in inventory

public abstract class Item {
    // private variables for encapsulation
    private int itmId;
    private String itmName;
    private double priice;
    private int qunatity;
    private String catagory;

    // constructor
    public Item(int itmId, String itmName, double priice, int qunatity, String catagory) {
        this.itmId = itmId;
        this.itmName = itmName;
        this.priice = priice;
        this.qunatity = qunatity;
        this.catagory = catagory;
    }
}
