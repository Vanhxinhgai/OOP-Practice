package W3.B3_6;

import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        LocalDate today = LocalDate.of(2025, 3, 1);
        int n = Integer.parseInt(sc.nextLine().trim());
        Order order = new Order();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            char type = line.charAt(0);
            int first = line.indexOf('"');
            int last = line.lastIndexOf('"');
            String name = line.substring(first + 1, last);
            String[] parts = line.substring(last + 1).trim().split("\\s+");
            String id = "SP" + (i + 1);
            double price = Double.parseDouble(parts[0]);
            if (type == 'E') {
                double warranty = parts.length > 1 ? Double.parseDouble(parts[1]) : 0;
                order.addProduct(new Electronics(id, name, price, warranty));
            } else {
                LocalDate expiry = LocalDate.parse(parts[1]);   // định dạng yyyy-MM-dd
                order.addProduct(new Food(id, name, price, expiry, today));
            }
        }
        order.printInvoice();
    }
}
