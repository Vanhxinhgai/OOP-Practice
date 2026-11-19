package W9.B5_ChoosePattern;

import java.util.LinkedHashMap;
import java.util.Map;

// YÊU CẦU 1: SINGLETON

class Logger {
    private static volatile Logger instance;
    private int count = 0;                       // đếm số dòng log đã ghi

    private Logger() { }                         // không cho bên ngoài new

    public static Logger getInstance() {         // lazy + an toàn đa luồng
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public synchronized void log(String msg) {
        count++;
        System.out.println("[LOG #" + count + "] " + msg);
    }
}

// YÊU CẦU 2: FACTORY METHOD

interface Export {                                // Product
    void export(String data);
}

class PdfExport implements Export {               // ConcreteProduct
    @Override
    public void export(String data) {
        System.out.println("Xuất PDF  : " + data + " -> baocao.pdf");
    }
}

class ExcelExport implements Export {             // ConcreteProduct
    @Override
    public void export(String data) {
        System.out.println("Xuất Excel: " + data + " -> baocao.xlsx");
    }
}

abstract class ExportCreator {                    // Creator
    // Factory method: lớp con quyết định tạo loại Export nào
    protected abstract Export createExport();

    // Nghiệp vụ dùng nhà máy, không có "new" lớp cụ thể
    public void exportReport(String data) {
        Export exporter = createExport();
        exporter.export(data);
    }
}

class PdfExportCreator extends ExportCreator {    // ConcreteCreator
    @Override
    protected Export createExport() { return new PdfExport(); }
}

class ExcelExportCreator extends ExportCreator {  // ConcreteCreator
    @Override
    protected Export createExport() { return new ExcelExport(); }
}


// YÊU CẦU 3: ADAPTER

class OldPlayer {                                 // Adaptee: KHÔNG sửa
    void playFile(String name) {
        System.out.println("OldPlayer đang phát tệp: " + name);
    }
}

interface Player {                                // Target
    void play(String name);
}

class PlayerAdapter implements Player {           // Adapter (Object Adapter)
    private final OldPlayer oldPlayer;

    public PlayerAdapter(OldPlayer oldPlayer) {
        this.oldPlayer = oldPlayer;
    }

    @Override
    public void play(String name) {
        oldPlayer.playFile(name);                 // chuyển play() -> playFile()
    }
}


// YÊU CẦU 4: PROTOTYPE

class Config implements Cloneable {
    private String host;
    private int port;
    private Map<String, String> options;          // đối tượng sửa được -> phải sao chép sâu

    public Config(String host, int port) {
        this.host = host;
        this.port = port;
        this.options = new LinkedHashMap<>();
    }

    @Override
    public Config clone() {
        try {
            Config copy = (Config) super.clone();             // sao chép nông
            copy.options = new LinkedHashMap<>(this.options); // sao chép sâu phần Map
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void setHost(String host)               { this.host = host; }
    public void setPort(int port)                  { this.port = port; }
    public void setOption(String key, String val)  { options.put(key, val); }

    @Override
    public String toString() {
        return "Config{host='" + host + "', port=" + port + ", options=" + options + "}";
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("===== 1. Singleton: Logger =====");
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();
        log1.log("Khởi động hệ thống");
        log2.log("Ghi log từ biến log2");        // số thứ tự tăng tiếp -> cùng một đối tượng
        System.out.println("log1 == log2 ? " + (log1 == log2));

        System.out.println("\n===== 2. Factory Method: Export =====");
        ExportCreator creator = new PdfExportCreator();   // chọn loại xuất
        creator.exportReport("Doanh thu tháng 11");
        creator = new ExcelExportCreator();               // đổi loại xuất
        creator.exportReport("Doanh thu tháng 11");
        // main không hề có "new PdfExport()" hay "new ExcelExport()"

        System.out.println("\n===== 3. Adapter: Player =====");
        Player player = new PlayerAdapter(new OldPlayer());
        player.play("bai_hat.mp3");                       // gọi theo giao diện mới

        System.out.println("\n===== 4. Prototype: Config =====");
        Config original = new Config("localhost", 8080);
        original.setOption("debug", "false");

        Config copy = original.clone();
        copy.setHost("192.168.1.10");
        copy.setPort(9090);
        copy.setOption("debug", "true");                  // sửa Map của bản sao
        copy.setOption("timeout", "30s");

        System.out.println("Bản gốc : " + original);
        System.out.println("Bản sao : " + copy);
        System.out.println("original == copy ? " + (original == copy));

        Logger.getInstance().log("Kết thúc chương trình");  // vẫn là Logger cũ
    }
}
