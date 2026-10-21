package W5.B3_DocGhiDuLieu;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class GhiDuLieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataOutputStream dos = null;

        try {
            System.out.print("Nhập tên tệp cần ghi: ");
            String tenTep = sc.nextLine();
            System.out.print("Nhập số lượng n: ");
            int n = sc.nextInt();
            if (n <= 0) {
                System.out.println("n phải là số nguyên dương.");
                return;
            }
            int[] mang = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập số thứ " + (i + 1) + ": ");
                mang[i] = sc.nextInt();
            }
            dos = new DataOutputStream(new FileOutputStream(tenTep));
            for (int so : mang) {
                dos.writeInt(so);
            }
            System.out.println("Đã ghi " + n + " số vào tệp \"" + tenTep + "\" ("
                    + dos.size() + " byte).");

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập số nguyên!");
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không thể tạo tệp. Kiểm tra lại đường dẫn.");
        } catch (IOException e) {
            System.out.println("Lỗi vào/ra khi ghi tệp.");
            e.printStackTrace();

        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng tệp.");
                    e.printStackTrace();
                }
            }
            sc.close();
        }
    }
}
