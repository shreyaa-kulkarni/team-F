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

    // getters and setters for encapsulation
    public int getItmId() {
        return itmId;
    }

    public String getItmName() {
        return itmName;
    }

    public double getPriice() {
        return priice;
    }

    public void setPriice(double priice) {
        this.priice = priice;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    public String getCatagory() {
        return catagory;
    }

    // method to reduce stock after billing
    public void reduceStock(int amt) {
        this.qunatity = this.qunatity - amt;
    }

    // method to add stock
    public void addStock(int amt) {
        this.qunatity = this.qunatity + amt;
    }

    // abstract methods for abstraction and polymorphism
    public abstract double calclatePrice(int buyQty);
    public abstract void showDetail();
}
