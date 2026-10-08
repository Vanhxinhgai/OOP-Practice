package W2.B2_10_Overloading_this;

public class CentralHub {
    public void registerDevice(SmartLight light) {
        System.out.println("[HUB] Đang kết nối với thiết bị: " + light.getName());
    }
}
