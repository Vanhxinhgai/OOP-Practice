package W3.B3_5;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        int n = Integer.parseInt(sc.nextLine().trim());
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            char type = line.charAt(0);
            int first = line.indexOf('"');
            int last = line.lastIndexOf('"');
            String name = line.substring(first + 1, last);
            String[] nums = line.substring(last + 1).trim().split("\\s+");
            String id = "NV" + (i + 1);
            String dob = "N/A";
            if (type == 'F') {
                employees[i] = new FullTimeEmployee(id, name, dob,
                        Double.parseDouble(nums[0]),
                        Double.parseDouble(nums[1]),
                        Double.parseDouble(nums[2]));
            } else {
                employees[i] = new PartTimeEmployee(id, name, dob,
                        Double.parseDouble(nums[0]),
                        Double.parseDouble(nums[1]));
            }
        }

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
