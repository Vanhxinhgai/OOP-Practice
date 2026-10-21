package W5.B5_CustomException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {

    static void tachDong(String dong, int soDong, Map<String, String> cauHinh)
            throws InvalidConfigException {
        int viTri = dong.indexOf('=');
        if (viTri == -1) {
            throw new InvalidConfigException("dòng " + soDong
                    + " không đúng dạng key=value: \"" + dong + "\"");
        }
        String key = dong.substring(0, viTri).trim();     // trước dấu =
        String value = dong.substring(viTri + 1).trim();  // phần sau dấu =
        if (key.isEmpty()) {
            throw new InvalidConfigException("dòng " + soDong + " thiếu tên tham số (key)");
        }
        cauHinh.put(key, value);
    }
    static void kiemTraCauHinh(Map<String, String> cauHinh) throws InvalidConfigException {
        if (!cauHinh.containsKey("username") || cauHinh.get("username").isEmpty()) {
            throw new InvalidConfigException("thiếu tham số bắt buộc 'username'");
        }
        if (!cauHinh.containsKey("timeout")) {
            throw new InvalidConfigException("thiếu tham số bắt buộc 'timeout'");
        }
        int timeout = Integer.parseInt(cauHinh.get("timeout"));
        if (timeout <= 0) {
            throw new InvalidConfigException("timeout phải lớn hơn 0 (đang là " + timeout + ")");
        }
        if (cauHinh.containsKey("maxConnections")) {
            int maxConn = Integer.parseInt(cauHinh.get("maxConnections"));
            if (maxConn < 1) {
                throw new InvalidConfigException("maxConnections phải lớn hơn hoặc bằng 1 (đang là "
                        + maxConn + ")");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = null;
        Map<String, String> cauHinh = new LinkedHashMap<>();
        try {
            System.out.print("Nhập đường dẫn file cấu hình: ");
            String duongDan = sc.nextLine().trim();
            br = new BufferedReader(new FileReader(duongDan));
            String dong;
            int soDong = 0;
            while ((dong = br.readLine()) != null) {
                soDong++;
                dong = dong.trim();
                if (dong.isEmpty() || dong.startsWith("#")) {
                    continue;
                }
                tachDong(dong, soDong, cauHinh);
            }
            kiemTraCauHinh(cauHinh);
            System.out.println("\nCấu hình đọc được:");
            for (Map.Entry<String, String> muc : cauHinh.entrySet()) {
                System.out.println("  " + muc.getKey() + " = " + muc.getValue());
            }
            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());

        } finally {
            // 5. Luôn đóng file
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("I/O error.");
                    e.printStackTrace();
                }
            }
            sc.close();
            // 6. Luôn in dòng này
            System.out.println("Program finished.");
        }
    }
}
