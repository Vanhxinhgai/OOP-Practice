package W4.B3_EmployeeManagement;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

interface IWorkable {
    void work();
}
abstract class Employee implements IWorkable {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public abstract double calculatePay();
}
class OfficeWorker extends Employee {
    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }
    @Override
    public double calculatePay() {
        return baseSalary;
    }
    @Override
    public void work() {
        System.out.println("Soạn thảo văn bản");
    }
}
class Technician extends Employee {
    private int overtimeHours;

    public Technician(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }
    @Override
    public double calculatePay() {
        return baseSalary + overtimeHours * 20000;
    }
    @Override
    public void work() {
        System.out.println("Lắp đặt thiết bị");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double baseSalary = sc.nextDouble();

            if (type.equals("O")) {
                list.add(new OfficeWorker(id, name, baseSalary));
            } else {
                int overtime = sc.nextInt();
                list.add(new Technician(id, name, baseSalary, overtime));
            }
        }
        double total = 0;
        for (Employee e : list) {
            double pay = e.calculatePay();
            System.out.printf(Locale.US, "%s - Pay: %.1f%n", e.name, pay);
            e.work();
            System.out.println();
            total += pay;
        }
        System.out.printf(Locale.US, "Total Pay = %.1f%n", total);
    }
}
