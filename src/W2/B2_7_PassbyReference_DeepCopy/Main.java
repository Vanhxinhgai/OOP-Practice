package W2.B2_7_PassbyReference_DeepCopy;

public class Main {
    public static void main(String[] args) {
        Product[] arr = {
                new Product("P01", "Laptop", 1000),
                new Product("P02", "Chuột", 20)
        };

        Inventory kho = new Inventory(arr);
        System.out.println("=== Kho ban đầu ===");
        kho.printItems();
        arr[0].setPrice(5000);
        arr[1] = new Product("P99", "Hàng giả", 1);

        System.out.println("\n=== Mảng arr sau khi sửa ===");
        for (Product p : arr) {
            System.out.println("  " + p);
        }

        System.out.println("\n=== Kho sau khi arr bị sửa ===");
        kho.printItems();

        Product[] got = kho.getItems();
        got[0].setPrice(1);
        got[1] = null;

        System.out.println("\n=== Kho sau khi sửa mảng lấy từ getItems() ===");
        kho.printItems();
    }
}
