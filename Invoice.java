// Team F - Invoice.java
// Invoice class to store billing records and print receipt

import java.util.ArrayList;

public class Invoice {
    private int invoceNo;
    private String custmerName;
    private ArrayList<BillItem> billItems; // using collection ArrayList
    private double granTotal;
    private String bllDate;

    public Invoice(int invoceNo, String custmerName, ArrayList<BillItem> billItems, double granTotal, String bllDate) {
        this.invoceNo = invoceNo;
        this.custmerName = custmerName;
        this.billItems = billItems;
        this.granTotal = granTotal;
        this.bllDate = bllDate;
    }

    public int getInvoceNo() {
        return invoceNo;
    }

    public String getCustmerName() {
        return custmerName;
    }

    public double getGranTotal() {
        return granTotal;
    }

    public String getBllDate() {
        return bllDate;
    }

    // method to print invoice receipt
    public void printInvoce() {
        System.out.println("\n========================================================");
        System.out.println("                   INVOICE / CASH BILL                  ");
        System.out.println("========================================================");
        System.out.println("Invoice No : " + invoceNo);
        System.out.println("Customer   : " + custmerName);
        System.out.println("Date       : " + bllDate);
        System.out.println("--------------------------------------------------------");
        System.out.println("Item Name          Qty     Price(each)     Total Amount");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < billItems.size(); i++) {
            BillItem bi = billItems.get(i);
            System.out.printf("%-18s %-7d Rs.%-11.2f Rs.%.2f\n", 
                bi.getItm().getItmName(), bi.getBuyQunatity(), bi.getItm().getPriice(), bi.getItmTotal());
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("Grand Total : Rs.%.2f\n", granTotal);
        System.out.println("========================================================\n");
    }
}
