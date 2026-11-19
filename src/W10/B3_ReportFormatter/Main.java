package W10.B3_ReportFormatter;

//  Dữ liệu báo cáo: chỉ lo lưu thông tin
class Report {
    private final String title;
    private final String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle()   { return title; }
    public String getContent() { return content; }
}

// Giao diện định dạng: điểm "mở để mở rộng
interface ReportFormatter {
    String format(Report report);
}

// Các định dạng cụ thể: mỗi lớp lo đúng một định dạng
class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "{\n"
                + "  \"title\": \"" + escape(report.getTitle()) + "\",\n"
                + "  \"content\": \"" + escape(report.getContent()) + "\"\n"
                + "}";
    }

    // Thoát các ký tự đặc biệt của JSON (dấu \ và dấu ")
    private String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}

class XmlFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "<report>\n"
                + "  <title>" + escape(report.getTitle()) + "</title>\n"
                + "  <content>" + escape(report.getContent()) + "</content>\n"
                + "</report>";
    }

    // Thoát các ký tự đặc biệt của XML (&, <, >)
    private String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}

// Định dạng thứ ba, thêm vào để chứng minh OCP: KHÔNG sửa ReportService
class CsvFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "title,content\n"
                + quote(report.getTitle()) + "," + quote(report.getContent());
    }

    // Trong CSV, ô chứa dấu phẩy phải đặt trong ngoặc kép, dấu " nhân đôi
    private String quote(String s) {
        return "\"" + s.replace("\"", "\"\"") + "\"";
    }
}

// Dịch vụ xuất báo cáo: KHÔNG biết chi tiết định dạng nào
class ReportService {
    private final ReportFormatter formatter;

    // Nhận formatter từ bên ngoài qua constructor (tiêm phụ thuộc)
    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public String export(Report data) {
        return formatter.format(data);      // không có if/else theo kiểu
    }
}
public class Main {
    public static void main(String[] args) {
        Report report = new Report("Báo cáo tháng 11", "Doanh thu tăng 15%, chi phí giảm 5%");

        // Chọn định dạng JSON
        ReportService jsonService = new ReportService(new JsonFormatter());
        System.out.println("=== JSON ===");
        System.out.println(jsonService.export(report));

        // Chọn định dạng XML
        ReportService xmlService = new ReportService(new XmlFormatter());
        System.out.println("\n=== XML ===");
        System.out.println(xmlService.export(report));

        // Định dạng mới CSV: chỉ thêm lớp, ReportService giữ nguyên
        ReportService csvService = new ReportService(new CsvFormatter());
        System.out.println("\n=== CSV ===");
        System.out.println(csvService.export(report));
    }
}
