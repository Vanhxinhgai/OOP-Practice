package W2.B2_2_Student;

public class Student {
    private String id;
    private String name;
    private String email;
    private double gpa;

    public Student() {
        this.id = "UNKNOWN";
        this.name = "Chưa có tên";
        this.email = "";
        this.gpa = 0.0;
    }

    public Student(String id, String name) {
        this();
        setId(id);
        setName(name);
    }

    public Student(String id, String name, String email, double gpa) {
        this(id, name);
        setEmail(email);
        setGpa(gpa);
    }

    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.gpa = other.gpa;
    }

    public String getId()    { return id; }
    public String getName()  { return name; }
    public String getEmail() { return email; }
    public double getGpa()   { return gpa; }
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("[LỖI] Mã SV không được để trống. Giữ nguyên: " + this.id);
            return;
        }
        this.id = id.trim();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("[LỖI] Tên không được để trống. Giữ nguyên: " + this.name);
            return;
        }
        this.name = name.trim();
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            System.out.println("[LỖI] Email '" + email + "' không hợp lệ. Giữ nguyên: '" + this.email + "'");
            return;
        }
        this.email = email.trim();
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            System.out.println("[LỖI] GPA phải từ 0.0 đến 4.0 (nhận được " + gpa
                    + "). Giữ nguyên: " + this.gpa);
            return;
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Student[id=%s, name=%s, email=%s, gpa=%.2f]",
                id, name, email, gpa);
    }
}
