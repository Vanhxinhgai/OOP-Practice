package W5.B2_CustomerSupportSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Customer {
    private int id;
    private String name;
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    @Override
    public String toString() {
        return "Số " + id + " - " + name;
    }
}

class Message {
    private int id;
    private String content;
    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }
    public int getId() { return id; }
    public String getContent() { return content; }
    @Override
    public String toString() {
        return "[Tin nhắn " + id + "] " + content;
    }
}

class Ticket {
    private static final DateTimeFormatter DINH_DANG =
            DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
    private int id;
    private Customer customer;       // khách hàng gửi yêu cầu
    private String content;          // nội dung yêu cầu
    private LocalDateTime timestamp; // thời điểm gửi
    public Ticket(int id, Customer customer, String content) {
        this.id = id;
        this.customer = customer;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Ticket " + id + " | " + customer + " | \"" + content
                + "\" | Lúc: " + timestamp.format(DINH_DANG);
    }
}

class CustomerQueue {
    private Queue<Ticket> queue = new LinkedList<>();
    public void addRequest(Ticket ticket) {
        queue.offer(ticket);
        System.out.println("+ Đã nhận yêu cầu: " + ticket);
        System.out.println("+ Số khách hàng đang đợi: " + queue.size());
    }
    public Ticket processNext() {
        Ticket ticket = queue.poll();
        if (ticket == null) {
            System.out.println("Không còn khách đợi");
        }
        return ticket;
    }
    public boolean isEmpty() { return queue.isEmpty(); }
    public int size() { return queue.size(); }
    public void showQueue() {
        System.out.println(" Danh sách hàng đợi (" + queue.size() + " khách) ");
        int thuTu = 1;
        for (Ticket t : queue) {
            System.out.println("  " + thuTu + ". " + t);
            thuTu++;
        }
    }
}

class MessageHistory {
    private Stack<Message> stack = new Stack<>();
    private int nextId = 1;
    public void type(String content) {
        Message m = new Message(nextId++, content);
        stack.push(m);
        System.out.println("  Nhân viên gõ: " + m);
    }
    public void undo() {
        if (stack.isEmpty()) {
            System.out.println("  Không có tin nhắn nào để Undo");
            return;
        }
        Message m = stack.pop();
        System.out.println(" UNDO " + m);
    }
    public void viewLast() {
        if (stack.isEmpty()) {
            System.out.println(" Chưa có tin nhắn nào");
            return;
        }
        System.out.println("  (View Last) Câu vừa gõ: " + stack.peek());
    }
    public void showAll() {
        System.out.println("  --- Các tin nhắn sẽ gửi cho khách ---");
        for (Message m : stack) {   // duyệt từ đáy lên đỉnh = đúng thứ tự gõ
            System.out.println("    " + m);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CustomerQueue hangDoi = new CustomerQueue();
        Customer khachA = new Customer(1, "Nguyễn Văn A");
        Customer khachB = new Customer(2, "Trần Thị B");
        System.out.println("BƯỚC 1: KHÁCH A ĐẾN ");
        hangDoi.addRequest(new Ticket(101, khachA, "Đơn hàng giao chậm 5 ngày"));
        System.out.println("\nBƯỚC 2: KHÁCH B ĐẾN ");
        hangDoi.addRequest(new Ticket(102, khachB, "Muốn đổi size áo"));
        System.out.println();
        hangDoi.showQueue();
        System.out.println("\nBƯỚC 3: XỬ LÝ KHÁCH ĐẦU TIÊN");
        Ticket ticket1 = hangDoi.processNext();
        if (ticket1 != null) {
            System.out.println(">> Đang xử lý: " + ticket1);
            MessageHistory lichSu1 = new MessageHistory();
            lichSu1.type("Chào anh A, em đã nhận được yêu cầu của anh.");
            lichSu1.type("Đơn hàng của anh đang được giao, dự kiến đến trong 2 ngày.");
            lichSu1.type("Em xin tặng anh mã giảm giá 100% cho mọi đơn hàng.");
            lichSu1.viewLast();
            lichSu1.undo();
            lichSu1.viewLast();
            lichSu1.showAll();
            System.out.println("  Còn lại " + hangDoi.size() + " khách đang đợi.");
        }
        System.out.println("\nBƯỚC 4: XỬ LÝ KHÁCH TIẾP THEO ");
        Ticket ticket2 = hangDoi.processNext();
        if (ticket2 != null) {
            System.out.println(" Đang xử lý: " + ticket2);
            MessageHistory lichSu2 = new MessageHistory();
            lichSu2.type("Chào chị B, shop đã nhận yêu cầu đổi size của chị.");
            lichSu2.type("Chị vui lòng gửi lại áo, shop sẽ đổi size mới miễn phí ạ.");

            lichSu2.showAll();
            System.out.println("  Còn lại " + hangDoi.size() + " khách đang đợi.");
        }
        System.out.println("\nBƯỚC 5: BẤM XỬ LÝ KHI HẾT KHÁCH");
        hangDoi.processNext();
    }
}

