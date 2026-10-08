package W3.B3_5;

public abstract class Employee {
    private String id;
    private String name;
    private String dob;
    public Employee(String id, String name, String dob){
        this.id=id;
        this.name=name;
        this.dob=dob;
    }
    public String getId() { return id; }
    public String getName(){ return name; }
    public String getDob(){ return dob; }
    public abstract double calculateSalary();
    public abstract String getType();
    @Override
    public String toString() {
        return name + " - "+getType() + " - " +calculateSalary();

    }
}
