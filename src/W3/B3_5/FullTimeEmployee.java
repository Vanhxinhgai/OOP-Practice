package W3.B3_5;

public class FullTimeEmployee extends Employee{
    private double baseSalary;
    private double bonus;
    private double penalty;
    public FullTimeEmployee(String id, String name, String dob, double baseSalary, double bonus, double penalty){
        super(id, name, dob);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }
    @Override
    public double calculateSalary(){
        return baseSalary + (bonus - penalty);
    }
    @Override
    public String getType(){
        return "Full-time";
    }
}
