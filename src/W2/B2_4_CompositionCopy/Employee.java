package W2.B2_4_CompositionCopy;

public class Employee {
    private String name;
    private MyDate birthday;

    // Constructor thường: cũng sao chép MyDate để không dùng chung với bên ngoài
    public Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = new MyDate(birthday);
    }

    // COPY CONSTRUCTOR - DEEP COPY
    public Employee(Employee other) {
        this.name = other.name;                     // String bất biến -> dùng chung an toàn
        this.birthday = new MyDate(other.birthday); // tạo MyDate MỚI
    }

    public String getName()     { return name; }
    public MyDate getBirthday() { return birthday; }

    public void setName(String name)        { this.name = name; }
    public void setBirthday(MyDate birthday) { this.birthday = new MyDate(birthday); }

    @Override
    public String toString() {
        return "Employee[name=" + name + ", birthday=" + birthday + "]";
    }
}
