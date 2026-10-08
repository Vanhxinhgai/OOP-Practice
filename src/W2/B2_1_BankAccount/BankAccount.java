package W2.B2_1_BankAccount;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName) {
        this(accountNumber, ownerName, 0); // gọi lại constructor 3 tham số
    }

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

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("[LỖI] Số tiền nạp phải lớn hơn 0. Giao dịch bị từ chối.");
            return;
        }
        balance += amount;
        System.out.println("Nạp thành công " + amount + ". Số dư mới: " + balance);
    }

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
