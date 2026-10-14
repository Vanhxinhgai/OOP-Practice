package W4.B7_LambdaRevolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId()   { return id; }
    public String getName() { return name; }
    public double getGpa()  { return gpa; }

    @Override
    public String toString() {
        return id + " " + name + " " + gpa;
    }
}

@FunctionalInterface
interface Operation<T> {
    T execute(T a, T b);
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double gpa = sc.nextDouble();
            students.add(new Student(id, name, gpa));
        }

        // 1. Filter
        students.removeIf(student -> student.getGpa() < 5.0);
        System.out.println("After removing GPA < 5.0:");
        students.forEach(s -> System.out.println(s));

        // 2. Sort
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println();
        System.out.println("After sorting by name:");
        students.forEach(s -> System.out.println(s));

        // 3. Custom functional interface
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> sub = (a, b) -> a - b;
        Operation<Double> mul = (a, b) -> a * b;
        Operation<Double> div = (a, b) -> a / b;

        double x = 10, y = 4;
        // Bỏ dấu // để xem kết quả các phép tính:
        // System.out.println(x + " + " + y + " = " + add.execute(x, y));
        // System.out.println(x + " - " + y + " = " + sub.execute(x, y));
        // System.out.println(x + " * " + y + " = " + mul.execute(x, y));
        // System.out.println(x + " / " + y + " = " + div.execute(x, y));
    }
}
