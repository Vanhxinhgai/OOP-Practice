package W2.B2_5_EqualsMethod;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Dế Mèn phiêu lưu ký", "Tô Hoài", 50000);
        Book b2 = new Book("Dế Mèn phiêu lưu ký", "Tô Hoài", 50000); // cùng dữ liệu, đối tượng khác
        Book b3 = b1;                                                 // cùng một đối tượng
        Book b4 = new Book("Dế Mèn phiêu lưu ký", "Tô Hoài", 60000); // khác giá

        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);

        System.out.println("\n=== b1 và b2 (cùng dữ liệu, 2 đối tượng) ===");
        System.out.println("b1 == b2      : " + (b1 == b2));
        System.out.println("b1.equals(b2) : " + b1.equals(b2));

        System.out.println("\n=== b1 và b3 (cùng 1 đối tượng) ===");
        System.out.println("b1 == b3      : " + (b1 == b3));
        System.out.println("b1.equals(b3) : " + b1.equals(b3));

        System.out.println("\n=== Các trường hợp khác ===");
        System.out.println("b1.equals(b4)   : " + b1.equals(b4));     // khác giá
        System.out.println("b1.equals(null) : " + b1.equals(null));
        System.out.println("b1.equals(\"abc\"): " + b1.equals("abc")); // khác lớp
    }
}
