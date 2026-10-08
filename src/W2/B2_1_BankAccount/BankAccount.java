package W2.B2_1_BankAccount;

public class BankAccount {
    // ===== 1. THUỘC TÍNH =====
    private final String accountNumber; // final: chỉ gán 1 lần, không đổi được
    private double balance;             // private: bên ngoài không truy cập trực tiếp
    private String ownerName;

    // ===== 2. CONSTRUCTOR =====

    // Constructor 2 tham số: số dư mặc định = 0
    public BankAccount(String accountNumber, String ownerName) {
        this(accountNumber, ownerName, 0); // gọi lại constructor 3 tham số
    }

    // Constructor 3 tham số: kiểm tra số dư ban đầu
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (balance < 0) {
            System.out.println("[LỖI] Số dư ban đầu không được âm (" + balance + "). Đặt về 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // ===== 3. PHƯƠNG THỨC =====

    // Nạp tiền: số tiền phải > 0
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("[LỖI] Số tiền nạp phải lớn hơn 0. Giao dịch bị từ chối.");
            return;
        }
        balance += amount;
        System.out.println("Nạp thành công " + amount + ". Số dư mới: " + balance);
    }

    // Rút tiền: 0 < amount <= balance, trả về true/false
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("[LỖI] Số tiền rút phải lớn hơn 0.");
            return false;
        }
        if (amount > balance) {
            System.out.println("[LỖI] Số dư không đủ. Muốn rút " + amount + ", hiện có " + balance);
            return false;
        }
        balance -= amount;
        System.out.println("Rút thành công " + amount + ". Số dư còn: " + balance);
        return true;
    }

    // Chỉ có getter, KHÔNG có setter cho balance
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
