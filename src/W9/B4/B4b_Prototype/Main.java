package W9.B4.B4b_Prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

Class ReportTemplate implements Cloneable {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = new ArrayList<>(sections);
    }

    // Sao chép sâu (deep copy)
    @Override
    public ReportTemplate clone() {
        try {
            // Bước 1: Object.clone() tạo bản sao NÔNG (chép từng thuộc tính)
            ReportTemplate copy = (ReportTemplate) super.clone();
            // Bước 2: tạo danh sách MỚI cho bản sao,
            // để bản sao và bản gốc không dùng chung một danh sách
            copy.sections = new ArrayList<>(this.sections);
            return copy;
        } catch (CloneNotSupportedException e) {
            // Không xảy ra vì lớp đã implements Cloneable
            throw new AssertionError(e);
        }
    }

    public void setTitle(String title)  { this.title = title; }
    public void addSection(String s)    { sections.add(s); }

    public void print() {
        System.out.println("==============================");
        System.out.println("Tiêu đề : " + title);
        for (int i = 0; i < sections.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + sections.get(i));
        }
        System.out.println("Chân trang: " + footer);
    }
}

public class Main {
    public static void main(String[] args) {
        // Template gốc
        ReportTemplate template = new ReportTemplate(
                "Báo cáo mẫu",
                "Trường ĐH Công nghệ - ĐHQG Hà Nội",
                Arrays.asList("Giới thiệu", "Nội dung", "Kết luận"));

        // Sinh 2 bản sao từ template
        ReportTemplate report1 = template.clone();
        ReportTemplate report2 = template.clone();

        // Chỉnh sửa tiêu đề mỗi bản sao khác nhau
        report1.setTitle("Báo cáo tháng 11");
        report2.setTitle("Báo cáo quý 4");

        // Thêm mục vào bản sao để kiểm tra sao chép sâu
        report2.addSection("Phụ lục");

        System.out.println(">>> Template gốc");
        template.print();
        System.out.println(">>> Bản sao 1");
        report1.print();
        System.out.println(">>> Bản sao 2");
        report2.print();

        System.out.println("\ntemplate == report1 ? " + (template == report1));
    }
}
