package W9.B2_Notification;


interface Notification {
    void send(String msg);
}

// 2. Các sản phẩm cụ thể
class EmailNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("[EMAIL] Gửi email: " + msg);
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("[SMS]   Gửi tin nhắn: " + msg);
    }
}

// 3. Lớp trừu tượng Creator
abstract class NotificationApp {

    // Factory method: lớp con quyết định tạo loại Notification nào
    protected abstract Notification createNotification();

    // Phương thức nghiệp vụ: KHÔNG dùng "new" với lớp cụ thể nào
    public void notifyUser(String msg) {
        Notification notification = createNotification();
        notification.send(msg);
    }
}

// 4. Các lớp con quyết định loại Notification
class EmailApp extends NotificationApp {
    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

class SmsApp extends NotificationApp {
    @Override
    protected Notification createNotification() {
        return new SmsNotification();
    }
}

// 5. Chương trình chính
public class Main {
    public static void main(String[] args) {
        // Chọn một ứng dụng cụ thể: chỉ cần đổi dòng này để đổi kênh gửi
        NotificationApp app = new EmailApp();
        app.notifyUser("Bạn có bài tập mới môn OOP");

        // Thử thêm với ứng dụng SMS
        app = new SmsApp();
        app.notifyUser("Mã OTP của bạn là 123456");
    }
}
