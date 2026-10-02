package W2.B2_3_Theswaptrick;

public class NumberWrapper {
    private int value;

    public NumberWrapper(int value) {
        this.value = value;
    }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    // Theo đúng đề: hoán đổi 2 tham số (KHÔNG có tác dụng)
    public static void swap(NumberWrapper a, NumberWrapper b) {
        NumberWrapper temp = a;
        a = b;
        b = temp;
        System.out.println("  Trong swap: a = " + a.getValue() + ", b = " + b.getValue());
    }

    // Phiên bản hoạt động: hoán đổi giá trị bên trong đối tượng
    public static void swapValues(NumberWrapper a, NumberWrapper b) {
        int temp = a.getValue();
        a.setValue(b.getValue());
        b.setValue(temp);
    }

    // ===== HÀM MAIN =====
    public static void main(String[] args) {
        NumberWrapper n1 = new NumberWrapper(5);
        NumberWrapper n2 = new NumberWrapper(10);

        System.out.println("Truoc swap: n1 = " + n1.getValue() + ", n2 = " + n2.getValue());
        swap(n1, n2);
        System.out.println("Sau swap:   n1 = " + n1.getValue() + ", n2 = " + n2.getValue());

        System.out.println("\n--- Thu voi swapValues ---");
        swapValues(n1, n2);
        System.out.println("Sau swapValues: n1 = " + n1.getValue() + ", n2 = " + n2.getValue());
    }
}
