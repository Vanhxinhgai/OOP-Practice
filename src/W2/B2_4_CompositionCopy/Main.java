package W2.B2_4_CompositionCopy;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Nguyễn Văn An", new MyDate(1, 1, 2000));
        Employee emp2 = new Employee(emp1);   // sao chép

        System.out.println("=== Trước khi sửa ===");
        System.out.println("emp1: " + emp1);
        System.out.println("emp2: " + emp2);

        emp1.getBirthday().setDay(2);
        emp1.getBirthday().setMonth(2);
        emp1.getBirthday().setYear(2022);

        System.out.println("\n=== Sau khi sửa ngày sinh emp1 ===");
        System.out.println("emp1: " + emp1);
        System.out.println("emp2: " + emp2);

        System.out.println("\nHai nhân viên dùng chung 1 MyDate? "
                + (emp1.getBirthday() == emp2.getBirthday()));
    }
}
