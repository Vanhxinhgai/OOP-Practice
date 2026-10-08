package W3.B3_5;

public class PartTimeEmployee extends Employee {
    private double workingHours;
    private double hourlyRate;
    public PartTimeEmployee(String id, String name, String dob,
                            double workingHours, double hourlyRate) {
        super(id, name, dob);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }
    @Override
    public String getType() {
        return "Part-time";
    }
}
