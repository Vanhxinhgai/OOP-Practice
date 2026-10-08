package W2.B2_1_BankAccount;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Tạo tài khoản ===");
        BankAccount acc1 = new BankAccount("001", "Nguyễn Văn A");
        BankAccount acc2 = new BankAccount("002", "Trần Thị B", -500); // số dư âm
        System.out.println("acc2 số dư: " + acc2.getBalance());

        System.out.println("\n=== Kịch bản 1: Nạp tiền hợp lệ ===");
        acc1.deposit(1000000);

        System.out.println("\n=== Kịch bản 2: Nạp tiền âm ===");
        acc1.deposit(-50000);

        System.out.println("\n=== Kịch bản 3: Rút quá số dư ===");
        boolean kq1 = acc1.withdraw(5000000);
        System.out.println("Kết quả: " + kq1);

        System.out.println("\n=== Kịch bản 4: Rút tiền hợp lệ ===");
        boolean kq2 = acc1.withdraw(300000);
        System.out.println("Kết quả: " + kq2);

        System.out.println("\n=== Kịch bản 5: Rút số tiền âm ===");
        System.out.println("Kết quả: " + acc1.withdraw(-100));
        System.out.println("\n=== Số dư cuối cùng ===");
        System.out.println(acc1.getOwnerName() + " (" + acc1.getAccountNumber()
                + "): " + acc1.getBalance());

    }
}
