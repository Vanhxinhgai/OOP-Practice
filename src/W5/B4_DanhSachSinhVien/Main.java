package W5.B4_DanhSachSinhVien;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> nhapDanhSach(Scanner sc) {
        ArrayList<Student> ds = new ArrayList<>();
        System.out.println("Nhập thông tin sinh viên (gõ END ở ô Mã SV để kết thúc).");

        while (true) {
            System.out.print("\nMã SV: ");
            String id = sc.nextLine().trim();
            if (id.equalsIgnoreCase("END")) {
                break;
            }
            if (id.isEmpty()) {
                System.out.println("Mã SV không được để trống.");
                continue;
            }
            System.out.print("Họ tên: ");
            String name = sc.nextLine().trim();
            double gpa;
            while (true) {
                System.out.print("GPA (0 - 4): ");
                try {
                    gpa = Double.parseDouble(sc.nextLine().trim());
                    if (gpa >= 0 && gpa <= 4) break;
                    System.out.println("GPA phải nằm trong khoảng 0 đến 4.");
                } catch (NumberFormatException e) {
                    System.out.println("GPA phải là một số (dùng dấu chấm, ví dụ 3.25).");
                }
            }
            ds.add(new Student(id, name, gpa));
            System.out.println("-> Đã thêm sinh viên " + name);
        }
        return ds;
    }

    static void ghiDanhSach(ArrayList<Student> ds, String tenTep) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(tenTep));
            for (Student sv : ds) {
                oos.writeObject(sv);
            }
            System.out.println("\nĐã ghi " + ds.size() + " sinh viên vào tệp \"" + tenTep + "\".");

        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không thể tạo tệp \"" + tenTep + "\".");
        } catch (IOException e) {
            System.out.println("Lỗi vào/ra khi ghi tệp.");
            e.printStackTrace();

        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng tệp ghi.");
                    e.printStackTrace();
                }
            }
        }
    }

    static void docDanhSach(String tenTep) {
        ObjectInputStream ois = null;
        int dem = 0;
        try {
            ois = new ObjectInputStream(new FileInputStream(tenTep));
            System.out.println("\nDANH SÁCH SINH VIÊN ĐỌC TỪ TỆP");
            System.out.println(String.format("%-4s %-10s | %-25s | %s", "STT", "Mã SV", "Họ tên", "GPA"));
            System.out.println("---------------------------------------------------");
            while (true) {
                Student sv = (Student) ois.readObject();
                dem++;
                System.out.println(String.format("%-4d %s", dem, sv));
            }
        } catch (EOFException e) {
            System.out.println("---------------------------------------------------");
            System.out.println("Đã đọc hết tệp. Tổng cộng " + dem + " sinh viên.");
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy lớp để khôi phục đối tượng từ tệp.");
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy tệp \"" + tenTep + "\".");
        } catch (IOException e) {
            System.out.println("Lỗi vào/ra khi đọc tệp.");
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng tệp đọc.");
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên tệp lưu danh sách");
        String tenTep = sc.nextLine().trim();
        ArrayList<Student> ds = nhapDanhSach(sc);
        ghiDanhSach(ds, tenTep);
        docDanhSach(tenTep);
        sc.close();
    }
}
