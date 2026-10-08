package W2.B2_4_CompositionCopy;

public class Employee {
    private String name;
    private MyDate birthday;

    public Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = new MyDate(birthday);
    }

    public Employee(Employee other) {
        this.name = other.name;
        this.birthday = new MyDate(other.birthday);
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
