package W2.B2_10_Overloading_this;

public class Main {
    public static void main(String[] args) {
        CentralHub hub = new CentralHub();

        SmartLight l1 = new SmartLight("L01", "Đèn phòng khách", 80);  // Constructor 1
        SmartLight l2 = new SmartLight("L02", "Đèn ngủ");              // Constructor 2

        System.out.println("Độ sáng ban đầu của l2: " + l2.getBrightness());
        l2.setBrightness("ECO");
        System.out.println("Sau setBrightness(\"ECO\"), l2: " + l2.getBrightness());

        System.out.println("\n=== Kết nối hub ===");
        l1.connectToHub(hub);
        l2.connectToHub(hub);

        System.out.println("\n=== Độ sáng hiện tại ===");
        printLight(l1);
        printLight(l2);

        // Kiểm tra thêm: dữ liệu sai không làm hỏng trạng thái đèn
        System.out.println("\n=== Thử dữ liệu sai ===");
        l1.setBrightness("TURBO");
        l1.setBrightness(150);
        printLight(l1);
    }

    static void printLight(SmartLight light) {
        System.out.println(light.getName() + " (" + light.getId() + "): " + light.getBrightness());
    }
}
