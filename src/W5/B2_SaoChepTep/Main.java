package W5.B2_SaoChepTep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String duongDanTepNguon = sc.nextLine();
        System.out.print("Nhập đường dẫn tệp đích: ");
        String duongDanTepDich = sc.nextLine();
        BufferedReader br = null;
        PrintWriter pw = null;
        int soDong = 0;

        try {
            br = new BufferedReader(new FileReader(duongDanTepNguon));
            pw = new PrintWriter(new FileWriter(duongDanTepDich));
            String dong;
            while ((dong = br.readLine()) != null) {
                pw.println(dong);
                soDong++;
            }
            if (pw.checkError()) {
                throw new IOException("Lỗi khi ghi vào tệp đích");
            }
            System.out.println("Sao chép thành công " + soDong + " dòng.");

        } catch (FileNotFoundException e) {
            if (br == null) {
                System.out.println("Source file not found.");
            } else {
                System.out.println("Cannot create destination file.");
            }
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();

        } finally {
            if (pw != null) {
                pw.close();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("I/O error.");
                    e.printStackTrace();
                }
            }
            sc.close();
        }
    }
}
