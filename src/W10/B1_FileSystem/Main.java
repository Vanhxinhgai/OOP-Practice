package W10.B1_FileSystem;

import java.util.ArrayList;
import java.util.List;


// 1. Lớp cha chung
abstract class FileSystemItem {
    protected String name;
    protected Folder parent;          // thư mục chứa phần tử này (null nếu là gốc)

    public FileSystemItem(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    // Đường dẫn logic, ví dụ /root/docs/a.txt
    public String getPath() {
        if (parent == null) {
            return "/" + name;                       // phần tử gốc
        }
        return parent.getPath() + "/" + name;        // đường dẫn cha + "/" + tên mình
    }

    // Mỗi loại phần tử tự biết cách in chính mình
    public abstract void print(String indent);
}

// 2. File
class FileItem extends FileSystemItem {
    private int size;                 // đơn vị KB

    public FileItem(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + "KB)");
    }
}

// 3. Shortcut
class Shortcut extends FileSystemItem {
    private FileSystemItem target;    // tham chiếu tới phần tử đích

    public Shortcut(String name, FileSystemItem target) {
        super(name);
        this.target = target;
    }

    @Override
    public void print(String indent) {
        // 4. Đường dẫn được tính từ vị trí thật của target trong cây
        System.out.println(indent + "Shortcut: " + name + " -> " + target.getPath());
    }
}

// 5. Folder
class Folder extends FileSystemItem {
    private List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public void add(FileSystemItem item) {
        children.add(item);
        item.parent = this;           // ghi nhớ thư mục cha để tính đường dẫn
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemItem child : children) {
            child.print(indent + "  ");   // in con với thụt lề tăng thêm 2 dấu cách
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder docs = new Folder("docs");
        FileItem a = new FileItem("a.txt", 12);
        FileItem b = new FileItem("b.txt", 8);
        FileItem readme = new FileItem("readme.md", 4);

        // Dựng cây thư mục 2 cấp
        root.add(docs);
        docs.add(a);
        docs.add(b);
        docs.add(new Shortcut("a-shortcut", a));
        root.add(readme);

        // Chỉ cần gọi print trên thư mục gốc, toàn bộ cây được in ra
        root.print("");
    }
}
