package W10.B2_Decorator;


// 1. Giao diện chung
interface Notifier {
    void send(String msg);
}

// 2. Kênh mặc định
class EmailNotifier implements Notifier {
    @Override
    public void send(String msg) {
        System.out.println("[Email]    " + msg);
    }
}

// 3. Lớp trang trí cơ sở
abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;     // đối tượng được bọc bên trong

    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String msg) {
        wrappee.send(msg);                // chuyển tiếp cho đối tượng bên trong
    }
}

// 4. Các decorator cụ thể: gửi phần bên trong rồi THÊM một kênh
class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String msg) {
        super.send(msg);                  // gửi qua các kênh đã gắn trước đó
        sendSms(msg);                     // thêm kênh SMS
    }

    private void sendSms(String msg) {
        System.out.println("[SMS]      " + msg);
    }
}

class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        sendFacebook(msg);
    }

    private void sendFacebook(String msg) {
        System.out.println("[Facebook] " + msg);
    }
}

class SlackNotifier extends NotifierDecorator {
    public SlackNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        sendSlack(msg);
    }

    private void sendSlack(String msg) {
        System.out.println("[Slack]    " + msg);
    }
}


public class Main {
    public static void main(String[] args) {
        // Tổ hợp 1: Email + Facebook + SMS (giống slide)
        System.out.println("--- Email + Facebook + SMS ---");
        Notifier n = new EmailNotifier();
        n = new FacebookNotifier(n);
        n = new SMSNotifier(n);
        n.send("Lớp OOP nghỉ học sáng mai");

        // Tổ hợp 2: Email + Slack, KHÔNG cần tạo lớp mới
        System.out.println("\n--- Email + Slack ---");
        Notifier n2 = new SlackNotifier(new EmailNotifier());
        n2.send("Đã có điểm giữa kỳ");

        // Chỉ kênh mặc định
        System.out.println("\n--- Chỉ Email ---");
        Notifier n3 = new EmailNotifier();
        n3.send("Chào mừng bạn đến với hệ thống");
    }
}
