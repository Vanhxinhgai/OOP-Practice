package W2.B2_6_ImmutableObject_DeepCopy;

import java.util.Arrays;

public class Account {
    private final String accountId;
    private double balance;
    private Transaction[] history;
    private int count;                          // số giao dịch thực tế đang có

    public Account(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = Math.max(0, initialBalance);
        this.history = new Transaction[2];      // dung lượng ban đầu, tự tăng khi đầy
        this.count = 0;
    }

    public boolean addTransaction(Transaction t) {
        if (t == null) {
            System.out.println("[LỖI] Giao dịch không được null.");
            return false;
        }
        if (balance + t.getAmount() < 0) {
            System.out.println("[LỖI] Giao dịch " + t.getTransactionId() + " làm số dư âm. Từ chối.");
            return false;
        }
        if (count == history.length) {          // mảng đầy -> tạo mảng mới gấp đôi
            history = Arrays.copyOf(history, history.length * 2);
        }
        history[count++] = t;
        balance += t.getAmount();
        return true;
    }

    // ĐIỂM MẤU CHỐT: trả về BẢN SAO của mảng, không phải mảng gốc
    public Transaction[] getHistory() {
        return Arrays.copyOf(history, count);
    }

    public String getAccountId() { return accountId; }
    public double getBalance()   { return balance; }

    public void printHistory() {
        System.out.printf("Tài khoản %s | Số dư: %.0f%n", accountId, balance);
        for (int i = 0; i < count; i++) {
            System.out.println("  " + history[i]);
        }
    }
}
