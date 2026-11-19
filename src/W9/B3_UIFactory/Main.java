package W9.B3_UIFactory;

// 1. Các sản phẩm trừu tượng
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// 3a. Dòng sản phẩm Windows
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("[Windows] Vẽ nút vuông góc, viền xanh dương");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("[Windows] Vẽ ô đánh dấu hình vuông có dấu tích");
    }
}

// 3b. Dòng sản phẩm Mac
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("[Mac]     Vẽ nút bo tròn góc, nền xám nhạt");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("[Mac]     Vẽ ô đánh dấu bo tròn góc");
    }
}

// 2. Nhà máy trừu tượng: tạo CẢ MỘT DÒNG sản phẩm
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// 3. Các nhà máy cụ thể: mỗi nhà máy chỉ sinh sản phẩm cùng một dòng
class WindowsFactory implements UIFactory {
    @Override
    public Button createButton()     { return new WindowsButton(); }

    @Override
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}

class MacFactory implements UIFactory {
    @Override
    public Button createButton()     { return new MacButton(); }

    @Override
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

// Client: KHÔNG biết lớp cụ thể nào, chỉ làm việc qua giao diện
class Application {
    private final Button button;
    private final Checkbox checkbox;

    Application(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    void renderUI() {
        button.render();
        checkbox.render();
    }
}

// 4. Chương trình chính
public class Main {

    // Chọn nhà máy theo tham số cấu hình (chỗ DUY NHẤT nhắc tới lớp cụ thể)
    static UIFactory chooseFactory(String config) {
        switch (config.trim().toLowerCase()) {
            case "win": return new WindowsFactory();
            case "mac": return new MacFactory();
            default:
                throw new IllegalArgumentException(
                        "Cấu hình không hợp lệ: \"" + config + "\". Chỉ nhận \"win\" hoặc \"mac\".");
        }
    }

    public static void main(String[] args) {
        // Lấy tham số dòng lệnh; nếu không truyền thì mặc định là "win"
        String config = (args.length > 0) ? args[0] : "win";
        System.out.println("Cấu hình: " + config);

        try {
            UIFactory factory = chooseFactory(config);
            Application app = new Application(factory);
            app.renderUI();
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
