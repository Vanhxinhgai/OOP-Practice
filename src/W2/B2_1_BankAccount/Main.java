package W2.B2_1_BankAccount;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Tao tai khoan ===");
        BankAccount acc1 = new BankAccount("001", "Nguyen Van A");
        System.out.println("acc1 so du ban dau: " + acc1.getBalance());

        BankAccount acc2 = new BankAccount("002", "Tran Thi B", -500);
        System.out.println("acc2 so du sau khi tao: " + acc2.getBalance());

        System.out.println("\n=== Kich ban 1: Nap tien am / bang 0 ===");
        acc1.deposit(-1000);
        acc1.deposit(0);
        System.out.println("So du van la: " + acc1.getBalance());

        System.out.println("\n=== Kich ban 2: Nap tien hop le ===");
        acc1.deposit(1000);

        System.out.println("\n=== Kich ban 3: Rut qua so du ===");
        boolean ok1 = acc1.withdraw(5000);
        System.out.println("Ket qua: " + ok1 + ", so du: " + acc1.getBalance());

        System.out.println("\n=== Kich ban 4: Rut so tien am ===");
        boolean ok2 = acc1.withdraw(-200);
        System.out.println("Ket qua: " + ok2 + ", so du: " + acc1.getBalance());

        System.out.println("\n=== Kich ban 5: Rut tien hop le ===");
        boolean ok3 = acc1.withdraw(300);
        System.out.println("Ket qua: " + ok3 + ", so du: " + acc1.getBalance());

        System.out.println("\n=== Kich ban 6: Rut het dung bang so du ===");
        boolean ok4 = acc1.withdraw(700);
        System.out.println("Ket qua: " + ok4 + ", so du: " + acc1.getBalance());

        // Các dòng dưới đây sẽ BÁO LỖI BIÊN DỊCH nếu bỏ comment,
        // chứng minh dữ liệu được bảo vệ:
        // acc1.balance = 1000000;        // lỗi: balance có private access
        // acc1.accountNumber = "999";    // lỗi: balance có private access
        // acc1.setBalance(1000000);      // lỗi: không tồn tại phương thức này
    }
}
