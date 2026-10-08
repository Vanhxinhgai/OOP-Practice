package W3.B3_6;

import java.util.ArrayList;
import java.util.List;
public class Order {
    private List<Product> products = new ArrayList<>();
    public void addProduct(Product p) {
        products.add(p);
    }
    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getFinalPrice();
        }
        return total;
    }
    public void printInvoice() {
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("Total = " + getTotal());
    }
}
