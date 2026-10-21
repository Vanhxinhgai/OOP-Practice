package W5.B1_PhepChiaAnToan;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập số nguyên a: ");
            int a = sc.nextInt();
            System.out.print("Nhập số nguyên b: ");
            int b = sc.nextInt();
            int ketQua = a / b;
            System.out.println("Kết quả: " + a + " / " + b + " = " + ketQua);

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Phải nhập số nguyên");
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: Không chia cho 0");

        } finally {
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
