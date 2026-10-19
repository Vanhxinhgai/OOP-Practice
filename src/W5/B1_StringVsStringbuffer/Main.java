package W5.B1_StringVsStringbuffer;

public class Main {

    static final int SO_LAN = 100_000;
    // HÀM 1: Nối chuỗi bằng useString
    public static void useString() {
        long batDau = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < SO_LAN; i++) {
            s = s + "Hello";
        }
        long ketThuc = System.currentTimeMillis();
        System.out.println("[String]       Độ dài: " + s.length()
                + " | Thời gian: " + (ketThuc - batDau) + " ms");
    }

    // HÀM 2: Nối chuỗi bằng StringBuffer
    public static void useStringBuffer() {
        long batDau = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < SO_LAN; i++) {
            sb.append("Hello");
        }
        String ketQua = sb.toString();
        long ketThuc = System.currentTimeMillis();
        System.out.println("[StringBuffer] Độ dài: " + ketQua.length()
                + " | Thời gian: " + (ketThuc - batDau) + " ms");
    }

    //  HÀM 3: Phân tích nội dung văn bản
    public static void contentAnalysis(String vanBan) {
        System.out.println("\n VĂN BẢN GỐC ");
        System.out.println(vanBan);

        // 3a. Đếm số câu
        int soCau = demSoLuongCau(vanBan);
        System.out.println("\nSố câu: " + soCau);

        // 3b. Tìm và thay thế "Java" -> "Python"
        StringBuffer sb = new StringBuffer(vanBan);
        int soLanThay = timVaThayThe(sb, "Java", "Python");
        System.out.println("Số lần thay thế: " + soLanThay);
        System.out.println("\n VĂN BẢN SAU KHI THAY THẾ ");
        System.out.println(sb.toString());
    }

    static boolean laDauKetThuc(char c) {
        return c == '.' || c == '?' || c == '!';
    }

    static int demSoLuongCau(String vanBan) {
        int dem = 0;
        int n = vanBan.length();
        for (int i = 0; i < n; i++) {
            char c = vanBan.charAt(i);
            if (!laDauKetThuc(c)) continue;
            if (c == '.' && i > 0 && i < n - 1
                    && Character.isDigit(vanBan.charAt(i - 1))
                    && Character.isDigit(vanBan.charAt(i + 1))) {
                continue;
            }
            if (i < n - 1 && laDauKetThuc(vanBan.charAt(i + 1))) continue;
            dem++;
        }
        return dem;
    }
    static int timVaThayThe(StringBuffer sb, String tuCu, String tuMoi) {
        int dem = 0;
        int viTri = sb.indexOf(tuCu);
        while (viTri != -1) {
            int cuoi = viTri + tuCu.length();
            boolean benTraiOk = (viTri == 0)
                    || !Character.isLetterOrDigit(sb.charAt(viTri - 1));
            boolean benPhaiOk = (cuoi == sb.length())
                    || !Character.isLetterOrDigit(sb.charAt(cuoi));
            if (benTraiOk && benPhaiOk) {
                sb.replace(viTri, cuoi, tuMoi);
                dem++;
                viTri = sb.indexOf(tuCu, viTri + tuMoi.length());
            } else {
                viTri = sb.indexOf(tuCu, cuoi);
            }
        }
        return dem;
    }
    public static void main(String[] args) {
        System.out.println("SO SÁNH TỐC ĐỘ NỐI CHUỖI (" + SO_LAN + " lần) ");
        useString();
        useStringBuffer();

        String vanBan = "Java là một ngôn ngữ lập trình phổ biến! Bạn đã học Java chưa? "
                + "Con gà có trước hay quả trứng có trước? "
                + "Lập trình hướng đối tương. ";

        contentAnalysis(vanBan);
    }
}
