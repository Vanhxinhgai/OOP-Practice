package W9.B1_AppConfig;

class AppConfig {

    // volatile: đảm bảo mọi luồng luôn nhìn thấy giá trị mới nhất của instance,
    // và không thấy một đối tượng "khởi tạo dở dang"
    private static volatile AppConfig instance;

    // Các thuộc tính cấu hình
    private String appName;
    private String version;
    private String logLevel;

    // Constructor private: bên ngoài không thể dùng new AppConfig()
    private AppConfig() {
        System.out.println(">> Đang khởi tạo AppConfig (chỉ được in ra MỘT lần)");
        this.appName = "MyApp";
        this.version = "1.0.0";
        this.logLevel = "INFO";

        // Giả lập việc khởi tạo tốn thời gian (đọc file cấu hình...)
        // để tăng khả năng hai luồng chen nhau, giúp kiểm tra an toàn đa luồng
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Khởi tạo lười + an toàn đa luồng
    public static AppConfig getInstance() {
        if (instance == null) {                      // Kiểm tra lần 1: không khóa, nhanh
            synchronized (AppConfig.class) {         // Chỉ một luồng được vào đây tại một thời điểm
                if (instance == null) {              // Kiểm tra lần 2: trong vùng khóa
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    // Getter và setter
    public String getAppName()  { return appName; }
    public String getVersion()  { return version; }
    public String getLogLevel() { return logLevel; }

    public void setAppName(String appName)   { this.appName = appName; }
    public void setVersion(String version)   { this.version = version; }
    public void setLogLevel(String logLevel) { this.logLevel = logLevel; }

    @Override
    public String toString() {
        return "AppConfig{appName='" + appName + "', version='" + version
                + "', logLevel='" + logLevel + "'}";
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Công việc mà mỗi luồng sẽ làm: lấy AppConfig và in hashCode
        Runnable task = () -> {
            AppConfig config = AppConfig.getInstance();
            System.out.println(Thread.currentThread().getName()
                    + " -> hashCode = " + config.hashCode());
        };

        // Tạo 2 luồng
        Thread t1 = new Thread(task, "Luong-1");
        Thread t2 = new Thread(task, "Luong-2");

        t1.start();   // bắt đầu chạy luồng 1
        t2.start();   // bắt đầu chạy luồng 2

        t1.join();    // chờ luồng 1 chạy xong
        t2.join();    // chờ luồng 2 chạy xong

        // Kiểm tra thêm: lấy lại lần nữa từ luồng main
        AppConfig a = AppConfig.getInstance();
        AppConfig b = AppConfig.getInstance();
        System.out.println("main    -> hashCode = " + a.hashCode());
        System.out.println("a == b ? " + (a == b));
        System.out.println(a);

        // Sửa cấu hình qua a, đọc qua b: thấy ngay thay đổi vì cùng một đối tượng
        a.setLogLevel("DEBUG");
        System.out.println("logLevel đọc qua b: " + b.getLogLevel());
    }
}
