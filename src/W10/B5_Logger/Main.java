package W10.B5_Logger;
class Logger {
    // Đối tượng duy nhất, ban đầu chưa được tạo
    private static Logger instance;

    // Constructor private: bên ngoài không thể gọi new Logger()
    private Logger() { }

    // Trả về đối tượng duy nhất; tạo mới ở lần gọi đầu tiên (lazy initialization)
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logInfo(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public void logError(String msg) {
        System.out.println("[ERROR] " + msg);
    }
}

// Một lớp khác trong hệ thống cũng cần ghi log:
// nó tự gọi Logger.getInstance(), không nhận logger từ main
class DataProcessor {
    private final Logger logger = Logger.getInstance();

    public Logger getLogger() { return logger; }

    public void process() {
        logger.logInfo("Processing data...");
    }

    public void handleFailure() {
        Logger.getInstance().logError("Something went wrong");
    }
}

public class Main {
    public static void main(String[] args) {
        // Nơi 1: lấy logger trong main
        Logger logger1 = Logger.getInstance();

        // Nơi 2: lấy logger lần nữa trong main
        Logger logger2 = Logger.getInstance();

        // Nơi 3: lớp DataProcessor tự lấy logger
        DataProcessor processor = new DataProcessor();

        // Kiểm tra cùng địa chỉ: == so sánh tham chiếu (địa chỉ), không so nội dung
        boolean same = (logger1 == logger2) && (logger1 == processor.getLogger());
        System.out.println("Logger instances equal: " + same);

        // Ghi nhiều log từ nhiều nơi khác nhau
        logger1.logInfo("Application started");
        processor.process();
        processor.handleFailure();

        // Logger logger3 = new Logger();   // LỖI BIÊN DỊCH: Logger() has private access
    }
}
