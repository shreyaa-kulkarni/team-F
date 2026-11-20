// Team F - ElectronicItem.java
// inheritance: child class for electronic gadgets

public class ElectronicItem extends Item {
    private int warantyMonth;

    // constructor
    public ElectronicItem(int itmId, String itmName, double priice, int qunatity, int warantyMonth) {
        super(itmId, itmName, priice, qunatity, "Electronics");
        this.warantyMonth = warantyMonth;
    }

    public int getWarantyMonth() {
        return warantyMonth;
    }

    // polymorphism: electronics have 8 percent tax included in price
    @Override
    public double calclatePrice(int buyQty) {
        double subTot = getPriice() * buyQty;
        double tax = subTot * 0.08; // 8% tax
        return subTot + tax;
    }

    @Override
    public void showDetail() {
        System.out.println("ID: " + getItmId() + " | " + getItmName() + " | Category: Electronics | Price: Rs." + getPriice() + " | Stock: " + getQunatity() + " | Warranty: " + warantyMonth + " months");
    }
}
