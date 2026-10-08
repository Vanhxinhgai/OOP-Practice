package W2.B2_9_StaticMethods_StandardIO;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount;
    private static double taxRate = 0.1;
    private static double totalRevenue = 0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = Math.max(0, price);
        this.quantity = Math.max(0, quantity);
        if (discount < 0 || discount > this.price) {
            System.err.println("[LỖI] Giảm giá của " + name + " không hợp lệ. Đặt về 0.");
            this.discount = 0;
        } else {
            this.discount = discount;
        }
    }

    public static void updateTaxRate(double newRate) {
        if (newRate < 0 || newRate > 1) {
            System.err.println("[LỖI] Thuế phải nằm trong khoảng 0 đến 1.");
            return;
        }
        System.out.printf("Đã cập nhật thuế VAT: %.0f%% -> %.0f%%%n", taxRate * 100, newRate * 100);
        taxRate = newRate;
    }

    public static double getTaxRate()      { return taxRate; }
    public static double getTotalRevenue() { return totalRevenue; }
    public double calculateFinalPrice() {
        return (price - discount) * (1 + taxRate);
    }

    public void updateDiscount(double newDiscount) {
        if (newDiscount < 0 || newDiscount > price) {
            System.err.println("[LỖI] Giảm giá phải từ 0 đến " + price + ".");
            return;
        }
        this.discount = newDiscount;
    }
    public void sell(int amount) {
        if (amount <= 0) {
            System.err.println("[LỖI] Số lượng mua phải lớn hơn 0.");
            return;
        }
        if (amount > quantity) {
            System.err.println("Không đủ hàng trong kho: " + name + " chỉ còn "
                    + quantity + ", yêu cầu " + amount + ".");
            return;
        }
        quantity -= amount;
        double money = amount * calculateFinalPrice();
        totalRevenue += money;
        System.out.printf("[OK] Bán %d %s, thu %.2f. Tồn kho còn %d.%n",
                amount, name, money, quantity);
    }

    public String getName()   { return name; }
    public int getQuantity()  { return quantity; }
}
