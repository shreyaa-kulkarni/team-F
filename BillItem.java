// Team F - BillItem.java
// helper class for single product in invoice bill

public class BillItem {
    private Item itm;
    private int buyQunatity;
    private double itmTotal;

    // constructor
    public BillItem(Item itm, int buyQunatity, double itmTotal) {
        this.itm = itm;
        this.buyQunatity = buyQunatity;
        this.itmTotal = itmTotal;
    }

    public Item getItm() {
        return itm;
    }

    public int getBuyQunatity() {
        return buyQunatity;
    }

    public double getItmTotal() {
        return itmTotal;
    }
}
