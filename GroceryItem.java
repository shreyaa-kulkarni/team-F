// Team F - GroceryItem.java
// inheritance: child class for grocery items

public class GroceryItem extends Item {
    private String expryDate;

    // constructor calling super
    public GroceryItem(int itmId, String itmName, double priice, int qunatity, String expryDate) {
        super(itmId, itmName, priice, qunatity, "Grocery");
        this.expryDate = expryDate;
    }

    public String getExpryDate() {
        return expryDate;
    }

    // polymorphism: calculate price with small bulk discount if buy 5 or more
    @Override
    public double calclatePrice(int buyQty) {
        double tot = getPriice() * buyQty;
        if (buyQty >= 5) {
            tot = tot * 0.95; // 5% discount for bulk grocery
        }
        return tot;
    }

    @Override
    public void showDetail() {
        System.out.println("ID: " + getItmId() + " | " + getItmName() + " | Category: Grocery | Price: Rs." + getPriice() + " | Stock: " + getQunatity() + " | Exp: " + expryDate);
    }
}
