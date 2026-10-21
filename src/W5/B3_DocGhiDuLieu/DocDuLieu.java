package W5.B3_DocGhiDuLieu;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class DocDuLieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataInputStream dis = null;
        int dem = 0;

        try {
            System.out.print("Nhập tên tệp cần đọc: ");
            String tenTep = sc.nextLine();
            dis = new DataInputStream(new FileInputStream(tenTep));
            System.out.println("Các số trong tệp:");
            while (true) {
                int so = dis.readInt();
                dem++;
                System.out.println("  Số thứ " + dem + ": " + so);
            }

        } catch (EOFException e) {
            System.out.println("Đã đọc hết tệp. Tổng cộng " + dem + " số.");
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy tệp.");
        } catch (IOException e) {
            System.out.println("Lỗi vào/ra khi đọc tệp.");
            e.printStackTrace();

        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng tệp.");
                    e.printStackTrace();
                }
            }
            sc.close();
        }
    }
}
