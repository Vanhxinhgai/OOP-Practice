package W2.B2_2_Student;

public class Student {
    private String id;
    private String name;
    private String email;
    private double gpa;

    // 1. Constructor không tham số
    public Student() {
        this.id = "UNKNOWN";
        this.name = "Chua co ten";
        this.email = "";
        this.gpa = 0.0;
    }

    // 2. Constructor (id, name)
    public Student(String id, String name) {
        this();
        setId(id);
        setName(name);
    }

    // 3. Constructor đầy đủ tham số
    public Student(String id, String name, String email, double gpa) {
        this(id, name);
        setEmail(email);
        setGpa(gpa);
    }

    // 4. Copy constructor
    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.gpa = other.gpa;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getGpa() { return gpa; }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Loi: ID khong duoc rong. Giu nguyen: " + this.id);
            return;
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Loi: Ten khong duoc rong. Giu nguyen: " + this.name);
            return;
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || email.indexOf('@') <= 0 || email.endsWith("@")) {
            System.out.println("Loi: Email '" + email + "' khong hop le. Giu nguyen: '" + this.email + "'");
            return;
        }
        this.email = email;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            System.out.println("Loi: GPA " + gpa + " phai trong khoang [0.0, 4.0]. Giu nguyen: " + this.gpa);
            return;
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name
                + "', email='" + email + "', gpa=" + gpa + "}";
    }

    // ===== HÀM MAIN =====
    public static void main(String[] args) {
        System.out.println("=== Cach 1: Constructor khong tham so ===");
        Student s1 = new Student();
        System.out.println(s1);

        System.out.println("\n=== Cach 2: Constructor (id, name) ===");
        Student s2 = new Student("SV002", "Tran Thi B");
        System.out.println(s2);

        System.out.println("\n=== Cach 3: Constructor day du tham so ===");
        Student s3 = new Student("SV003", "Le Van C", "c@gmail.com", 3.5);
        System.out.println(s3);

        System.out.println("\n=== Cach 4: Copy constructor ===");
        Student s4 = new Student(s3);
        System.out.println(s4);

        System.out.println("\n=== Thu gan GPA khong hop le ===");
        s3.setGpa(-1.5);
        s3.setGpa(4.5);
        System.out.println("GPA cua s3 sau khi gan sai: " + s3.getGpa());

        System.out.println("\n=== Truyen GPA sai tu constructor ===");
        Student s5 = new Student("SV005", "Pham D", "d@gmail.com", -2.0);
        System.out.println(s5);
    }
}
