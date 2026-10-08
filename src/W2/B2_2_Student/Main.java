package W2.B2_2_Student;

public class Main {
    public static void main(String[] args) {
        // Cách 1: constructor không tham số + setter
        System.out.println("=== SV1: constructor không tham số ===");
        Student s1 = new Student();
        System.out.println("Ban đầu: " + s1);
        s1.setId("SV001");
        s1.setName("Nguyễn Văn An");
        s1.setEmail("an@gmail.com");
        s1.setGpa(3.2);
        System.out.println("Sau khi set: " + s1);

        // Cách 2: constructor (id, name)
        System.out.println("\n=== SV2: constructor (id, name) ===");
        Student s2 = new Student("SV002", "Trần Thị Bình");
        s2.setGpa(-1.5);              // GPA âm -> bị từ chối
        System.out.println(s2);

        // Cách 3: constructor đầy đủ tham số
        System.out.println("\n=== SV3: constructor đầy đủ ===");
        Student s3 = new Student("SV003", "Lê Văn Cường", "cuong@gmail.com", 3.8);
        s3.setGpa(-2.0);              // GPA âm -> giữ nguyên 3.8
        s3.setGpa(5.0);               // GPA > 4 -> giữ nguyên 3.8
        s3.setEmail("cuong-gmail");   // email sai -> giữ nguyên
        System.out.println(s3);

        // Cách 4: copy constructor
        System.out.println("\n=== SV4: copy constructor (sao chép SV3) ===");
        Student s4 = new Student(s3);
        s4.setId("SV004");
        s4.setName("Phạm Thị Dung");
        System.out.println("s4: " + s4);
        System.out.println("s3: " + s3 + "  <- không bị ảnh hưởng");

        // Thử tạo bằng constructor đầy đủ nhưng GPA sai ngay từ đầu
        System.out.println("\n=== SV5: GPA sai ngay khi khởi tạo ===");
        Student s5 = new Student("SV005", "Hoàng Văn Em", "em@gmail.com", -3.0);
        System.out.println(s5);
    }
}
