package W2.B2_10_Overloading_this;

public class SmartLight {
    private String id;
    private String name;
    private int brightness;

    public SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.setBrightness(brightness);
    }

    public SmartLight(String id, String name) {
        this(id, name, 50);
    }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            System.err.println("[LỖI] Độ sáng phải từ 0 đến 100 (nhận " + brightness + ").");
            return;
        }
        this.brightness = brightness;
    }

    public void setBrightness(String preset) {
        if (preset == null) {
            System.err.println("[LỖI] Chế độ không được null.");
            return;
        }
        switch (preset.trim().toUpperCase()) {
            case "MAX":
                this.setBrightness(100);
                break;
            case "MIN":
                this.setBrightness(10);
                break;
            case "ECO":
                this.setBrightness(30);
                break;
            default:
                System.err.println("[LỖI] Không có chế độ '" + preset + "'. Chỉ hỗ trợ MAX, MIN, ECO.");
        }
    }
    public void connectToHub(CentralHub hub) {
        hub.registerDevice(this);
    }

    public String getId()      { return id; }
    public String getName()    { return name; }
    public int getBrightness() { return brightness; }
}
