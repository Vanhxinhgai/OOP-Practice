package W2.B2_6_ImmutableObject_DeepCopy;

public class Main {
    public static void main(String[] args) {
        Account acc = new Account("ACC001", 0);
        acc.addTransaction(new Transaction("T001", 1000000, "2026-10-08 09:00"));
        acc.addTransaction(new Transaction("T002", -300000, "2026-10-08 10:30"));
        acc.addTransaction(new Transaction("T003", 500000, "2026-10-08 14:15"));

        System.out.println("=== Lịch sử gốc ===");
        acc.printHistory();
        System.out.println("\n=== HACKER tấn công ===");
        Transaction[] stolen = acc.getHistory();

        stolen[1] = new Transaction("T002", 9999999, "2026-10-08 10:30");
        stolen[0] = null;

        System.out.println("Mảng hacker đang cầm sau khi sửa:");
        for (Transaction t : stolen) {
            System.out.println("  " + t);
        }

        System.out.println("\n=== Dữ liệu bên trong Account ===");
        acc.printHistory();

        System.out.println("\nHai lần gọi getHistory() trả về cùng 1 mảng? "
                + (acc.getHistory() == acc.getHistory()));
    }
}
