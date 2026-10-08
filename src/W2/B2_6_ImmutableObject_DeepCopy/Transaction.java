package W2.B2_6_ImmutableObject_DeepCopy;

public final class Transaction {               // final: không cho lớp con kế thừa
    private final String transactionId;        // private: không truy cập trực tiếp
    private final double amount;               // final: chỉ gán 1 lần trong constructor
    private final String timestamp;

    public Transaction(String transactionId, double amount, String timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Chỉ có getter, KHÔNG có setter
    public String getTransactionId() { return transactionId; }
    public double getAmount()        { return amount; }
    public String getTimestamp()     { return timestamp; }

    @Override
    public String toString() {
        return String.format("Transaction[id=%s, amount=%.0f, time=%s]",
                transactionId, amount, timestamp);
    }
}
