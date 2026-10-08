package W2.B2_9_StaticMethods_StandardIO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product p1 = inputProduct(sc, 1);
        Product p2 = inputProduct(sc, 2);
        System.out.println("\n=== GIAO DỊCH ===");
        p1.sell(readInt(sc, "Số lượng muốn mua " + p1.getName() + ": "));
        p2.sell(readInt(sc, "Số lượng muốn mua " + p2.getName() + ": "));
        printPrices("Giá cuối ban đầu", p1, p2);

        Product.updateTaxRate(0.08);
        printPrices("Sau khi giảm thuế", p1, p2);
        p1.updateDiscount(10.0);
        printPrices("Sau khi đổi giảm giá của p1", p1, p2);

        System.out.printf("%nTổng doanh thu toàn hệ thống: %.2f%n", Product.getTotalRevenue());
        sc.close();
    }

    static Product inputProduct(Scanner sc, int index) {
        System.out.println("Nhập thông tin sản phẩm " + index);
        System.out.print("  Tên: ");
        String name = sc.nextLine().trim();
        double price = readDouble(sc, "  Giá: ");
        int quantity = readInt(sc, "  Số lượng tồn kho: ");
        double discount = readDouble(sc, "  Giảm giá: ");
        return new Product(name, price, quantity, discount);
    }

    static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập một số (dùng dấu chấm cho phần thập phân).");
            }
        }
    }

    static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập một số nguyên.");
            }
        }
    }

    static void printPrices(String title, Product a, Product b) {
        System.out.printf("%n=== %s (VAT %.0f%%) ===%n", title, Product.getTaxRate() * 100);
        System.out.printf("  %s: %.2f%n", a.getName(), a.calculateFinalPrice());
        System.out.printf("  %s: %.2f%n", b.getName(), b.calculateFinalPrice());
    }
}
