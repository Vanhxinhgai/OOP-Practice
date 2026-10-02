package W2.B2_1_BankAccount;

public class BankAccount {
    // final: chỉ gán được một lần trong constructor, sau đó không đổi được
    private final String accountNumber;
    // private: bên ngoài lớp không truy cập trực tiếp được
    private double balance;
    private String ownerName;

    // Constructor 1: số dư mặc định = 0
    public BankAccount(String accountNumber, String ownerName) {
        this(accountNumber, ownerName, 0); // gọi sang constructor 2
    }

    // Constructor 2: nhận đủ 3 tham số
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (balance < 0) {
            System.out.println("Loi: So du ban dau khong duoc am (" + balance + "). Gan mac dinh = 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Nap tien that bai: so tien phai > 0 (nhan duoc " + amount + ").");
            return;
        }
        balance += amount;
        System.out.println("Nap thanh cong " + amount + ". So du moi: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Rut tien that bai: so tien phai > 0 (nhan duoc " + amount + ").");
            return false;
        }
        if (amount > balance) {
            System.out.println("Rut tien that bai: so du khong du (can " + amount + ", co " + balance + ").");
            return false;
        }
        balance -= amount;
        System.out.println("Rut thanh cong " + amount + ". So du moi: " + balance);
        return true;
    }

    // Chỉ có getter, KHÔNG có setBalance → không ai sửa số dư tùy ý được
    public double getBalance() {
        return balance;
    }

    // accountNumber chỉ có getter (chỉ đọc)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
